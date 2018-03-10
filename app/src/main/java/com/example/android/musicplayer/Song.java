package com.example.android.musicplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Stefan on 3/4/2018.
 */

public class Song implements Serializable {
    //string for artist
    private String mArtist;
    //string for song name
    private String mSongName;
    //string for song length
    private String mSongLength;
    //image for artist
    private Bitmap mImage;

    //constructor
    public Song(String songName, String artist, String songLength, Bitmap image)

    {
        mArtist = artist;
        mSongName = songName;
        mSongLength = songLength;
        mImage = image;
    }


    //get artist
    public String getArtist() {
        return mArtist;
    }

    //get song name
    public String getSongName() {
        return mSongName;
    }

    //get song length
    public String getSongLength() {
        return mSongLength;
    }

    public Bitmap getImage() {
        return mImage;
    }


}