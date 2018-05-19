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

public class FeelingLuckyActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        createSongList();
    }
    public void createSongList() {
        // Create a list of songs
        ArrayList<Playlist> songs = new ArrayList<Playlist>();
        songs.add(new Playlist("I Feel Lucky", "Mary Chapin Carpenter", R.drawable.cover_mary_chapin_carpenter));
        songs.add(new Playlist("Lucky", "Jason Mraz", R.drawable.cover_jason_mraz));
        songs.add(new Playlist("Some Guys Have All The Luck", "Rod Stewart", R.drawable.cover_rod_steward));
        songs.add(new Playlist("Lucky Star", "Madonna", R.drawable.cover_madonna));
        songs.add(new Playlist("Green Lights", "Aloe Blacc", R.drawable.cover_alow_blacc));
        songs.add(new Playlist("Ironic", "Alanis Morissette", R.drawable.cover_alow_blacc));
        songs.add(new Playlist("Get Lucky", "Daft Punk feat. Pharrell Williams", R.drawable.cover_pharell_williams));
        songs.add(new Playlist("Second Chance", "Shinedown", R.drawable.cover_shinedown));
        songs.add(new Playlist("With A Little Luck", "Paul McCartney and Wings", R.drawable.cover_paul_mccartney_and_wings));
        songs.add(new Playlist("Good Run of Bad Luck", "Clint Black", R.drawable.cover_clint_black));



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
        intent.putExtra("songs", intentExtra);
        startActivity(intent);
    }
}
