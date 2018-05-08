package com.example.android.moodmusicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PlaylistAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Playlist} objects.
 */
public class PlaylistAdapter extends ArrayAdapter<Playlist>  {

    /**
     * Create a new {@link PlaylistAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs is the list of {@link Playlist} to be displayed.
     */
    public PlaylistAdapter(Context context, ArrayList<Playlist> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Playlist} object located at this position in the list
        Playlist currentPlaylist = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_name.
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the song name from the currentPlaylist object and set this text on
        // the Song Name TextView.
        songNameTextView.setText(currentPlaylist.getSongName());

        // Find the TextView in the list_item.xml layout with the ID artist_name.
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the currentPlaylist object and set this text on
        // the Artist Name TextView.
        artistNameTextView.setText(currentPlaylist.getArtistName());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}