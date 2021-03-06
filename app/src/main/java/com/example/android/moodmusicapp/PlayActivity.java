package com.example.android.moodmusicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity implements Runnable,
        View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private SeekBar mSeekBar;
    private ImageButton mPlaySong;
    private ImageButton mPauseSong;
    private MediaPlayer mMediaPlayer;
    private TextView mTextSong;
    private TextView mTextArtist;

    private String mSongName;
    private String mArtistName;
    private int mAlbumCover;
    private String mIntentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

       String [] intentMsgArray = new String[2];

        Bundle bundle = getIntent().getExtras();
        mIntentMessage = bundle.getString("");

        // Splits intent message received into song, singer, and song category
        intentMsgArray = mIntentMessage.split("\\|");
        mSongName = intentMsgArray[0];
        mArtistName = intentMsgArray[1];

        // Initialize UI Components
        mTextSong = (TextView) findViewById(R.id.song_name);
        mTextArtist = (TextView) findViewById(R.id.artist_name);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mPlaySong = (ImageButton) findViewById(R.id.play_button);
        mPauseSong = (ImageButton) findViewById(R.id.pause_button);


        // Set OnClickListeners on clickable items
        mPlaySong.setOnClickListener(this);
        mPauseSong.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
        mSeekBar.setEnabled(false);

        // Display Media Details and Image
        displayMediaDetails();

    }


        /**
         * This method displays song details - song name, artist name & album cover
         */
        public void displayMediaDetails(){
            mTextSong.setText(mSongName);
            mTextArtist.setText(mArtistName);
        }

    /**
     * This method tracks progress while song is playing and sets position on SeekBar
     */
    public void run() {
        int currentPosition = mMediaPlayer.getCurrentPosition();
        int total = mMediaPlayer.getDuration();

        while (mMediaPlayer != null && currentPosition < total) {
            try {
                Thread.sleep(1000);
                currentPosition = mMediaPlayer.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            mSeekBar.setProgress(currentPosition);
        }
    }

    /**
     * This method handles playing and pausing the song file
     */
    public void onClick(View v) {
        if (v.equals(mPlaySong)) {
            if (mMediaPlayer == null) {
                int resId = getResources().getIdentifier(mSongName, "raw", getPackageName());
                mMediaPlayer = MediaPlayer.create(PlayActivity.this, resId);
                mSeekBar.setEnabled(true);
            }
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                mPlaySong.setBackground(ContextCompat.getDrawable(PlayActivity.this, R.drawable.play_button));
            } else {
                mMediaPlayer.start();
                mPauseSong.setBackground(ContextCompat.getDrawable(PlayActivity.this, R.drawable.pause_button));
                mSeekBar.setMax(mMediaPlayer.getDuration());
                new Thread(this).start();
            }
        }


            }

    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        try {
            if (mMediaPlayer.isPlaying() || mMediaPlayer != null) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                }
            } else if (mMediaPlayer == null) {
                Toast.makeText(getApplicationContext(), "Press Play",
                        Toast.LENGTH_SHORT).show();
                seekBar.setProgress(0);
            }
        } catch (Exception e) {
            Log.e("PlayActivity", "SeekBar is not responding" + e);
            seekBar.setEnabled(false);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO

    }
        }

