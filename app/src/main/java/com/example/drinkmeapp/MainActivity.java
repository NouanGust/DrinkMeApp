package com.example.drinkmeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        Button listarDrinks = findViewById(R.id.drinksBtn);
        Button cadastrarDrinks = findViewById(R.id.cadastroBtn);

        listarDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarDrinksActivity.class);
                startActivity(intent);
            }
        });

        cadastrarDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarDrinksActivity.class);
                startActivity(intent);
            }
        });

    }
}
