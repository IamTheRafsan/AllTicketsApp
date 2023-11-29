package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class bdTicketsBus extends AppCompatActivity {

    WebView bdticketsBusWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_tickets_bus);

        WebView bdticketsBusWeb = (WebView) findViewById(R.id.bdticketsBusWeb);

        WebSettings settings = bdticketsBusWeb.getSettings();
        settings.setDomStorageEnabled(true);

        WebSettings websettings = bdticketsBusWeb.getSettings();
        websettings.setJavaScriptEnabled(true);

        bdticketsBusWeb.loadUrl("https://bdtickets.com");

        bdticketsBusWeb.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        bdticketsBusWeb.getSettings().setBuiltInZoomControls(true);
        bdticketsBusWeb.getSettings().setUseWideViewPort(true);
        bdticketsBusWeb.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(bdTicketsBus.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        bdticketsBusWeb.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(bdTicketsBus.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
