package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class launchBd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_bd);

        WebView launcBdWeb = (WebView) findViewById(R.id.launchBdWeb);

        WebSettings websettings = launcBdWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        launcBdWeb.loadUrl("https://launchbd.com/");

        launcBdWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        launcBdWeb.getSettings().setBuiltInZoomControls(true);
        launcBdWeb.getSettings().setUseWideViewPort(true);
        launcBdWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(launchBd.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        launcBdWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(launchBd.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}