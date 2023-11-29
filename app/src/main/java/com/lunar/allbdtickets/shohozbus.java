package com.lunar.allbdtickets;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class shohozbus<ContestActivity> extends AppCompatActivity {

    WebView shohozBusWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shohozbus);

        WebView shohozBusWeb = (WebView) findViewById(R.id.shohozBusWeb);

        WebSettings websettings = shohozBusWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        shohozBusWeb.loadUrl("https://www.shohoz.com/bus-tickets");

        shohozBusWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        shohozBusWeb.getSettings().setBuiltInZoomControls(true);
        shohozBusWeb.getSettings().setUseWideViewPort(true);
        shohozBusWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(shohozbus.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        shohozBusWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(shohozbus.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}





