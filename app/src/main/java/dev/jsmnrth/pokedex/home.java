package dev.jsmnrth.pokedex;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.jsmnrth.pokedex.adapter.MyAdapter;
import dev.jsmnrth.pokedex.model.Pokemon;

public class home extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter myAdapter;

    List<Pokemon> pokemonList = List.of(
            new Pokemon("Snorlax", R.drawable.normal, R.drawable.ic_snorlax, 0001),
            new Pokemon("Gengar", R.drawable.poison, R.drawable.ic_gengar, 0002),
            new Pokemon("Mimikyu",R.drawable.fairy, R.drawable.ic_mimikyu, 0003)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(pokemonList, this);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(myAdapter);

    }
}