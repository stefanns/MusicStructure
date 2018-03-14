package com.example.android.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stefan on 3/4/2018.
 */

public class Song implements Parcelable {
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
    //string for artist
    private String mArtist;
    //string for song name
    private String mSongName;
    //string for song length
    private String mSongLength;
    //image for artist
    private int mSongID;


    //constructor
    public Song(String songName, String artist, String songLength, int songID)

    {
        mArtist = artist;
        mSongName = songName;
        mSongLength = songLength;
        mSongID = songID;
    }

    protected Song(Parcel in) {
        mArtist = in.readString();
        mSongName = in.readString();
        mSongLength = in.readString();
        mSongID = in.readInt();
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

    public int getImage() {
        return mSongID;
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
        parcel.writeInt(mSongID);
    }
}