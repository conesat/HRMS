package com.nncq.signin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.arcsoft.facerecognition.AFR_FSDKEngine;
import com.arcsoft.facerecognition.AFR_FSDKError;
import com.arcsoft.facerecognition.AFR_FSDKFace;
import com.arcsoft.facerecognition.AFR_FSDKMatching;
import com.arcsoft.facerecognition.AFR_FSDKVersion;
import com.arcsoft.facetracking.AFT_FSDKEngine;
import com.arcsoft.facetracking.AFT_FSDKError;
import com.arcsoft.facetracking.AFT_FSDKFace;
import com.arcsoft.facetracking.AFT_FSDKVersion;
import com.guo.android_extend.image.ImageConverter;
import com.guo.android_extend.java.AbsLoop;
import com.guo.android_extend.tools.CameraHelper;
import com.guo.android_extend.widget.CameraFrameData;
import com.guo.android_extend.widget.CameraGLSurfaceView;
import com.guo.android_extend.widget.CameraSurfaceView;
import com.guo.android_extend.widget.CameraSurfaceView.OnCameraListener;
import com.nncq.signin.StaticValues.StaticValues;
import com.nncq.signin.tools.NV21Tools;
import com.nncq.signin.view.ArcView;

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
import java.util.List;


public class SignInFaceActivity extends AppCompatActivity implements OnCameraListener, View.OnTouchListener, Camera.AutoFocusCallback, View.OnClickListener {
    private final String TAG = this.getClass().getSimpleName();

    private int mWidth, mHeight, mFormat;
    private CameraSurfaceView mSurfaceView;
    private CameraGLSurfaceView mGLSurfaceView;
    private Camera mCamera;
    public static SignInFaceActivity registerFaceActivity;

    AFR_FSDKVersion versionM = new AFR_FSDKVersion();
    AFR_FSDKEngine engineM = new AFR_FSDKEngine();
    AFR_FSDKFace resultM = new AFR_FSDKFace();

    AFT_FSDKVersion version = new AFT_FSDKVersion();
    AFT_FSDKEngine engine = new AFT_FSDKEngine();
    List<AFT_FSDKFace> result = new ArrayList<>();
    int mCameraID;
    int mCameraRotate;
    boolean mCameraMirror;
    byte[] mImageNV21 = null;
    FRAbsLoop mFRAbsLoop = null;
    AFT_FSDKFace mAFT_FSDKFace = null;

    Handler mHandler;

    ImageView back;

    ArcView arcView;

    ImageView test_FACE;
    //加载框变量
    private ProgressDialog progressDialog;

    class FRAbsLoop extends AbsLoop {


        @Override
        public void setup() {

        }

