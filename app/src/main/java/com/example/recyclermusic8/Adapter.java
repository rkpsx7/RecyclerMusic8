package com.example.recyclermusic8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<songViewHolder> {
    private ArrayList<SongModel> songList = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public Adapter(ArrayList<SongModel> songList, ItemClickListener itemClickListener) {
        this.songList = songList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public songViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item_layout,parent,false);
        return new songViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull songViewHolder holder, int position) {
        SongModel song = songList.get(position);
        holder.setData(song);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
