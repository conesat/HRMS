package com.nncq.signin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nncq.signin.StaticValues.StaticValues;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText accounting;
    private EditText password;
    private Button login;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    public void initView() {
        accounting = (EditText) findViewById(R.id.login_staff_accounting);
        password = (EditText) findViewById(R.id.login_staff_password);
        login = (Button) findViewById(R.id.login);
        back = (ImageView) findViewById(R.id.login_back);
    }

    public void initEvent() {
        login.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                this.finish();
                break;
            case R.id.login:
                if (accounting.getText().toString().compareTo("") == 0) {
                    Toast.makeText(this, "请输入工号或身份证号", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().compareTo("") == 0) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else {
                    send(accounting.getText().toString(), password.getText().toString());
                   /* SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                    sp.edit().putString("staf_id", "1").commit();
                    startActivity(new Intent(this,SignInActivity.class));
                    this.finish();*/
                }
                break;
        }
    }

    private void send(final String staff_id, final String staff_password) {
        //开启线程，发送请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://" + StaticValues.serviceIP + "/appLogin?staff_id=" + staff_id + "&staff_password=" + staff_password);
                    connection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    connection.setRequestMethod("POST");
                    //设置连接超时时间（毫秒）
                    connection.setConnectTimeout(5000);
                    //设置读取超时时间（毫秒）
                    connection.setReadTimeout(5000);
                    //返回输入流
                    InputStream in = connection.getInputStream();
                    //读取输入流
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    show(result.toString(), staff_password);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {//关闭连接
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }


    private void show(final String result, final String staff_password) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.get("code").toString().compareTo("100") == 0) {
                        JSONObject staff = new JSONObject(jsonObject.get("staff").toString());
                        SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                        Log.d("staff", staff.toString());
                        sp.edit().putString("position_name", staff.get("position_name").toString()).commit();
                        sp.edit().putString("department_name", staff.get("department_name").toString()).commit();
                        sp.edit().putString("staff_id", staff.get("staff_id").toString()).commit();
                        sp.edit().putString("staff_name", staff.get("staff_name").toString()).commit();
                        sp.edit().putString("staff_person_picture", staff.get("staff_person_picture").toString()).commit();
                        sp.edit().putString("staff", staff.toString()).commit();
                        sp.edit().putString("staff_password", staff_password).commit();
                        Toast.makeText(LoginActivity.this, staff.getString("staff_name") + ":登录成功", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, SignInActivity.class));
                        LoginActivity.this.finish();
                    } else if (jsonObject.get("code").toString().compareTo("101") == 0) {
                        Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_LONG).show();
                    } else if (jsonObject.get("code").toString().compareTo("102") == 0) {
                        Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
