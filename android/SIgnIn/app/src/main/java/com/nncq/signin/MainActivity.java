package com.nncq.signin;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nncq.signin.StaticValues.StaticValues;

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
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private final int SDK_PERMISSION_REQUEST = 127;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPersimmions();

        SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
        String id = sp.getString("staff_id", null);

        if (id == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            this.finish();
        } else {
            String staff_password = sp.getString("staff_password", null);
            send(id.toString(), staff_password.toString());
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
            this.finish();
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            //requestCode即所声明的权限获取码，在checkSelfPermission时传入
            case 1:
                BAIDU_READ_PHONE_STATE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //获取到权限，做相应处理
                    //调用定位SDK应确保相关权限均被授权，否则会引起定位失败
                } else {
                    this.finish();
                }
                break;
            default:
                break;
        }
    }


    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (checkSelfPermission(android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.READ_PHONE_STATE);
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
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
                    // res=result.toString();
                    show(result.toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "无法连接服务器", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    MainActivity.this.finish();
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

                    } else {
                        Toast.makeText(MainActivity.this, "账号过期", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        MainActivity.this.finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
