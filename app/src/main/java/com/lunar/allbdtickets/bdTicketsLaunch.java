package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class bdTicketsLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_tickets_launch);

        WebView bdTicketsLaunchWeb = (WebView) findViewById(R.id.bdTicketsLaunchWeb);


        WebSettings settings = bdTicketsLaunchWeb.getSettings();
        settings.setDomStorageEnabled(true);
        WebSettings websettings = bdTicketsLaunchWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        bdTicketsLaunchWeb.loadUrl("https://bdtickets.com/launch");

        bdTicketsLaunchWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        bdTicketsLaunchWeb.getSettings().setBuiltInZoomControls(true);
        bdTicketsLaunchWeb.getSettings().setUseWideViewPort(true);
        bdTicketsLaunchWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(bdTicketsLaunch.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        bdTicketsLaunchWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(bdTicketsLaunch.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });


    }
}