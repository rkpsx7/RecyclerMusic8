package com.example.recyclermusic8;

public class SongModel {
    private String songName,duration;
    private int imageID,song;


    public SongModel(String songName, String duration, int imageID,int song) {
        this.songName = songName;
        this.duration = duration;
        this.imageID = imageID;
        this.song = song;
    }

    public int getSong() {
        return song;
    }

    public String getSongName() {
        return songName;
    }

    public String getDuration() {
        return duration;
    }

    public int getImageID() {
        return imageID;
    }
}
