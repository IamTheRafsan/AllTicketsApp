package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class trainWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_web);

        WebView trainTicWeb = (WebView) findViewById(R.id.trainTicWeb);


        WebSettings websettings = trainTicWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        trainTicWeb.loadUrl("https://eticket.railway.gov.bd/");

        trainTicWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        trainTicWeb.getSettings().setBuiltInZoomControls(true);
        trainTicWeb.getSettings().setUseWideViewPort(true);
        trainTicWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(trainWeb.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        trainTicWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(trainWeb.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });

    }
}