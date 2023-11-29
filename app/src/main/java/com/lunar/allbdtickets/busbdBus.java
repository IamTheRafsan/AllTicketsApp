package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class busbdBus extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busbd_bus);

        WebView busbdBusWeb = (WebView) findViewById(R.id.busbdBusWeb);

        WebSettings websettings = busbdBusWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        busbdBusWeb.loadUrl("https://busbd.com.bd/");

        busbdBusWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        busbdBusWeb.getSettings().setBuiltInZoomControls(true);
        busbdBusWeb.getSettings().setUseWideViewPort(true);
        busbdBusWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(busbdBus.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        busbdBusWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(busbdBus.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}