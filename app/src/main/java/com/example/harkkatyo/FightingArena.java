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
        RecyclerView recyclerView = findViewById(R.id.FightingLutemonsRv);

        adapter = new MoveAdapter(this, LutemonStorage.getInstance().getLutemons());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        textView=findViewById(R.id.resultsTxt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void LutemonFight(Lutemon A, Lutemon B){
        while(true){
            textView.setText("1: "+A.color+"("+A.name+") att: "+A.attacks+"; def: "+A.defences+"; exp: "+A.experiencePoints+"; health: "+A.health+"\n");
            textView.append("2: "+B.color+"("+B.name+") att: "+B.attacks+"; def: "+B.defences+"; exp: "+B.experiencePoints+"; health: "+B.health+"\n");
            A.attack(B);
            textView.append(A.name+" hyökkää lutemoniin "+B.name+".\n");
            if (B.health>0){
                textView.append(B.name+" selvisi hyökkäyksestä hengissä.\n");
            }else{textView.append(B.name+" kuoli hyökkäyksessä\n");
                LutemonStorage.getInstance().addDeadLutemon(B);
                LutemonStorage.getInstance().deleteLutemon(B);
                break;}

            B.attack(A);
            textView.append(B.name+" hyökkää lutemoniin "+A.name+".\n");
            if (A.health>0){
                textView.append(A.name+" selvisi hyökkäyksestä hengissä.\n");
            }else{textView.append(A.name+" kuoli hyökkäyksessä\n");
                LutemonStorage.getInstance().addDeadLutemon(A);
                LutemonStorage.getInstance().deleteLutemon(A);
                break;}

        }
        textView.append("Taistelu on ohi.");

    }
    public void fight(View view){
        ArrayList<Lutemon> selectedLutemons = adapter.getSelectedLutemons();
        if (selectedLutemons.size()!=2){textView.setText("Valitse tasan kaksi lutemonia!");
        }else{
            Lutemon A = selectedLutemons.get(0);
            Lutemon B = selectedLutemons.get(1);
            LutemonFight(A,B);
        }
    }
    public void getBackToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}