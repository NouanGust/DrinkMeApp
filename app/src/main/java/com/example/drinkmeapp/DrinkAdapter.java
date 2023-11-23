package com.example.drinkmeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private List<Drink> listaDrinks;
    private Context context;

    public DrinkAdapter(List<Drink> listaDrinks, Context context) {
        this.listaDrinks = listaDrinks;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkAdapter.DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink, parent, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        final Drink drink = listaDrinks.get(position);
        holder.TVnome.setText(drink.getNome());
        holder.TVdescricao.setText(drink.getDescricao());
        holder.TVpreco.setText(drink.getPreco());

        if (context != null) {
            Glide.with(context)
                    .load(Uri.parse(drink.getImagePath())).placeholder(R.drawable.mojito).error(R.drawable.error).into(holder.IVimage);
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalhesActivity.class);
                intent.putExtra("NOME", drink.getNome());
                intent.putExtra("DESCRICAO", drink.getDescricao());
                intent.putExtra("PRECO", drink.getPreco());
                intent.putExtra("IMAGEM", drink.getImagePath());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDrinks.size();
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVimage;
        private TextView TVnome, TVdescricao, TVpreco;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            TVnome = itemView.findViewById(R.id.TVnome);
            TVdescricao = itemView.findViewById(R.id.TVdescricao);
            TVpreco = itemView.findViewById(R.id.TVpreco);
            IVimage = itemView.findViewById(R.id.imageView);

        }

        public void bind(Drink drink) {
            TVnome.setText(drink.getNome());
            TVdescricao.setText(drink.getDescricao());
            TVpreco.setText(drink.getPreco());

            Glide.with(context)
                    .load(Uri.parse(drink.getImagePath())).placeholder(R.drawable.mojito).error(R.drawable.error).into(IVimage);

        }
    }
}
