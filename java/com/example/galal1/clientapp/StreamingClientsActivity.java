package com.example.galal1.clientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Galal1 on 7/10/2018.
 */

public class StreamingClientsActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_first.xmll layout file
        setContentView(R.layout.activity_streaming_clients);



        TextView patientOne = (TextView) findViewById(R.id.patient1);
        TextView patientTwo = (TextView) findViewById(R.id.patient2);

        // Set a click listener on that View
        patientOne.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent patientOne = new Intent(StreamingClientsActivity.this, PatientOneStreamingDetection.class);

                // Start the new activity
                startActivity(patientOne);
            }
        });


        patientTwo.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent patientTwo = new Intent(StreamingClientsActivity.this, PatientTwoStreamingDetection.class);

                // Start the new activity
                startActivity(patientTwo);
            }
        });


    }
}