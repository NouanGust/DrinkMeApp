package com.example.drinkmeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class CadastrarDrinksActivity extends AppCompatActivity {

    private EditText drinkNomeInput, drinkDescInput, drinkPrecoInput;
    private Button cadastrarBtn, uploadImageBtn;

    private MyApplication myApplication;
    private DrinkAdapter drinkAdapter;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_drinks);

        drinkNomeInput = findViewById(R.id.drinkNomeInput);
        drinkDescInput = findViewById(R.id.drinkDescInput);
        drinkPrecoInput = findViewById(R.id.drinkPrecoInput);
        cadastrarBtn = findViewById(R.id.cadastrarBtn);
        uploadImageBtn = findViewById(R.id.uploadImageBtn);

        uploadImageBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        myApplication = (MyApplication) getApplication();
        List<Drink> listaDrinks = myApplication.getListaDrinks();

        drinkAdapter = new DrinkAdapter(listaDrinks, this);

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDrink();
            }
        });
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            imageUri = data.getData();
        }
    }

    private void salvarDrink() {
        // Pegando dados digitados
        String nome = drinkNomeInput.getText().toString();
        String descricao = drinkDescInput.getText().toString();
        String preco = drinkPrecoInput.getText().toString();
        String imagePath = (imageUri != null) ? imageUri.toString() : "";

        //Validação
        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(descricao) || TextUtils.isEmpty(preco)) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Salvando na lista
        Drink novoDrink = new Drink(nome, descricao, preco, imagePath);
        myApplication.addDrink(novoDrink);

        drinkAdapter.notifyDataSetChanged();

        // Limpando campos
        drinkNomeInput.getText().clear();
        drinkDescInput.getText().clear();
        drinkPrecoInput.getText().clear();
    }

}
