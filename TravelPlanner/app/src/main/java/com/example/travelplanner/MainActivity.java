package com.example.travelplanner;

public class MainActivity {
}
package com.example.travelplannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Link to activity_main.xml layout

        // Find views by ID
        EditText editTextDestination = findViewById(R.id.editTextDestination);
        Button buttonViewDetails = findViewById(R.id.buttonViewDetails);

        // Set onClickListener for the "View Details" button
        buttonViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = editTextDestination.getText().toString(); // Get input text
                if (!destination.isEmpty()) {
                    // Create an explicit intent to navigate to DetailsActivity
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("destination", destination); // Pass destination as an extra
                    startActivity(intent); // Start DetailsActivity
                } else {
                    editTextDestination.setError("Please enter a destination!");
                }
            }
        });
    }
}
