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
        songs.add(new Song(getResources().getString(R.string.Song_1),
                getResources().getString(R.string.Artist_1), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.queen_image)));
        songs.add(new Song(getResources().getString(R.string.Song_2),
                getResources().getString(R.string.Artist_2), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.scorpions_image)));
        songs.add(new Song(getResources().getString(R.string.Song_3),
                getResources().getString(R.string.Artist_3), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.pinkfloyd_image)));
        songs.add(new Song(getResources().getString(R.string.Song_4),
                getResources().getString(R.string.Artist_4), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.metallica_image)));
        songs.add(new Song(getResources().getString(R.string.Song_5),
                getResources().getString(R.string.Artist_5), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.alicecooper_image)));
        songs.add(new Song(getResources().getString(R.string.Song_6),
                getResources().getString(R.string.Artist_6), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.linkinpark_image)));
        songs.add(new Song(getResources().getString(R.string.Song_7),
                getResources().getString(R.string.Artist_7), "4:56",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.rageagainst_image)));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        SongAdapter song = new SongAdapter(this, songs);
        recyclerView.setAdapter(song);

    }


}
