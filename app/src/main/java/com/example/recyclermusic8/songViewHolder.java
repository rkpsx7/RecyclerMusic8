package com.example.recyclermusic8;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class songViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivCoverImage;
    private TextView tvSongName, tvSongDuration;
    private Button btnPlay, btnPause, btnDelete;
    private ItemClickListener itemClickListener;

    public songViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        initViews(itemView);
        this.itemClickListener = itemClickListener;
    }

    private void initViews(View itemView) {
        ivCoverImage = itemView.findViewById(R.id.coverImage);
        tvSongName = itemView.findViewById(R.id.songName);
        tvSongDuration = itemView.findViewById(R.id.songDuration);
        btnPlay = itemView.findViewById(R.id.btnPlay);
        btnPause = itemView.findViewById(R.id.btnPause);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }

    void setData(SongModel model) {
        ivCoverImage.setImageResource(model.getImageID());
        tvSongName.setText(model.getSongName());
        tvSongDuration.setText(model.getDuration());

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onPlayButtonClicked(model, getAdapterPosition());
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onPauseButtonClicked(model, getAdapterPosition());
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onDeleteButtonClicked(model, getAdapterPosition());
            }
        });
    }
}
