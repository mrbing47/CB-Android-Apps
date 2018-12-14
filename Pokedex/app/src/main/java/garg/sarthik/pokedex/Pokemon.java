package garg.sarthik.pokedex;

import java.util.ArrayList;


public class Pokemon {

    String name;
    int weight;
    int height;
    int id;
    int order;
    int base_experience;
    Sprites sprites;
    ArrayList<Stats> stats;
    ArrayList<Abilities> abilities;
    ArrayList<Poke_Types> types;
    ArrayList<heldItems> held_items;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public ArrayList<Abilities> getAbilities() {
        return abilities;
    }

    public ArrayList<Poke_Types> getTypes() {
        return types;
    }

    public ArrayList<heldItems> getHeld_items() {
        return held_items;
    }

}










