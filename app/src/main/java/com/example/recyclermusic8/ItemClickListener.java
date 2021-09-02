package com.example.recyclermusic8;

public interface ItemClickListener {
    void onPlayButtonClicked(SongModel songModel, int position);

    void onPauseButtonClicked(SongModel song, int position);

    void onDeleteButtonClicked(SongModel song, int position);
}
