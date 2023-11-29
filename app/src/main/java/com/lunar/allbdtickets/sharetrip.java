package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class sharetrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharetrip);

        WebView sharetripWeb = (WebView) findViewById(R.id.sharetripWeb);


        WebSettings websettings = sharetripWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        sharetripWeb.loadUrl("https://sharetrip.net/");

        sharetripWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        sharetripWeb.getSettings().setBuiltInZoomControls(true);
        sharetripWeb.getSettings().setUseWideViewPort(true);
        sharetripWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(sharetrip.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        sharetripWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(sharetrip.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}