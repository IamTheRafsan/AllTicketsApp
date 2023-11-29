package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class novoAir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_air);

        WebView novoAir = (WebView) findViewById(R.id.novoAir);


        WebSettings websettings =novoAir.getSettings();
        websettings.setJavaScriptEnabled(true);

        novoAir.loadUrl("https://www.flynovoair.com/");

        novoAir.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        novoAir.getSettings().setBuiltInZoomControls(true);
        novoAir.getSettings().setUseWideViewPort(true);
        novoAir.getSettings().setLoadWithOverviewMode(true);

        ProgressDialog progressDialog = new ProgressDialog(novoAir.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        novoAir.setWebViewClient(new WebViewClient() {
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
                Toast.makeText(novoAir.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });


    }
}