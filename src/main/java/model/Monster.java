package model;

import java.util.Random;

public class Monster extends Entity{

    public Monster(String name, int money, int hp, int def, int bravery, int deckSize) {
        super(name, money, hp, def, bravery, deckSize);
    }

    @Override
    public Dice chooseDice() {
        return diceDeck[new Random().nextInt(0, diceDeck.length)];
    }
    
}
