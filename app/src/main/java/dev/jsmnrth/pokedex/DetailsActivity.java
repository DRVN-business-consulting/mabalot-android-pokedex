package dev.jsmnrth.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
    TextView pokeName, pokeId;
    ImageView pokeImage, pokeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        pokeName = findViewById(R.id.pokeName);
        pokeId = findViewById(R.id.pokeID);
        pokeImage = findViewById(R.id.pokeImg);
        pokeType = findViewById(R.id.pokeType);

        pokeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              goToHome();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int pokemonId = intent.getIntExtra("id", 0);

        switch (pokemonId) {
            case 0001:
                pokeName.setText("Snorlax");
                pokeId.setText("0001");
                pokeType.setImageResource(R.drawable.normal);
                pokeImage.setImageResource(R.drawable.ic_snorlax);
            break;
            case 0002:
                pokeName.setText("Gengar");
                pokeId.setText("0002");
                pokeType.setImageResource(R.drawable.poison);
                pokeImage.setImageResource(R.drawable.ic_gengar);
                break;
            case 0003:
                pokeName.setText("Mimikyu");
                pokeId.setText("0003");
                pokeType.setImageResource(R.drawable.fairy);
                pokeImage.setImageResource(R.drawable.ic_mimikyu);
                break;
            default:
                Toast.makeText(this, "Pokemon not found", Toast.LENGTH_SHORT).show();
                finish();
        }
    }

    public void goToHome (){
        Intent intent = new Intent (this, home.class);
        startActivity(intent);
    }
}