package com.nncq.signin;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.nncq.signin.StaticValues.StaticValues;
import com.nncq.signin.tools.Datetool;
import com.nncq.signin.tools.LocationUtils;

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
import java.util.List;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    //打卡信息
    private TextView morning_start;
    private TextView morning_end;
    private TextView my_morning_start;
    private TextView my_morning_end;
    private TextView dk_morning_start;
    private TextView dk_morning_end;
    private TextView afternoon_start;
    private TextView afternoon_end;
    private TextView my_afternoon_start;
    private TextView my_afternoon_end;
    private TextView dk_afternoon_start;
    private TextView dk_afternoon_end;
    private TextView night_start;
    private TextView night_end;
    private TextView my_night_start;
    private TextView my_night_end;
    private TextView dk_night_start;
    private TextView dk_night_end;
    //打卡信息

    private LocationClient locationClient = null;
    private static final int UPDATE_TIME = 5000;
    private static int LOCATION_COUTNS = 0;

    private ImageView fingerImage;
    private ImageView faceImage;
    private LinearLayout finger;
    private LinearLayout face;
    private ImageView back;
    private Button loginOut;
    private TextView staffId;
    private TextView depName;
    private TextView posName;
    private double x, y;



    //指纹
    private FingerprintManagerCompat fingerprintManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }


    public void initView() {
        finger = (LinearLayout) findViewById(R.id.sign_in_finger);
        face = (LinearLayout) findViewById(R.id.sign_in_face);
        back = (ImageView) findViewById(R.id.sign_in_back);
        loginOut = (Button) findViewById(R.id.login_out);

        fingerImage = (ImageView) findViewById(R.id.finger_img);
        faceImage = (ImageView) findViewById(R.id.face_img);


        morning_start = (TextView) findViewById(R.id.morning_start);
        morning_end = (TextView) findViewById(R.id.morning_end);
        my_morning_start = (TextView) findViewById(R.id.my_morning_start);
        my_morning_end = (TextView) findViewById(R.id.my_morning_end);
        dk_morning_start = (TextView) findViewById(R.id.dk_morning_start);
        dk_morning_end = (TextView) findViewById(R.id.dk_morning_end);
        afternoon_start = (TextView) findViewById(R.id.afternoon_start);
        afternoon_end = (TextView) findViewById(R.id.afternoon_end);
        my_afternoon_start = (TextView) findViewById(R.id.my_afternoon_start);
        my_afternoon_end = (TextView) findViewById(R.id.my_afternoon_end);
        dk_afternoon_start = (TextView) findViewById(R.id.dk_afternoon_start);
        dk_afternoon_end = (TextView) findViewById(R.id.dk_afternoon_end);
        night_start = (TextView) findViewById(R.id.night_start);
        night_end = (TextView) findViewById(R.id.night_end);
        my_night_start = (TextView) findViewById(R.id.my_night_start);
        my_night_end = (TextView) findViewById(R.id.my_night_end);
        dk_night_start = (TextView) findViewById(R.id.dk_night_start);
        dk_night_end = (TextView) findViewById(R.id.dk_night_end);
        depName = (TextView) findViewById(R.id.department_name);
        posName = (TextView) findViewById(R.id.position_name);

        staffId = (TextView) findViewById(R.id.staff_id);
        SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);

        staffId.setText(sp.getString("staff_name", null));
        depName.setText("部门：" + sp.getString("department_name", null));
        posName.setText("职位：" + sp.getString("position_name", null));
        // Using the Android Support Library v4
        fingerprintManager = FingerprintManagerCompat.from(this);
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(this.KEYGUARD_SERVICE);
        if (!fingerprintManager.isHardwareDetected()) {
            fingerImage.setImageResource(R.drawable.no);
            finger.setEnabled(false);
            showDialog("硬件不支持", "你的设备不支持指纹识别,指纹签到无法使用");

        } else if (!keyguardManager.isKeyguardSecure()) {
            fingerImage.setImageResource(R.drawable.no);
            finger.setEnabled(false);
            showDialog("未启用密码", "在使用指纹识别前需要您前往设置添加pin或图形密码");

        } else if (!fingerprintManager.hasEnrolledFingerprints()) {
            fingerImage.setImageResource(R.drawable.no);
            finger.setEnabled(false);
            showDialog("未录入指纹", "在使用指纹识别前需要您前往设置添加指纹");
        }


    }

    public void initEvent() {
        finger.setOnClickListener(this);
        face.setOnClickListener(this);
        back.setOnClickListener(this);
        loginOut.setOnClickListener(this);

        locationClient = new LocationClient(this);
        //设置定位条件
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);        //是否打开GPS
        option.setCoorType("bd09ll");       //设置返回值的坐标类型。
        option.setPriority(LocationClientOption.GpsFirst); //设置定位优先级
        option.setProdName("Location");      //设置产品线名称。强烈建议您使用自定义的产品线名称，方便我们以后为您提供更高效准确的定位服务。
        option.setScanSpan(UPDATE_TIME);      //设置定时定位的时间间隔。单位毫秒
        locationClient.setLocOption(option);
        locationClient.registerLocationListener(new BDLocationListener() {

            @Override
            public void onReceiveLocation(BDLocation location) {
                // TODO Auto-generated method stub
                if (location == null) {
                    return;
                }

                x = location.getLongitude();
                y = location.getLatitude();
                Log.d("2222222", x + " " + y + " CODE+" + location.getLocType());
                if (location.getLocType() == 61 || location.getLocType() == 66 || location.getLocType() == 161) {
                    locationClient.stop();
                    fingerImage.setImageResource(R.drawable.nothing);
                    finger.setEnabled(true);

                    faceImage.setImageResource(R.drawable.nothing);
                    face.setEnabled(true);

                    SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                    String id = sp.getString("staff_id", null);
                    getCheckSetting(id);

                } else {
                    faceImage.setImageResource(R.drawable.no);
                    face.setEnabled(false);

                    fingerImage.setImageResource(R.drawable.no);
                    finger.setEnabled(false);
                    Toast.makeText(SignInActivity.this, "定位未成功", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        initView();
        initEvent();

        locationClient.start();
        /*
         *当所设的整数值大于等于1000（ms）时，定位SDK内部使用定时定位模式。
         *调用requestLocation( )后，每隔设定的时间，定位SDK就会进行一次定位。
         *如果定位SDK根据定位依据发现位置没有发生变化，就不会发起网络请求，
         *返回上一次定位的结果；如果发现位置改变，就进行网络请求进行定位，得到新的定位结果。
         *定时定位时，调用一次requestLocation，会定时监听到定位结果。
         */
        locationClient.requestLocation();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_finger:
                startActivity(new Intent(this, SignInFingerActivity.class));
                break;
            case R.id.sign_in_face:
                startActivity(new Intent(this, SignInFaceActivity.class));
                break;
            case R.id.sign_in_back:
                startActivity(new Intent(this, BroweActivity.class));
                break;
            case R.id.login_out:
                SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                sp.edit().putString("staff_id", null).commit();
                startActivity(new Intent(this, LoginActivity.class));
                this.finish();
                break;
        }
    }

    public void showDialog(String title, String context) {
        // no fingerprint sensor is detected, show dialog to tell user.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(context);
        //  builder.setIcon(R.drawable.ic_launcher_background);
        builder.setCancelable(false);
        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        // show this dialog.
        builder.create().show();
    }

    private void getCheckSetting(final String id) {
        //开启线程，发送请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {
                    URL url = new URL("http://" + StaticValues.serviceIP + "/app/getWACD?id=" + id);
                    connection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    connection.setRequestMethod("GET");
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

    /**
     * 展示
     *
     * @param result
     */
    private void show(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean WORK = false;
                    String mos = "";//上午上班时间
                    String moe = "";//上午下班时间
                    String afs = "";//下午上班时间
                    String afe = "";//下午下班时间
                    String nis = "";//晚上上班时间
                    String nie = "";//晚上下班时间
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.get("wAddress") != null) {

                        JSONObject wAddress = new JSONObject(jsonObject.get("wAddress").toString());
                        if (wAddress.get("range_on").toString().compareTo("on") == 0) {
                            double nowX = Double.parseDouble(wAddress.get("work_address_xy").toString().split(",")[0]);
                            double nowY = Double.parseDouble(wAddress.get("work_address_xy").toString().split(",")[1]);
                            Log.d("RRRRRRRRRRRRRRRRR", LocationUtils.getDistance(nowY, nowX, y, x) + " nowX" + nowX + " nowY" + nowY + " x" + x + " y" + y);
                            if (LocationUtils.getDistance(nowY, nowX, y, x) > Integer.parseInt(wAddress.get("range_value").toString())) {
                                faceImage.setImageResource(R.drawable.no);
                                face.setEnabled(false);
                                fingerImage.setImageResource(R.drawable.no);
                                finger.setEnabled(false);
                                showDialog("提示", "你不在签到范围内，无法签到");
                            }
                        }
                        if (wAddress.get("wifi_on").toString().compareTo("on") == 0) {
                            WifiManager mWifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                            if (mWifi.isWifiEnabled()) {
                                WifiInfo wifiInfo = mWifi.getConnectionInfo();
                                Log.d("wifi_mac", wifiInfo.getBSSID());
                                if (wAddress.get("wifi_mac").toString().compareTo(wifiInfo.getBSSID()) != 0) {
                                    faceImage.setImageResource(R.drawable.no);
                                    face.setEnabled(false);
                                    fingerImage.setImageResource(R.drawable.no);
                                    finger.setEnabled(false);
                                    Toast.makeText(SignInActivity.this, "尚未连接指定wifi，无法签到", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(SignInActivity.this, "尚未连接指定wifi，无法签到", Toast.LENGTH_LONG).show();
                            }

                        }
                        if (wAddress.get("face").toString().compareTo("on") != 0) {
                            faceImage.setImageResource(R.drawable.no);
                            face.setEnabled(false);
                        }
                        if (wAddress.get("finger").toString().compareTo("on") != 0) {
                            fingerImage.setImageResource(R.drawable.no);
                            finger.setEnabled(false);
                        }

                        if (wAddress.get("morning_start").toString().compareTo("") == 0) {
                            morning_start.setText("上班时间 无班");
                        } else {
                            mos = wAddress.get("morning_start").toString();
                            morning_start.setText("上班时间 " + wAddress.get("morning_start").toString());
                            WORK = true;
                        }

                        if (wAddress.get("morning_end").toString().compareTo("") == 0) {
                            morning_end.setText("下班时间 无班");
                        } else {
                            moe = wAddress.get("morning_end").toString();
                            morning_end.setText("下班时间 " + wAddress.get("morning_end").toString());
                        }

                        if (wAddress.get("afternoon_start").toString().compareTo("") == 0) {
                            afternoon_start.setText("上班时间 无班");
                        } else {
                            afs = wAddress.get("afternoon_start").toString();
                            afternoon_start.setText("上班时间 " + wAddress.get("afternoon_start").toString());
                            WORK = true;
                        }

                        if (wAddress.get("afternoon_end").toString().compareTo("") == 0) {
                            afternoon_end.setText("下班时间 无班");
                        } else {
                            afe = wAddress.get("afternoon_end").toString();
                            afternoon_end.setText("下班时间 " + wAddress.get("afternoon_end").toString());
                        }

                        if (wAddress.get("night_start").toString().compareTo("") == 0) {
                            night_start.setText("上班时间 无班");
                        } else {
                            nis = wAddress.get("night_start").toString();
                            night_start.setText("上班时间 " + wAddress.get("night_start").toString());
                            WORK = true;
                        }

                        if (wAddress.get("night_end").toString().compareTo("") == 0) {
                            night_end.setText("下班时间 无班");
                        } else {
                            nie = wAddress.get("night_end").toString();
                            night_end.setText("下班时间 " + wAddress.get("night_end").toString());
                        }
                    } else {
                        Toast.makeText(SignInActivity.this, "你所在工作地址不支持打卡", Toast.LENGTH_LONG).show();
                    }

                    //获取签到状态
                    if (jsonObject.get("checkDetailed").toString().compareTo("") != 0) {
                        JSONObject checkDetailed = new JSONObject(jsonObject.get("checkDetailed").toString());
                        JSONObject checkRule = new JSONObject(jsonObject.get("checkRule").toString());
                        if (mos != "") {
                            if (checkDetailed.get("check_detailed__time1").toString().compareTo("") == 0) {
                                dk_morning_start.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(checkDetailed.get("check_detailed__time1").toString(), mos);
                                dk_morning_start.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule1").toString())) {
                                    dk_morning_start.setText("迟到 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule2").toString())) {
                                    dk_morning_start.setText("迟到 " + jg + "分钟 记旷工" + checkRule.get("rule3").toString() + "天");
                                }
                                my_morning_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time1").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time1").toString().compareTo("") != 0) {
                                dk_morning_start.setText("已打卡");
                                my_morning_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time1").toString());
                            } else {
                                my_morning_start.setText("打卡时间 无班");
                            }
                        }

                        if (moe != "") {
                            if (checkDetailed.get("check_detailed__time2").toString().compareTo("") == 0) {
                                dk_morning_end.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(moe, checkDetailed.get("check_detailed__time2").toString());
                                dk_morning_end.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule4").toString())) {
                                    dk_morning_end.setText("早退 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule5").toString())) {
                                    dk_morning_end.setText("早退 " + jg + "分钟 记旷工" + checkRule.get("rule6").toString() + "天");
                                }
                                my_morning_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time2").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time2").toString().compareTo("") != 0) {
                                dk_morning_end.setText("已打卡");
                                my_morning_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time2").toString());
                            } else {
                                my_morning_end.setText("打卡时间 无班");
                            }
                        }


                        if (afs != "") {
                            if (checkDetailed.get("check_detailed__time3").toString().compareTo("") == 0) {
                                dk_afternoon_start.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(checkDetailed.get("check_detailed__time3").toString(), afs);
                                dk_afternoon_start.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule1").toString())) {
                                    dk_afternoon_start.setText("迟到 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule2").toString())) {
                                    dk_afternoon_start.setText("迟到 " + jg + "分钟 记旷工" + checkRule.get("rule3").toString() + "天");
                                }
                                my_afternoon_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time3").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time3").toString().compareTo("") != 0) {
                                dk_afternoon_start.setText("已打卡");
                                my_afternoon_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time3").toString());
                            } else {
                                my_afternoon_start.setText("打卡时间 无班");
                            }
                        }

                        if (afe != "") {
                            if (checkDetailed.get("check_detailed__time4").toString().compareTo("") == 0) {
                                dk_afternoon_end.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(afe, checkDetailed.get("check_detailed__time4").toString());
                                dk_afternoon_end.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule4").toString())) {
                                    dk_afternoon_end.setText("早退 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule5").toString())) {
                                    dk_afternoon_end.setText("早退 " + jg + "分钟 记旷工" + checkRule.get("rule6").toString() + "天");
                                }
                                my_afternoon_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time4").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time4").toString().compareTo("") != 0) {
                                dk_afternoon_end.setText("已打卡");
                                my_afternoon_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time4").toString());
                            } else {
                                my_afternoon_end.setText("打卡时间 无班");
                            }
                        }

                        if (nis != "") {
                            if (checkDetailed.get("check_detailed__time5").toString().compareTo("") == 0) {
                                dk_night_start.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(checkDetailed.get("check_detailed__time5").toString(), afs);
                                dk_night_start.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule1").toString())) {
                                    dk_night_start.setText("迟到 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule2").toString())) {
                                    dk_night_start.setText("迟到 " + jg + "分钟 记旷工" + checkRule.get("rule3").toString() + "天");
                                }
                                my_night_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time5").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time5").toString().compareTo("") != 0) {
                                dk_night_start.setText("已打卡");
                                my_night_start.setText("打卡时间 " + checkDetailed.get("check_detailed__time5").toString());
                            } else {
                                my_night_start.setText("打卡时间 无班");
                            }
                        }

                        if (nie != "") {
                            if (checkDetailed.get("check_detailed__time6").toString().compareTo("") == 0) {
                                dk_night_end.setText("未打卡");
                                WORK = true;
                            } else {
                                long jg = Datetool.getMinOfDateToDate(afe, checkDetailed.get("check_detailed__time6").toString());
                                dk_night_end.setText("已打卡");
                                if (jg > Long.parseLong(checkRule.get("rule4").toString())) {
                                    dk_night_end.setText("早退 " + jg + "分钟");
                                }
                                if (jg > Long.parseLong(checkRule.get("rule5").toString())) {
                                    dk_night_end.setText("早退 " + jg + "分钟 记旷工" + checkRule.get("rule6").toString() + "天");
                                }
                                my_night_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time6").toString());
                            }
                        } else {
                            if (checkDetailed.get("check_detailed__time6").toString().compareTo("") != 0) {
                                dk_night_end.setText("已打卡");
                                my_night_end.setText("打卡时间 " + checkDetailed.get("check_detailed__time6").toString());
                            } else {
                                my_night_end.setText("打卡时间 无班");
                            }
                        }

                    } else {
                        dk_morning_start.setText("未打卡");
                        dk_morning_end.setText("未打卡");
                        dk_afternoon_start.setText("未打卡");
                        dk_afternoon_end.setText("未打卡");
                        dk_night_start.setText("未打卡");
                        dk_night_end.setText("未打卡");

                    }


                    if (!WORK) {
                        faceImage.setImageResource(R.drawable.no);
                        face.setEnabled(false);
                        fingerImage.setImageResource(R.drawable.no);
                        finger.setEnabled(false);
                        showDialog("无班", "当前没有上班安排，无需打卡");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationClient != null && locationClient.isStarted()) {
            locationClient.stop();
            locationClient = null;
        }
    }

}
