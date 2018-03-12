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

public class Song implements Parcelable {
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


    protected Song(Parcel in) {
        mArtist = in.readString();
        mSongName = in.readString();
        mSongLength = in.readString();
        mImage = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

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

    //get image
    public Bitmap getImage() {
        return mImage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtist);
        parcel.writeString(mSongName);
        parcel.writeString(mSongLength);
        parcel.writeParcelable(mImage, i);
    }
}