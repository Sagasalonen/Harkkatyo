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
    private ArrayList<Lutemon> lutemons;

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
        Lutemon lutemon = lutemons.get(position);
        holder.lutemonName.setText("Nimi: " + lutemon.name);
        holder.lutemonColor.setText("Väri: "+lutemon.color);
        holder.lutemonDefences.setText("Puolustus: "+lutemon.defences);
        holder.lutemonAttacks.setText("Hyökkäys: "+lutemon.attacks);
        holder.lutemonLives.setText("Elämät: "+lutemon.health);
        holder.lutemonExperiencePoints.setText("Kokemus: "+lutemon.experiencePoints);
        holder.imageView.setImageResource(lutemon.image);

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
