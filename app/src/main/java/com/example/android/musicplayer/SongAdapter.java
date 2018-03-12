package com.example.android.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
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
        holder.artistImage.setImageBitmap(songs.get(position).getImage());
        //get uncompressed bitmap
        Bitmap uncompressed = songs.get(position).getImage();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //compress bitmap to 50% quality
        uncompressed.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        final byte[] byteArray = stream.toByteArray();
        holder.playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send ata to player activity
                Intent musicIntent = new Intent(context, PlayerActivity.class);
               // musicIntent.putExtra("artist name", songs.get(position).getArtist());
               // musicIntent.putExtra("song name", songs.get(position).getSongName());
                musicIntent.putExtra("song length", songs.get(position).getSongLength());
                //send byte array
               // musicIntent.putExtra("artist image", byteArray);
                musicIntent.putParcelableArrayListExtra("songs",songs);
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
        ImageView playPause;
        ImageView forward;

        public SongViewHolder(View itemView) {
            super(itemView);
            //get views
            artistName = (TextView) itemView.findViewById(R.id.artist_text_view);
            songName = (TextView) itemView.findViewById(R.id.song_title_text_view);
            artistImage = (ImageView) itemView.findViewById(R.id.artist_image_view);
            playPause = (ImageView) itemView.findViewById(R.id.play_pause);
            forward = (ImageView) itemView.findViewById(R.id.player_forward);
        }
    }
}




