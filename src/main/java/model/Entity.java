package model;

import model.entityAssets.Health;

public class Entity {
    public static final int DEFAULT_DECK_SIZE = 3;
    protected Health stats;
    public String name;
    protected int money;
    public Dice[] diceDeck;

    public Entity(String name, int money, int hp, int def, int bravery, int deckSize){
        stats = new Health(hp, def, bravery);
        this.name = name;
        this.money = money;
        diceDeck = new Dice[deckSize];
    }

    public Entity(String name, int money, int hp, int def, int bravery){
        this(name, money, hp, def, bravery, DEFAULT_DECK_SIZE);
    }
}
