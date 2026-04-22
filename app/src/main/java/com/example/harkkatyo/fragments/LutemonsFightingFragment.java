package com.example.harkkatyo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.harkkatyo.Lutemon;
import com.example.harkkatyo.LutemonStorage;
import com.example.harkkatyo.MoveAdapter;
import com.example.harkkatyo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LutemonsAtHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LutemonsFightingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MoveAdapter adapter;

    public LutemonsFightingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LutemonsAtHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LutemonsFightingFragment newInstance(String param1, String param2) {
        LutemonsFightingFragment fragment = new LutemonsFightingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lutemons_at_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.LutemonsFightingRV);
        // Inflate the layout for this fragment
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Lutemon> fightingLutemons = ListLutemonsFighting(LutemonStorage.getInstance().getLutemons());

        adapter = new MoveAdapter(getContext(), fightingLutemons);
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.MoveLutemon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                RadioGroup rgLutemonMove = getView().findViewById(R.id.ToFight);
                ArrayList<Lutemon> selectedLutemons = adapter.getSelectedLutemons();

                int choice = rgLutemonMove.getCheckedRadioButtonId();

                for (int i = 0; i < selectedLutemons.size(); i++) {
                    Lutemon lutemon = selectedLutemons.get(i);
                    if (choice == R.id.ToHome) {
                        lutemon.location = "home";
                    } else if (choice == R.id.ToTrain) {
                        lutemon.location = "treenikentta";
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    public ArrayList<Lutemon> ListLutemonsFighting(ArrayList<Lutemon> lutemons) {
        ArrayList<Lutemon> lutemonsFighting = new ArrayList<>();
        for (int i = 0; i < lutemons.size(); i++) {
            Lutemon lutemon = lutemons.get(i);
            if (lutemon.location.equals("taistelukentta")){
                lutemonsFighting.add(lutemon);
            }
        }
        return lutemonsFighting;
    }
}