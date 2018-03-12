package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    TextView artistTextView;
    TextView songTextView;
    ImageView artistImageView;
    ImageView forward;
    ImageView rewind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initialize();
        getIntents();

    }

    //initialize text views
    public void initialize() {
        artistTextView = findViewById(R.id.player_artist_text_view);
        artistImageView = findViewById(R.id.player_artist_image_view);
        songTextView = findViewById(R.id.player_song_text_view);
        forward = findViewById(R.id.player_forward);
    }

    //get intents from previous activity
    public void getIntents() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        ArrayList<Song> xyz = intent.getParcelableArrayListExtra("songs");
        /*
         get artist name and set to to TextView
        String artistName = intent.getStringExtra("artist name");
        */
        artistTextView.setText(xyz.get(position).getArtist());
        /*
         get song name and set to to TextView
        String songName = intent.getStringExtra("song name");
        */
        songTextView.setText(xyz.get(position).getSongName());
        /* get image as byte array, decode and set to  ImageView
        byte[] artistImage = intent.getByteArrayExtra("artist image");
        Bitmap compressedBitmap = BitmapFactory.decodeByteArray(artistImage, 0, artistImage.length);
       */
        artistImageView.setImageBitmap(xyz.get(position).getImage());

    }


}

