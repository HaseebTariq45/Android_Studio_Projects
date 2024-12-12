package com.example.travelplannerapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details); // Link to activity_details.xml layout

        // Find views by ID
        TextView textViewDestinationDetails = findViewById(R.id.textViewDestinationDetails);
        Button buttonOpenMap = findViewById(R.id.buttonOpenMap);

        // Retrieve the destination passed via the intent
        String destination = getIntent().getStringExtra("destination");
        textViewDestinationDetails.setText(destination); // Display destination in TextView

        // Set onClickListener for the "Open in Map" button
        buttonOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (destination != null && !destination.isEmpty()) {
                    // Create an implicit intent to view the location in a map application
                    Uri locationUri = Uri.parse("geo:0,0?q=" + destination);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

                    // Verify that there's an app to handle the intent before starting it
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            }
        });
    }
}
