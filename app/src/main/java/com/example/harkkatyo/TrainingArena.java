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

public class TrainingArena extends AppCompatActivity {
    private MoveAdapter adapter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_arena);

        RecyclerView recyclerView = findViewById(R.id.TrainingLutemonsRv);
        adapter = new MoveAdapter(this, LutemonStorage.getInstance().getLutemons());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        textView=findViewById(R.id.trainTxt);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void TrainLutemons(View view){
        ArrayList<Lutemon> selectedLutemons = adapter.getSelectedLutemons();
        if (selectedLutemons.size()==0){textView.setText("Valitse vähintään yksi lutemon!");}
        else{for (int i = 0; i < selectedLutemons.size(); i++) {
            Lutemon lutemon = selectedLutemons.get(i);
            lutemon.experiencePoints++;
            lutemon.attacks=lutemon.ogAttacks+ lutemon.experiencePoints;
            lutemon.defences=lutemon.ogDefences+lutemon.experiencePoints;
            textView.append(lutemon.color+"("+lutemon.name+") att: "+lutemon.attacks+"; def: "+lutemon.defences+"; exp: "+lutemon.experiencePoints+"; health: "+lutemon.health+"\n");
        }
        }

    }
    public void getBackToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}