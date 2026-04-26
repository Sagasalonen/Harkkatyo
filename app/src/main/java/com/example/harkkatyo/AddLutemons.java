package com.example.harkkatyo;

import android.content.Intent;
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

    public void addLutemonToList(View view) {

        RadioGroup rgLutemonColor = findViewById(R.id.chooseColorGroup);
        String name = textInput.getText().toString();

        if(name.isEmpty()) {
            textOutput.setText("Nimeä Lutemon ennen sen lisäämistä");
        } else {
            int choice = rgLutemonColor.getCheckedRadioButtonId();
            if (choice == R.id.greenRb) {
                String color = "vihreä";
                int attacks = 6;
                int defences = 3;
                int experiencePoints = 0;
                int health = 19;
                int image =R.drawable.vihre__lutemon;
                Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, health, image);
                LutemonStorage.getInstance().addLutemon(lutemon);
                textOutput.setText("Lutemon '" + name + "' lisätty");
            } else if (choice == R.id.whiteRb) {
                String color = "valkoinen";
                int attacks = 5;
                int defences = 4;
                int experiencePoints = 0;
                int health = 20;
                int image =R.drawable.valkoinen_lutemon;
                Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, health,image);
                LutemonStorage.getInstance().addLutemon(lutemon);
                textOutput.setText("Lutemon '" + name + "' lisätty");
            } else if (choice == R.id.pinkRb) {
                String color = "pinkki";
                int attacks = 7;
                int defences = 2;
                int experiencePoints = 0;
                int health = 18;
                int image =R.drawable.pinkki_lutemon;
                Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, health,image);
                LutemonStorage.getInstance().addLutemon(lutemon);
                textOutput.setText("Lutemon '" + name + "' lisätty");
            } else if (choice == R.id.orangeRb) {
                String color = "oranssi";
                int attacks = 8;
                int defences = 1;
                int experiencePoints = 0;
                int health = 17;
                int image =R.drawable.oranssi_lutemon;
                Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, health,image);
                LutemonStorage.getInstance().addLutemon(lutemon);
                textOutput.setText("Lutemon '" + name + "' lisätty");
            } else if (choice == R.id.blackRb) {
                String color = "musta";
                int attacks = 9;
                int defences = 0;
                int experiencePoints = 0;
                int health = 16;
                int image =R.drawable.musta_lutemon;
                Lutemon lutemon = new Lutemon(name, color, defences, attacks, experiencePoints, health,image);
                LutemonStorage.getInstance().addLutemon(lutemon);
                textOutput.setText("Lutemon '" + name + "' lisätty");
            } else {
                textOutput.setText("Syötä värivalinta ennen Lutemonin lisäämistä");
            }
        }
    }
    public void backToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}