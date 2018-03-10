package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        String artistName = intent.getStringExtra("artist name");
        artistTextView.setText(artistName);
        String songName = intent.getStringExtra("song name");
        songTextView.setText(songName);
        byte[] artistImage = intent.getByteArrayExtra("artist image");
        Bitmap compressedBitmap = BitmapFactory.decodeByteArray(artistImage, 0, artistImage.length);
        artistImageView.setImageBitmap(compressedBitmap);
    }


}

