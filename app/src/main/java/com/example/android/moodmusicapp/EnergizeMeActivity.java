package com.example.android.moodmusicapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EnergizeMeActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        createSongList();
    }

    public void createSongList() {
        // Create a list of songs
        ArrayList<Playlist> songs = new ArrayList<Playlist>();
        songs.add(new Playlist("Just What I Needed", "The Cars"));
        songs.add(new Playlist("Ain’t No Mountain High Enough", "Tammi Terrell & Marvin Gaye"));
        songs.add(new Playlist("Honey, I’m Good", "Bon Iver"));
        songs.add(new Playlist("This Dress Looks Nice On You", "Andy Grammer"));
        songs.add(new Playlist("No Sleep Till Brooklyn", "Beastie Boys"));
        songs.add(new Playlist("It’s a Long Way to the Top (If You Wanna Rock ‘n’ Roll)", "AC/DC"));
        songs.add(new Playlist("Don’t Stop Believin", "Journey"));
        songs.add(new Playlist("Wake Me Up When September Ends", "Green Day"));
        songs.add(new Playlist("Celebration", "Kool & the Gang"));
        songs.add(new Playlist("Life Itself ", "Glass Animals"));


        // Create an {@link PlaylistAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        PlaylistAdapter adapter = new PlaylistAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaylistAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Playlist} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;
        String intentExtra = "";

        // Find the TextView in the list_item.xml layout with the ID song_name.
        TextView songNameTextView = (TextView) view.findViewById(R.id.song_name);
        String song = songNameTextView.getText().toString();

        // Find the TextView in the list_item.xml layout with the ID artist_name.
        TextView artistNameTextView = (TextView) view.findViewById(R.id.artist_name);
        String artist = artistNameTextView.getText().toString();

        intentExtra = song + "|" + artist + "|" + song;
        Intent intent = new Intent(context, PlayActivity.class);
        intent.putExtra("message", intentExtra);
        startActivity(intent);

    }

}
