package com.example.android.moodmusicapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Removes app status bar at the top to allow for more screen size to work with
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the text "What's your mood today?"
        TextView yourMood = (TextView) findViewById(R.id.mood);

        // Set the text color of the Text View text
        yourMood.setTextColor(Color.parseColor("#ffffff"));

        // Find the Image View with the arrow that initiates the playlist activity
        ImageView playArrow = (ImageView) findViewById(R.id.start_button);

        // Set a click listener on that View
        playArrow.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the "What's your mood today?" View is clicked on.
            @Override
            public void onClick(View view) {
                Intent moodIntent = new Intent(MainActivity.this, MoodActivity.class);
                startActivity(moodIntent);
            }
        });
    }
}
