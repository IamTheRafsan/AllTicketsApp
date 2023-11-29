package com.lunar.allbdtickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class transport extends AppCompatActivity {

    LinearLayout train, bus, launch, plane;
    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        train = findViewById(R.id.train);
        bus = findViewById(R.id.bus);
        launch = findViewById(R.id.launch);
        plane = findViewById(R.id.plane);
        imageSlider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.header1,null));
        imageList.add(new SlideModel(R.drawable.header2,null));

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);



        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(transport.this, trainWeb.class);
                startActivity(myIntent);
            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(transport.this, bus.class);
                startActivity(myIntent);
            }
        });

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(transport.this, launch.class);
                startActivity(myIntent);
            }
        });

        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(transport.this, flight.class);
                startActivity(myIntent);
            }
        });



    }
}