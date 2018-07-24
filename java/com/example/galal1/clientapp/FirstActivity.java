package com.example.galal1.clientapp;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Galal1 on 7/1/2018.
 */

public class FirstActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_firstt.xml layout file
        setContentView(R.layout.activity_first);


        TextView eegSeizureDetection = (TextView) findViewById(R.id.eeg_seizure_detection);
        TextView eegDatabase = (TextView) findViewById(R.id.history);

        // Set a click listener on that View

        eegSeizureDetection.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                if (wifi.isWifiEnabled()) {
                    // Create a new intent to open the {@link NumbersActivity}
                    Intent eegSeizureDetectionIntent = new Intent(FirstActivity.this, StreamingClientsActivity.class);

                    // Start the new activity
                    startActivity(eegSeizureDetectionIntent);
                }
                else{

                    Toast.makeText(FirstActivity.this, "Wifi is not connected", Toast.LENGTH_SHORT).show();
                }
            }
        });



        eegDatabase.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                if (wifi.isWifiEnabled()) {
                    // Create a new intent to open the {@link NumbersActivity}
                    Intent eegDatabase = new Intent(FirstActivity.this, DatabaseClientsActivity.class);

                    // Start the new activity
                    startActivity(eegDatabase);
                }
                else{

                    Toast.makeText(FirstActivity.this, "Wifi is not connected", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
