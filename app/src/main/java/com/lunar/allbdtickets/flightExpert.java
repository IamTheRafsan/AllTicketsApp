package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class flightExpert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_expert);

        WebView flightExpert = (WebView) findViewById(R.id.flightExpert);


        WebSettings websettings = flightExpert.getSettings();
        websettings.setJavaScriptEnabled(true);

        flightExpert.loadUrl("https://flightexpert.com/");

        flightExpert.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        flightExpert.getSettings().setBuiltInZoomControls(true);
        flightExpert.getSettings().setUseWideViewPort(true);
        flightExpert.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(flightExpert.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        flightExpert.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(flightExpert.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}