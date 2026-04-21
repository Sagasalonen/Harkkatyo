package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public MoveAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoveViewHolder(LayoutInflater.from(context).inflate(R.layout.home_view, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {}

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
    static class MoveViewHolder extends RecyclerView.ViewHolder {
        public MoveViewHolder(@NonNull View itemView){
            super(itemView);
        }

    }

}