        @Override
        public void loop() {
            if (mImageNV21 != null) {
                final int rotate = mCameraRotate;
                AFR_FSDKError error = engineM.AFR_FSDK_ExtractFRFeature(mImageNV21, mWidth, mHeight, AFR_FSDKEngine.CP_PAF_NV21, mAFT_FSDKFace.getRect(), mAFT_FSDKFace.getDegree(), resultM);
                Log.d("EERRRRRRRRRRR", error.getCode() + "");
                AFR_FSDKMatching score = new AFR_FSDKMatching();
                float max = 0.0f;
                if (StaticValues.mface != null) {
                    engineM.AFR_FSDK_FacePairMatching(resultM, StaticValues.mface, score);
                    max = score.getScore();
                }
                if (max > 0.8f && max < 1f) {
                    arcView.setProcess(1);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
                            final String staff_id = sp.getString("staff_id", null);//读取图片地址
                            send(staff_id);
                        }
                    });
                    this.shutdown();
                } else {
                    arcView.setProcess(0);
                }
                mHandler.post(runnableUi);
                mImageNV21 = null;
            }
        }

        @Override
        public void over() {
            AFR_FSDKError error = engineM.AFR_FSDK_UninitialEngine();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        registerFaceActivity = this;
        mCameraID = Camera.CameraInfo.CAMERA_FACING_FRONT;
        mCameraRotate = 270;
        mCameraMirror = true;
        mWidth = 1280;
        mHeight = 960;
        mFormat = ImageFormat.NV21;
        mHandler = new Handler();

        setContentView(R.layout.activity_sign_in_face);
        test_FACE = (ImageView) findViewById(R.id.test_FACE);
        mGLSurfaceView = (CameraGLSurfaceView) findViewById(R.id.glsurfaceView);
        mGLSurfaceView.setOnTouchListener(this);
        mSurfaceView = (CameraSurfaceView) findViewById(R.id.surfaceView);
        mSurfaceView.setOnCameraListener(this);
        mSurfaceView.setupGLSurafceView(mGLSurfaceView, true, mCameraMirror, mCameraRotate);
        mSurfaceView.debug_print_fps(true, false);
        back = (ImageView) findViewById(R.id.face_back);
        back.setOnClickListener(this);
        arcView = (ArcView) findViewById(R.id.arcView);

        AFT_FSDKError err = engine.AFT_FSDK_InitialFaceEngine(StaticValues.appid, StaticValues.ft_key, AFT_FSDKEngine.AFT_OPF_0_HIGHER_EXT, 16, 5);
        err = engine.AFT_FSDK_GetVersion(version);

        AFR_FSDKError error = engineM.AFR_FSDK_InitialEngine(StaticValues.appid, StaticValues.fr_key);
        Log.d(TAG, "AFR_FSDK_InitialEngine = " + error.getCode());
        error = engineM.AFR_FSDK_GetVersion(versionM);
        Log.d(TAG, "FR=" + version.toString() + "," + error.getCode()); //(210, 178 - 478, 446), degree = 1　780, 2208 - 1942, 3370
        //showProgressDialog(this, "加载中。。");

       // if (StaticValues.mface == null) {
            SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
            final String staff_person_picture = sp.getString("staff_person_picture", null);//读取图片地址
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    //Bitmap bmp = getURLimage("http://"+ StaticValues.serviceIP+"/file/getFile?path=" + staff_person_picture);//获取图片
                    Bitmap bmp = getURLimage("http://" + StaticValues.serviceIP + "/file/getFile?path=D:/sun_moon/staff/nncq0002/pic/imgThree.jpg");//获取图片
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = bmp;
                    System.out.println("000");
                    handle.sendMessage(msg);
                }
            }).start();
       /* } else {
            mFRAbsLoop = new FRAbsLoop();
            mFRAbsLoop.start();
        }*/

    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (mFRAbsLoop != null)
            mFRAbsLoop.shutdown();//关闭线程
        AFT_FSDKError err = engine.AFT_FSDK_UninitialFaceEngine();
    }

    @Override
    public Camera setupCamera() {
        // TODO Auto-generated method stub
        mCamera = Camera.open(mCameraID);
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewSize(mWidth, mHeight);
            parameters.setPreviewFormat(mFormat);
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            mCamera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mCamera != null) {
            mWidth = mCamera.getParameters().getPreviewSize().width;
            mHeight = mCamera.getParameters().getPreviewSize().height;
        }
        return mCamera;
    }

    @Override
    public void setupChanged(int format, int width, int height) {

    }

    @Override
    public boolean startPreviewImmediately() {
        return true;
    }

    @Override
    public Object onPreview(byte[] data, int width, int height, int format, long timestamp) {
        AFT_FSDKError err = engine.AFT_FSDK_FaceFeatureDetect(data, width, height, AFT_FSDKEngine.CP_PAF_NV21, result);//检测人脸
        if (mImageNV21 == null) {
            if (!result.isEmpty()) {
                mAFT_FSDKFace = result.get(0).clone();
                mImageNV21 = data.clone();
            } else {
                arcView.setProcess(0);
                new Thread() {
                    public void run() {
                        mHandler.post(runnableUi);
                    }
                }.start();
            }
        }
        result.clear();
        return new Rect[0];
    }

    @Override
    public void onBeforeRender(CameraFrameData data) {

    }

    @Override
    public void onAfterRender(CameraFrameData data) {
        mGLSurfaceView.getGLES2Render().draw_rect((Rect[]) data.getParams(), Color.GREEN, 2);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        CameraHelper.touchFocus(mCamera, event, v, this);
        return false;
    }

    @Override
    public void onAutoFocus(boolean success, Camera camera) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.face_back:
                this.finish();
                break;
        }
    }

    // 构建Runnable对象，在runnable中更新界面
    Runnable runnableUi = new Runnable() {
        @Override
        public void run() {
            //更新界面
            arcView.invalidate();
        }

    };

    //加载图片
    public Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            Log.d("URL", url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            //设置读取超时时间（毫秒）
            conn.setReadTimeout(5000);
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }

    //在消息队列中实现对控件的更改
    private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:

                    Bitmap mBitmap = (Bitmap) msg.obj;
                    test_FACE.setImageBitmap(mBitmap);
                 /*   if (dismissProgressDialog()) {
                        //超时处理
                    }*/
                    byte[] data = new byte[mBitmap.getWidth() * mBitmap.getHeight()*3/2];
                    try {
                        data = NV21Tools.getNV21(mBitmap.getWidth(), mBitmap.getHeight(), mBitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(SignInFaceActivity.this, "无法检测服务端人脸，请联系管理员，更换图片", Toast.LENGTH_LONG).show();
                        Log.d("www", 22 + "");
                        return;
                    }


                    AFT_FSDKError err = engine.AFT_FSDK_FaceFeatureDetect(data, mBitmap.getWidth(), mBitmap.getHeight(), AFT_FSDKEngine.CP_PAF_NV21, result);//检测人脸
                    if (!result.isEmpty()) {
                        AFR_FSDKError error = engineM.AFR_FSDK_ExtractFRFeature(data, mBitmap.getWidth(), mBitmap.getHeight(), AFR_FSDKEngine.CP_PAF_NV21, new Rect(result.get(0).getRect()), result.get(0).getDegree(), resultM);
                        result.clear();
                        if (resultM != null) {
                            StaticValues.mface = resultM.clone();
                            mFRAbsLoop = new FRAbsLoop();
                            mFRAbsLoop.start();
                        }
                    } else {
                        Log.d("www", 11 + "");
                        Toast.makeText(SignInFaceActivity.this, "无法检测服务端人脸，请联系管理员，更换图片", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }

        ;
    };


    private void send(final String staff_id) {
        //开启线程，发送请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://" + StaticValues.serviceIP + "/checkManage/submitCheck?staff_id=" + staff_id);// + DesUtils.encrypt(staff_id.getBytes(),"0823")
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
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.get("code").toString().compareTo("100") == 0) {
                        Toast.makeText(SignInFaceActivity.this, "完成", Toast.LENGTH_SHORT).show();
                        SignInFaceActivity.this.finish();
                    } else {
                        Toast.makeText(SignInFaceActivity.this, "账号过期", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
/*
    public void showProgressDialog(Context mContext, String text) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mContext);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(text);    //设置内容
        progressDialog.setCancelable(false);//点击屏幕和按返回键都不能取消加载框
        progressDialog.show();

        //设置超时自动消失
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //取消加载框
                if (dismissProgressDialog()) {
                    //超时处理
                }
            }
        }, 60000);//超时时间60秒
    }

    public Boolean dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                return true;//取消成功
            }
        }
        return false;//已经取消过了，不需要取消
    }*/


}


