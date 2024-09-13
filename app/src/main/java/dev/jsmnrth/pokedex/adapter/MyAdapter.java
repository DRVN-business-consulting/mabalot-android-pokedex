package dev.jsmnrth.pokedex.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.jsmnrth.pokedex.DetailsActivity;
import dev.jsmnrth.pokedex.R;
import dev.jsmnrth.pokedex.model.Pokemon;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Pokemon> pokemonList;
    private Context context; // Change variable name to context

    public MyAdapter(List<Pokemon> pokemonList, Context context) { // Add context parameter
        this.pokemonList = pokemonList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new MyViewHolder(view); // Simplified return statement
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(holder.getAdapterPosition());
        holder.bind(pokemon);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailsActivity.class); // Use context
            intent.putExtra("id", pokemon.getPokemonId());
            context.startActivity(intent); // Use context
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPokemon;
        TextView tvPokemon;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemon);
            tvPokemon = itemView.findViewById(R.id.tvPokemon);
        }

        public void bind(Pokemon pokemon) {
            ivPokemon.setImageResource(pokemon.getImageResId());
            tvPokemon.setText(pokemon.getName());
        }
    }
}