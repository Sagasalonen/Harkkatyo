package com.example.harkkatyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void AddLutemons(View view){
        Intent intent = new Intent(this, AddLutemons.class);
        startActivity(intent);
    }
    public void MoveLutemons(View view){
        Intent intent = new Intent(this, MoveLutemons.class);
        startActivity(intent);
    }
    public void ListLutemons(View view){
        Intent intent = new Intent(this, ListLutemons.class);
        startActivity(intent);
    }
    public void MoveToFightingArena(View view){
        Intent intent = new Intent(this, FightingArena.class);
        startActivity(intent);
    }
    public void MoveToTrainingArena(View view){
        Intent intent = new Intent(this, TrainingArena.class);
        startActivity(intent);
    }
}