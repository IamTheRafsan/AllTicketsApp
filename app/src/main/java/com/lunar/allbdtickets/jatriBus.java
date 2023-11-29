package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class jatriBus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jatri_bus);


        WebView jatriBusWeb = (WebView) findViewById(R.id.jatriBusWeb);


        WebSettings websettings = jatriBusWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        jatriBusWeb.loadUrl("https://ticket.jatri.co/");

        jatriBusWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        jatriBusWeb.getSettings().setBuiltInZoomControls(true);
        jatriBusWeb.getSettings().setUseWideViewPort(true);
        jatriBusWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(jatriBus.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        jatriBusWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(jatriBus.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}