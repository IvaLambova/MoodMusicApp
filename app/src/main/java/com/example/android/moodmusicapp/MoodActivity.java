package com.example.android.moodmusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the mood_activity.xml layout file
        setContentView(R.layout.mood_activity);

        // Find the View that shows the feeling lucky category
        TextView lucky = (TextView) findViewById(R.id.lucky);

        // Set a click listener on that View
        lucky.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the Feeling Lucky View is clicked on.
            @Override
            public void onClick(View view) {
                Intent luckyIntent = new Intent(MoodActivity.this, FeelingLuckyActivity.class);
                startActivity(luckyIntent);
            }
        });

        // Find the View that shows the energize category
        TextView energize = (TextView) findViewById(R.id.energize);

        // Set a click listener on that View
        energize.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the Energize Me View is clicked on.
            @Override
            public void onClick(View view) {
                Intent energizeIntent = new Intent(MoodActivity.this, EnergizeMeActivity.class);
                startActivity(energizeIntent);
            }
        });

        // Find the View that shows the love category
        TextView love = (TextView) findViewById(R.id.love);

        // Set a click listener on that View
        love.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent loveIntent = new Intent(MoodActivity.this, FeelingLovedActivity.class);
                startActivity(loveIntent);
            }
        });

        // Find the View that shows the rainy category
        TextView rainy = (TextView) findViewById(R.id.rainy);

        // Set a click listener on that View
        rainy.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent rainyIntent = new Intent(MoodActivity.this, RainyFeelingsActivity.class);
                startActivity(rainyIntent);
            }
        });
    }
}
