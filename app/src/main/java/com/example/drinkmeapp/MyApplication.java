package com.example.drinkmeapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private List<Drink> listaDrinks;

    @Override
    public void onCreate() {
        super.onCreate();
        listaDrinks = new ArrayList<>();
    }

    public List<Drink> getListaDrinks() {return listaDrinks;}

    public void addDrink(Drink drink) {listaDrinks.add(drink);}
}
