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
    private String artist;
    //string for song name
    private String songName;
    //string for song length
    private String songLength;
    //image for artist
    private int songID;


    //constructor
    public Song(String song_name, String artist_, String song_length, int song_ID)

    {
        artist = artist_;
        songName = song_name;
        songLength = song_length;
        songID = song_ID;
    }

    protected Song(Parcel in) {
        artist = in.readString();
        songName = in.readString();
        songLength = in.readString();
        songID = in.readInt();
    }

    //get artist
    public String getArtist() {
        return artist;
    }

    //get song name
    public String getSongName() {
        return songName;
    }

    //get song length
    public String getSongLength() {
        return songLength;
    }

    public int getImage() {
        return songID;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(artist);
        parcel.writeString(songName);
        parcel.writeString(songLength);
        parcel.writeInt(songID);
    }
}