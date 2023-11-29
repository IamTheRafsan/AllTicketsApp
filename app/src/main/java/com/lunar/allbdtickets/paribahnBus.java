package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class paribahnBus extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paribahn_bus);

        WebView paribahnBusWeb = (WebView) findViewById(R.id.paribahnBusWeb);


        WebSettings settings = paribahnBusWeb.getSettings();
        settings.setDomStorageEnabled(true);

        WebSettings websettings = paribahnBusWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        paribahnBusWeb.loadUrl("https://paribahan.com/bus");

        paribahnBusWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        paribahnBusWeb.getSettings().setBuiltInZoomControls(true);
        paribahnBusWeb.getSettings().setUseWideViewPort(true);
        paribahnBusWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(paribahnBus.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        paribahnBusWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(paribahnBus.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });




    }
}