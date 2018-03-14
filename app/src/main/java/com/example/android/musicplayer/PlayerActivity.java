package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    TextView artistTextView;
    TextView songTextView;
    ImageView artistImageView;
    ImageView forward;
    ImageView rewind;
    ArrayList<Song> songList;
    int position;
    TextView songDuration;
    TextView songStart;
    ImageView playPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initialize();
        getIntents();
        clickForward();
        clickRewind();
        clickPlayPause();
    }

    /*saving instance on rotation
    *Note: I did  not knew how to save the stave of a SVG
    *in order to save the instance,the play button reset to
    *initial state after rotation
    */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("position", position);
        CharSequence forArtist = artistTextView.getText();
        savedInstanceState.putCharSequence("artist", forArtist);
        CharSequence forSong = songTextView.getText();
        savedInstanceState.putCharSequence("song", forSong);
        Bitmap forImage = ((BitmapDrawable) artistImageView.getDrawable()).getBitmap();
        savedInstanceState.putParcelable("Image", forImage);
        CharSequence forSongDuration = songDuration.getText();
        savedInstanceState.putCharSequence("songDuration", forSongDuration);

    }

    //restore instance after rotation
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("position");
        CharSequence forArtist = savedInstanceState.getCharSequence("artist");
        artistTextView.setText(forArtist);
        CharSequence forSong = savedInstanceState.getCharSequence("song");
        songTextView.setText(forSong);
        Bitmap forImage = savedInstanceState.getParcelable("Image");
        artistImageView.setImageBitmap(forImage);
        CharSequence forSongDuration = savedInstanceState.getCharSequence("songDuration");
        songDuration.setText(forSongDuration);


    }

    //initialize text views
    public void initialize() {
        artistTextView = findViewById(R.id.player_artist_text_view);
        artistImageView = findViewById(R.id.player_artist_image_view);
        songTextView = findViewById(R.id.player_song_text_view);
        forward = findViewById(R.id.player_forward);
        rewind = findViewById(R.id.player_rewind);
        songDuration = findViewById(R.id.song_duration_text_view);
        songStart = findViewById(R.id.song_start_text_view);
        playPause = findViewById(R.id.play_pause);
    }

    //get intents from previous activity
    public void getIntents() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        songList = intent.getParcelableArrayListExtra("songs");
        // get artist name and set to to TextView
        artistTextView.setText(songList.get(position).getArtist());
        // get song name and set to to TextView
        songTextView.setText(songList.get(position).getSongName());
        // get,decode and set image to ImageView
        Bitmap artistImage = BitmapFactory.decodeResource(getResources(), songList.get(position).getImage());
        artistImageView.setImageBitmap(artistImage);
        //get song duration and set to TextView
        songDuration.setText(songList.get(position).getSongLength());
        songStart.setText(getString(R.string.start_counter));
    }

    //used to access the next song
    public void clickForward() {
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < songList.size() - 1) { //till position reach the end of the list
                    ++position;
                    artistTextView.setText(songList.get(position).getArtist());
                    songTextView.setText(songList.get(position).getSongName());
                    Bitmap artistImage = BitmapFactory.decodeResource(getResources(), songList.get(position).getImage());
                    artistImageView.setImageBitmap(artistImage);
                    songDuration.setText(songList.get(position).getSongLength());
                }
            }
        });
    }

    //used to access the previous song
    public void clickRewind() {
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != 0) { //position reach start of list
                    --position;
                    artistTextView.setText(songList.get(position).getArtist());
                    songTextView.setText(songList.get(position).getSongName());
                    Bitmap artistImage = BitmapFactory.decodeResource(getResources(), songList.get(position).getImage());
                    artistImageView.setImageBitmap(artistImage);
                    songDuration.setText(songList.get(position).getSongLength());
                }
            }
        });
    }

    /*
    *Switch play/pause when clicked
    * Source:
    *    https://stackoverflow.com/questions/32420565/android-changing-
    *    imageview-between-two-images-on-button-click-and-reclick
    */
    public void clickPlayPause() {
        playPause.setTag(1);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playPause.getTag().equals(1)) {
                    playPause.setImageResource(R.drawable.player_play_button);
                    playPause.setTag(2);
                } else {
                    playPause.setImageResource(R.drawable.pause__1_);
                    playPause.setTag(1);
                }

            }

        });
    }

}

