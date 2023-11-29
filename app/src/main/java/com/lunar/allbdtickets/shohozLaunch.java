package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class shohozLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shohoz_launch);

        WebView shohozLaunchWeb = (WebView) findViewById(R.id.shohozLaunchWeb);


        WebSettings websettings = shohozLaunchWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        shohozLaunchWeb.loadUrl("https://www.shohoz.com/launch/");

        shohozLaunchWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        shohozLaunchWeb.getSettings().setBuiltInZoomControls(true);
        shohozLaunchWeb.getSettings().setUseWideViewPort(true);
        shohozLaunchWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(shohozLaunch.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        shohozLaunchWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(shohozLaunch.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}