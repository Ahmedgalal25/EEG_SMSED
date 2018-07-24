package com.example.galal1.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Galal1 on 7/17/2018.
 */

public class MainActivity extends Activity  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.main_activity);
        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent firstavtivity = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(firstavtivity);

            }

        });

        //Intent firstavtivity = new Intent(MainActivity.this, FirstActivity.class);

        // Start the new activity
        //startActivity(firstavtiviry);
        ImageView imgView = (ImageView) findViewById(R.id.logo);
        imgView.setImageResource(R.drawable.appicon);
        final  Handler handler = new Handler();


    }


}