package com.example.drinkmeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        String nome = getIntent().getStringExtra("NOME");
        String descricao = getIntent().getStringExtra("DESCRICAO");
        String preco = getIntent().getStringExtra("PRECO");
        String imagepath = getIntent().getStringExtra("IMAGEM");

        TextView TVnomeDetalhes = findViewById(R.id.TVnomeDetalhes);
        TextView TVdescDetalhes = findViewById(R.id.TVdescDetalhes);
        TextView TVprecoDetalhes = findViewById(R.id.TVprecoDetalhes);
        ImageView IVimageDetalhes = findViewById(R.id.IVimagemDetalhes);

        TVnomeDetalhes.setText(nome);
        TVdescDetalhes.setText(descricao);
        TVprecoDetalhes.setText(preco);

        if (!TextUtils.isEmpty(imagepath)) {
            Glide.with(this).load(Uri.parse(imagepath)).into(IVimageDetalhes);
        }


    }
}