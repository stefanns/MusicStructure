package com.example.android.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Stefan on 3/4/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    public ArrayList<Song> songs;
    public Context context;

    public SongAdapter(Context context, ArrayList<Song> song) {
        this.context = context;
        this.songs = song;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        SongViewHolder vh = new SongViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {
        // set the data in items
        holder.artistName.setText(songs.get(position).getArtist());
        holder.songName.setText(songs.get(position).getSongName());
        Bitmap myBitmap = BitmapFactory.decodeResource(context.getResources(), songs.get(position).getImage());
        holder.artistImage.setImageBitmap(myBitmap);
        // play and go the PlayerActivity
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send data to player activity
                Intent musicIntent = new Intent(context, PlayerActivity.class);
                //send the ArrayList
                musicIntent.putParcelableArrayListExtra("songs", songs);
                //send the position to correctly display views
                musicIntent.putExtra("position", position);
                context.startActivity(musicIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        //init item view
        TextView artistName;
        TextView songName;
        ImageView artistImage;
        View cardView;

        public SongViewHolder(View itemView) {
            super(itemView);
            //get views
            artistName = itemView.findViewById(R.id.artist_text_view);
            songName = itemView.findViewById(R.id.song_title_text_view);
            artistImage = itemView.findViewById(R.id.artist_image_view);
            cardView = itemView.findViewById(R.id.list_card);
        }
    }
}




