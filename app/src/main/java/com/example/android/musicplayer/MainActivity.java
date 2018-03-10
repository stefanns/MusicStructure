package com.example.android.musicplayer;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("kdjshfjksdjf", "ajkhsdjkahs", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song("I want to break free", "Queen", "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        SongAdapter song = new SongAdapter(this, songs);
        recyclerView.setAdapter(song);

    }


}
