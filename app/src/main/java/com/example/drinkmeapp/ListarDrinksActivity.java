package com.example.drinkmeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListarDrinksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrinkAdapter drinkAdapter;

    private MyApplication myApplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_drinks);

        // Iniciando o Recycler View para listar e mostar os drinks.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myApplication = (MyApplication) getApplication();
        List<Drink> listaDrinks = myApplication.getListaDrinks();

        drinkAdapter = new DrinkAdapter(listaDrinks, this);
        recyclerView.setAdapter(drinkAdapter);


    }

//    private List<Drink> getDrinks() {
//        List<Drink> listaDrinks = new ArrayList<>();
//
//        listaDrinks.add(new Drink("Caipirinha", "Drink a base de cacchaça, açúcar e limão", "12,90"));
//        return listaDrinks;
//    }


    void updateRecyclerView() {
        if (drinkAdapter != null) {
            drinkAdapter.notifyDataSetChanged();
        }
    }
}