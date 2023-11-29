package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class launch extends AppCompatActivity {

    LinearLayout shohozLaunch, bdTicketsLaunch, launchBdLaunch, paribahnLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        shohozLaunch = findViewById(R.id.shohozLaunch);
        bdTicketsLaunch = findViewById(R.id.bdTicketsLaunch);
        launchBdLaunch = findViewById(R.id.launchBdLaunch);
        paribahnLaunch = findViewById(R.id.paribahnLaunch);


        shohozLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(launch.this, shohozLaunch.class);
                startActivity(myintent);
            }
        });

        bdTicketsLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(launch.this, bdTicketsLaunch.class);
                startActivity(myintent);
            }
        });

        launchBdLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(launch.this, launchBd.class);
                startActivity(myIntent);
            }
        });

        paribahnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(launch.this, paribahnLaunch.class);
                startActivity(myIntent);
            }
        });







    }
}