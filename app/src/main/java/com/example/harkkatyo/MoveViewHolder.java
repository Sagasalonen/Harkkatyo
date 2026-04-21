package com.example.harkkatyo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MoveViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;
    TextView lutemonName;
    public MoveViewHolder(View itemView){
        super(itemView);
        checkBox = itemView.findViewById(R.id.CBLutemon);
        lutemonName = itemView.findViewById(R.id.lutemonName);
    }
}
