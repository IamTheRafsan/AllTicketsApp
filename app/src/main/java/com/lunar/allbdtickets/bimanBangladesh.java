package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class bimanBangladesh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biman_bangladesh);

        WebView bimanBangladesh = (WebView) findViewById(R.id.bimanBangladesh);


        WebSettings websettings =bimanBangladesh.getSettings();
        websettings.setJavaScriptEnabled(true);

        bimanBangladesh.loadUrl("https://www.biman-airlines.com/");

        bimanBangladesh.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        bimanBangladesh.getSettings().setBuiltInZoomControls(true);
        bimanBangladesh.getSettings().setUseWideViewPort(true);
        bimanBangladesh.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(bimanBangladesh.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        bimanBangladesh.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(bimanBangladesh.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}