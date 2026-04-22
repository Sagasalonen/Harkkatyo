package com.example.harkkatyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FightingArena extends AppCompatActivity {

    private MoveAdapter adapter;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fighting_arena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.FightingLutemonsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        textView=findViewById(R.id.resultsTxt);

    }

    public void LutemonFight(Lutemon A, Lutemon B){
        while(true){
            textView.setText("1: "+A.color+"("+A.name+") att: "+A.attacks+"; def: "+A.defences+"; exp: "+A.experiencePoints+"; health: "+A.health);
            textView.append("1: "+A.color+"("+A.name+") att: "+A.attacks+"; def: "+A.defences+"; exp: "+A.experiencePoints+"; health: "+A.health);
            A.attack(B);
            textView.append(A.name+" hyökkää lutemoniin "+B.name+".");
            if (B.health>0){
                textView.append(B.name+" selvisi hyökkäyksestä hengissä.");
            }else{textView.append(B.name+" kuoli hyökkäyksessä");
                B.location="dead";
                break;}

            B.attack(A);
            textView.append(B.name+" hyökkää lutemoniin "+A.name+".");
            if (A.health>0){
                textView.append(A.name+" selvisi hyökkäyksestä hengissä.");
            }else{textView.append(A.name+" kuoli hyökkäyksessä");
                A.location="dead";
                break;}

        }
        textView.append("Taistelu on ohi.");

    }
    public void getBackToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}