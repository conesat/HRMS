package com.nncq.signin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.itheima.view.BridgeWebView;
import com.nncq.signin.StaticValues.StaticValues;

public class BroweActivity extends AppCompatActivity {

    private BridgeWebView mBdwebview;
    private LinearLayout browser_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browe);
        browser_back=(LinearLayout)findViewById(R.id.browser_back);
        browser_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BroweActivity.this.finish();
            }
        });
        mBdwebview = (BridgeWebView) findViewById(R.id.bdwebview);//初始化BridgeWebView
        mBdwebview.getSettings().setJavaScriptEnabled(true);
        mBdwebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mBdwebview.getSettings().setSupportMultipleWindows(true);
        mBdwebview.setWebViewClient(new WebViewClient());
        mBdwebview.setWebChromeClient(new WebChromeClient());

        SharedPreferences sp = getSharedPreferences("nncq_sign_in", Context.MODE_PRIVATE);
        String staff_id = sp.getString("staff_id", null);
        String staff_password = sp.getString("staff_password", null);
        mBdwebview.postUrl("http://"+ StaticValues.serviceIP+"/login?staff_id="+staff_id+"&staff_password="+staff_password+"&staffType=1",null);
        mBdwebview.loadUrl("http://"+ StaticValues.serviceIP+"/gotoJsp?jsp=staff/index");

    }
}
