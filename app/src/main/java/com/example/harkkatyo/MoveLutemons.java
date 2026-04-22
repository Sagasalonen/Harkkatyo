package com.example.harkkatyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.harkkatyo.fragments.DeadLutemonsFragment;
import com.example.harkkatyo.fragments.LutemonsAtHomeFragment;
import com.example.harkkatyo.fragments.LutemonsFightingFragment;
import com.example.harkkatyo.fragments.LutemonsTrainingFragment;

public class MoveLutemons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_move_lutemons);

        Button homeButton = findViewById(R.id.ShowLutemonsAtHome);
        Button fightingButton = findViewById(R.id.ShowLutemonsAtFightingArena);
        Button trainingButton = findViewById(R.id.ShowLutemonsAtTrainingArena);
        Button DeadButton = findViewById(R.id.ShowLutemonsWhoAreDead);


        DeadButton.setOnClickListener(listener);
        trainingButton.setOnClickListener(listener);
        homeButton.setOnClickListener(listener);
        fightingButton.setOnClickListener(listener);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

        private View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;

                if (view.getId()== R.id.ShowLutemonsAtHome){
                    fragment = new LutemonsAtHomeFragment();
                }
                else if (view.getId()== R.id.ShowLutemonsAtFightingArena){
                    fragment = new LutemonsFightingFragment();
                }
                else if (view.getId()== R.id.ShowLutemonsAtTrainingArena){
                    fragment = new LutemonsTrainingFragment();
                }
                else if (view.getId()== R.id.ShowLutemonsWhoAreDead){
                    fragment = new DeadLutemonsFragment();
                }else {fragment = new LutemonsAtHomeFragment();}

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment)
                        .commit();
            }
        };


            public void getBackToMainActivity(View view) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
};
