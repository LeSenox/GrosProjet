package model;

public class Player extends Entity {

    public Player(String name, int money, int hp, int def, int bravery) {
        super(name, money, hp, def, bravery);
    }

    @Override
    public Dice chooseDice() {
        return diceDeck[0];
    }

}
