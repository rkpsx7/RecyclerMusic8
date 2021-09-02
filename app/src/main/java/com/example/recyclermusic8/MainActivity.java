package com.example.recyclermusic8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private ArrayList<SongModel> songList= new ArrayList<>();
    private Adapter adapter;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildData();
        setDataToRecycler();
    }

    private void setDataToRecycler() {
        adapter = new Adapter(songList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildData() {
        SongModel song1 = new SongModel("Fearless - Lost Sky","03:22",R.drawable.music1,R.raw.fearless_lost_sky);
        songList.add(song1);
        SongModel song2 = new SongModel("Lite Flow - Ver 2","03:01",R.drawable.music2,R.raw.lite_flow_v2);
        songList.add(song2);
        SongModel song3 = new SongModel("Fearless - Lost Sky","03:22",R.drawable.music1,R.raw.fearless_lost_sky);
        songList.add(song3);
        SongModel song4 = new SongModel("Lite Flow - Ver 2","03:01",R.drawable.music2,R.raw.lite_flow_v2);
        songList.add(song4);
        SongModel song8 = new SongModel("Fearless - Lost Sky","03:22",R.drawable.music1,R.raw.fearless_lost_sky);
        songList.add(song8);
        SongModel song5 = new SongModel("Lite Flow - Ver 2","03:01",R.drawable.music2,R.raw.lite_flow_v2);
        songList.add(song5);
        SongModel song6 = new SongModel("Fearless - Lost Sky","03:22",R.drawable.music1,R.raw.fearless_lost_sky);
        songList.add(song6);
        SongModel song7 = new SongModel("Lite Flow - Ver 2","03:01",R.drawable.music2,R.raw.lite_flow_v2);
        songList.add(song7);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onPlayButtonClicked(SongModel songModel, int position) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this,songModel.getSong());
        mediaPlayer.start();
    }

    @Override
    public void onPauseButtonClicked(SongModel song, int position) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDeleteButtonClicked(SongModel song, int position) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        songList.remove(position);
        adapter.notifyDataSetChanged();
    }
}