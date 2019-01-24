package com.nncq.signin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nncq.signin.StaticValues.StaticValues;
import com.nncq.signin.tools.DesUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;


public class SignInFingerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private ImageView finger_img;



    //指纹
    private FingerprintManagerCompat fingerprintManager;

    private CancellationSignal mCancellationSignal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_finger);
        initView();
        initData();
        initEvent();
    }

    public void initData() {
        fingerprintManager = FingerprintManagerCompat.from(this);
    }

    public void initView() {
        back = (ImageView) findViewById(R.id.finger_back);
        finger_img = (ImageView) findViewById(R.id.finger_img);
    }

    public void initEvent() {
        back.setOnClickListener(this);
        FingerprintManagerCompat.AuthenticationCallback myPingerCalled = new FingerprintManagerCompat.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errMsgId, CharSequence errString) {
                super.onAuthenticationError(errMsgId, errString);

                finger_img.setImageTintList(ColorStateList.valueOf(Color.rgb(255, 60, 0)));

            }

            @Override
            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                super.onAuthenticationHelp(helpMsgId, helpString);
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                String id = sp.getString("staff_id", null);
                send(id);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                finger_img.setImageTintList(ColorStateList.valueOf(Color.rgb(200, 200, 0)));
            }
        };

        mCancellationSignal = new CancellationSignal();

        fingerprintManager.authenticate(null, 0, mCancellationSignal, myPingerCalled, null);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finger_back:
                mCancellationSignal.cancel();
                this.finish();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCancellationSignal.cancel();
    }


    private void send(final String staff_id) {
        //开启线程，发送请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                    HttpURLConnection connection = null;
                    BufferedReader reader = null;
                    try {
                        URL url = new URL("http://" + StaticValues.serviceIP + "/checkManage/submitCheck?staff_id="+staff_id );// + DesUtils.encrypt(staff_id.getBytes(),"0823")
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
                        show(result.toString());
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


    private void show(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    if (jsonObject.get("code").toString().compareTo("100")==0){
                        Toast.makeText(SignInFingerActivity.this, "完成", Toast.LENGTH_SHORT).show();
                        SignInFingerActivity.this.finish();
                    }else {
                        Toast.makeText(SignInFingerActivity.this,"账号过期",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
