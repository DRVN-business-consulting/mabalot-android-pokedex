package dev.jsmnrth.pokedex.model;

public class Pokemon {
    private String name;
    private int imageResId,pokeType, pokemonId;

    public Pokemon(String name, int pokeType, int imageResId, int pokemonId) {
        this.name = name;
        this.pokeType = pokeType;
        this.imageResId = imageResId;
        this.pokemonId = pokemonId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public int getPokeType() {
        return imageResId;
    }

    public void setPokeType(int pokeType) {
        this.pokeType = pokeType;
    }
}
