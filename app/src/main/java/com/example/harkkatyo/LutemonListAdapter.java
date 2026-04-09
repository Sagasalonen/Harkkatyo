package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        Lutemon lutemon = LutemonStorage.getInstance().getLutemons().get(position);
        holder.lutemonName.setText(lutemon.name);
        holder.lutemonColor.setText(lutemon.color);
        holder.lutemonDefences.setText(lutemon.defences);
        holder.lutemonAttacks.setText(lutemon.attacks);
        holder.lutemonLives.setText(lutemon.lives);
        holder.lutemonExperiencePoints.setText(lutemon.experiencePoints);
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
