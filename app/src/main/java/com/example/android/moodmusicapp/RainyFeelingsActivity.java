package com.example.android.moodmusicapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class RainyFeelingsActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        createSongList();
    }

    public void createSongList() {

            // Create a list of songs
            ArrayList<Playlist> songs = new ArrayList<Playlist>();
            songs.add(new Playlist("Riders On The Storm", "The Doors", R.drawable.cover_the_doors));
            songs.add(new Playlist("Teardrop", "Massive Attack", R.drawable.cover_massive_attack));
            songs.add(new Playlist("Holocene", "Bon Iver", R.drawable.cover_bon_iver));
            songs.add(new Playlist("This Dress Looks Nice On You", "Sufjan Stevens", R.drawable.cover_sufajn_stevens));
            songs.add(new Playlist("Decks Dark", "Radiohead", R.drawable.cover_radiohead));
            songs.add(new Playlist("Overgrown", "James Blake", R.drawable.cover_james_blake));
            songs.add(new Playlist("Roads", "Portishead", R.drawable.cover_portishead));
            songs.add(new Playlist("Open", "Rhye", R.drawable.cover_rhye));
            songs.add(new Playlist("Chanel", "Frank Ocean", R.drawable.cover_frank_ocean));
            songs.add(new Playlist("The Rain Song", "Led Zeppelin", R.drawable.cover_led_zeppelin));


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

    /**
     * Method to identify ListView item clicked and launch MediaActivity
     * @param adapterView
     * @param view
     * @param position
     * @param id
     */
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
