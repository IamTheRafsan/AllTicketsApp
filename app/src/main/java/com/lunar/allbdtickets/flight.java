package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class flight extends AppCompatActivity {

    LinearLayout gozayaan,sharetrip,flightExpert,bimanBangladesh,usBangla,novoAir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);


        gozayaan = findViewById(R.id.gozayaan);
        sharetrip = findViewById(R.id.sharetrip);
        flightExpert = findViewById(R.id.flightExpert);
        bimanBangladesh = findViewById(R.id.bimanBangladesh);
        usBangla = findViewById(R.id.usBangla);
        novoAir = findViewById(R.id.novoAir);

        gozayaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, gozayaan.class);
                startActivity(myIntent);
            }
        });

        sharetrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, sharetrip.class);
                startActivity(myIntent);
            }
        });

        flightExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, flightExpert.class);
                startActivity(myIntent);
            }
        });

        bimanBangladesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, bimanBangladesh.class);
                startActivity(myIntent);
            }
        });

        usBangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, usBangla.class);
                startActivity(myIntent);
            }
        });

        novoAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(flight.this, novoAir.class);
                startActivity(myIntent);
            }
        });

    }
}