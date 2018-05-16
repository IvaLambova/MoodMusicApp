package com.example.android.moodmusicapp;

import android.widget.ImageView;

/**
 * {@link Playlist} represents a playlist of songs that are chosen based on the mood that the user selected
 * The playlist contains the song & artist names
 */
public class Playlist {

    /** Song name */
    private String mSongName;

    /** Artist name*/
    private String mArtistName;

    /**
     * Create a new Song object.
     * @param songName is the name of the song in the playlist
     * @param artistName is the name of the artist in the playlist
     */
    public Playlist(String songName, String artistName) {

        mSongName = songName;
        mArtistName = artistName;
    }

    /**
     * Get the song name
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

}