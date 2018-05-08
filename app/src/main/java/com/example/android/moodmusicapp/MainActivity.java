package com.example.android.moodmusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the text "What's your mood today?"
        TextView yourMood = (TextView) findViewById(R.id.mood);

        // Set a click listener on that View
        yourMood.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the "What's your mood today?" View is clicked on.
            @Override
            public void onClick(View view) {
                Intent moodIntent = new Intent(MainActivity.this, MoodActivity.class);
                startActivity(moodIntent);
            }
        });
    }
}
