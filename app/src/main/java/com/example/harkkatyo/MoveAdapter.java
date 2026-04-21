package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoveAdapter extends RecyclerView.Adapter<MoveViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons;
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    public MoveAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }
    public ArrayList<Lutemon> getSelectedLutemons(){
        return selectedLutemons;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoveViewHolder(LayoutInflater.from(context).inflate(R.layout.home_view, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.lutemonName.setText(lutemon.name+" ("+lutemon.color+")");
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(selectedLutemons.contains(lutemon));

        holder.checkBox.setOnCheckedChangeListener((buttonView,isChecked)->{
            if (isChecked){
                selectedLutemons.add(lutemon);
            }else{selectedLutemons.remove(lutemon);}
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

