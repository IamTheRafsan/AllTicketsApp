package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class bus extends AppCompatActivity {

    LinearLayout shohozBus,bdticketsBus,busbdBus,paribahnBus,jatriBus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        shohozBus = findViewById(R.id.shohozBus);
        bdticketsBus = findViewById(R.id.bdticketsBus);
        busbdBus = findViewById(R.id.busbdBus);
        paribahnBus = findViewById(R.id.paribahnBus);
        jatriBus = findViewById(R.id.jatriBus);

        shohozBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(bus.this, shohozbus.class);
                startActivity(myIntent);


            }
        });

        bdticketsBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent2 = new Intent(bus.this, bdTicketsBus.class);
                startActivity(myIntent2);


            }
        });

        busbdBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(bus.this, busbdBus.class);
                startActivity(myIntent);


            }
        });

        paribahnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(bus.this, paribahnBus.class);
                startActivity(myIntent);


            }
        });

        jatriBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(bus.this, jatriBus.class);
                startActivity(myIntent);


            }
        });

    }
}