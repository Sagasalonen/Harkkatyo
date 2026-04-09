package com.example.harkkatyo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddLutemons extends AppCompatActivity {

    private EditText textInput;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_lutemons);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInput = findViewById(R.id.nameLutemonText);
        textOutput = findViewById(R.id.inputAllInfoText);
    }

    private void addLutemonToList(View view) {

        RadioGroup rgLutemonColor = findViewById(R.id.chooseColorGroup);

        int choice = rgLutemonColor.getCheckedRadioButtonId();
        if (choice == R.id.greenRb) {
            String name = textInput.getText().toString();
            String color = "vihreä";
            int attacks = 6;
            int defences = 3;
            int experiencePoints = 0;
            int lives = 19;
            Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, lives);
            LutemonStorage.getInstance().addLutemon(lutemon);
        } else if (choice == R.id.whiteRb) {
            String name = textInput.getText().toString();
            String color = "valkoinen";
            int attacks = 5;
            int defences = 4;
            int experiencePoints = 0;
            int lives = 20;
            Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, lives);
            LutemonStorage.getInstance().addLutemon(lutemon);
        } else if (choice == R.id.pinkRb) {
            String name = textInput.getText().toString();
            String color = "pinkki";
            int attacks = 7;
            int defences = 2;
            int experiencePoints = 0;
            int lives = 18;
            Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, lives);
            LutemonStorage.getInstance().addLutemon(lutemon);
        } else if (choice == R.id.orangeRb) {
            String name = textInput.getText().toString();
            String color = "oranssi";
            int attacks = 8;
            int defences = 1;
            int experiencePoints = 0;
            int lives = 17;
            Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, lives);
            LutemonStorage.getInstance().addLutemon(lutemon);
        } else if (choice == R.id.blackRb) {
            String name = textInput.getText().toString();
            String color = "musta";
            int attacks = 9;
            int defences = 0;
            int experiencePoints = 0;
            int lives = 16;
            Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, lives);
            LutemonStorage.getInstance().addLutemon(lutemon);
        } else {
            textOutput.setText("Syötä värivalinta ennen Lutemonin lisäämistä");
        }
    }
}