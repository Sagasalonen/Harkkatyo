package com.example.harkkatyo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harkkatyo.Lutemon;
import com.example.harkkatyo.R;

import java.util.ArrayList;

public class LutemonsAtHomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lutemons_at_home, container, false);

        recyclerView = view.findViewById(R.id.LutemonsAtHomeRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        return view;
    }
}

    public ArrayList<Lutemon> homeLutemons(ArrayList<Lutemon> lutemons) {
        ArrayList<Lutemon> lutemonsAtHome = new ArrayList<>();
        for (int i = 0; i < lutemons.size(); i++) {
            Lutemon lutemon = lutemons.get(i);
            if (lutemon.location == "home") {
                lutemonsAtHome.add(lutemon);
            }
        }
        return lutemonsAtHome;
    }
