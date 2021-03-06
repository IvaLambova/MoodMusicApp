package com.example.android.moodmusicapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FeelingLovedActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        createSongList();
    }

    public void createSongList() {
        // Create a list of songs
        ArrayList<Playlist> songs = new ArrayList<Playlist>();
        songs.add(new Playlist("I Don't Want to Miss a Thing ", "Aerosmith", R.drawable.cover_aerosmith));
        songs.add(new Playlist("God Only Knows", "The Beach Boys", R.drawable.cover_the_beach_boys));
        songs.add(new Playlist("I Just Can't Stop Loving You", "Michael Jackson", R.drawable.cover_michael_jackson));
        songs.add(new Playlist("Still Loving You", "Scorpions", R.drawable.cover_scorpions));
        songs.add(new Playlist("Layla", "Derek & the Dominos", R.drawable.cover_derek_and_the_dominos));
        songs.add(new Playlist("Heaven", "Bryan Adams", R.drawable.cover_bryan_adams));
        songs.add(new Playlist("My Immortal", "Evanescence", R.drawable.cover_evanescence));
        songs.add(new Playlist("Endless Love", "Diana Ross & Lionel Richie", R.drawable.cover_diana_ross));
        songs.add(new Playlist("Something", "The Beatles", R.drawable.cover_the_beatles));
        songs.add(new Playlist("Maybe I'm Amazed", "Paul McCartney", R.drawable.cover_paul_mccartney_and_wings));


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

        // Find the ImageView in the list_item.xml layout with the ID album_cover.
        ImageView albumCoverImageView = (ImageView) view.findViewById(R.id.album_cover);
        int cover = albumCoverImageView.getImageAlpha();

        intentExtra = cover + "|" + song + "|" + artist;
        Intent intent = new Intent(context, PlayActivity.class);
        intent.putExtra("message", intentExtra);
        startActivity(intent);
    }
}
