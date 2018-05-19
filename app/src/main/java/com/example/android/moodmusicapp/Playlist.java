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

    /** Artist name*/
    private int mAlbumCoverId;

    /**
     * Create a new Song object.
     * @param songName is the name of the song in the playlist
     * @param artistName is the name of the artist in the playlist
     * @param albumCoverId is the id of the album cover
     */
    public Playlist(String songName, String artistName, int albumCoverId) {

        mSongName = songName;
        mArtistName = artistName;
        mAlbumCoverId = albumCoverId;
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

    /**
     * Get the artist name.
     */
    public int getAlbumCoverId() {
        return mAlbumCoverId;
    }
}