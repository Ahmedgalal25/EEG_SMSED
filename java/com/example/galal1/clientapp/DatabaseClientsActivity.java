package com.example.galal1.clientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Galal1 on 7/16/2018.
 */

public class DatabaseClientsActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_firstt.xml layout file
        setContentView(R.layout.activity_database_clients);



        TextView patientOne = (TextView) findViewById(R.id.patient1S);
        TextView patientTwo = (TextView) findViewById(R.id.patient2S);

        // Set a click listener on that View
        patientOne.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent patientOne = new Intent(DatabaseClientsActivity.this, PatientOneDatabase.class);

                // Start the new activity
                startActivity(patientOne);
            }
        });


        patientTwo.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent patientTwo = new Intent(DatabaseClientsActivity.this, PatientTwoDatabase.class);

                // Start the new activity
                startActivity(patientTwo);
            }
        });

    }
}