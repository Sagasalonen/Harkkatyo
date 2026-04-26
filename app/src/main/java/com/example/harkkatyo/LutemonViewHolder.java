package com.example.harkkatyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView lutemonName,lutemonColor,lutemonAttacks,lutemonDefences, lutemonLives,lutemonExperiencePoints;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonName = itemView.findViewById(R.id.txtLutemonName);
        lutemonColor = itemView.findViewById(R.id.txtLutemonColor);
        lutemonAttacks = itemView.findViewById(R.id.txtLutemonAttacks);
        lutemonDefences = itemView.findViewById(R.id.txtLutemonDefences);
        lutemonLives = itemView.findViewById(R.id.txtLutemonLives);
        lutemonExperiencePoints = itemView.findViewById(R.id.txtLutemonExperiencePoints);
        imageView=itemView.findViewById(R.id.ivLutemonImage);


    }
}
