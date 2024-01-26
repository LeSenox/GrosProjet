package model;

import utils.Subject;

public class Game extends Subject {
    public Coordinate playerPos;
    public Player player;
    public int turn;
    public Board board;

    public Game(Board board){
        this.playerPos = new Coordinate(0, 0);
        this.board = board;
        turn = 0;
    }

    public Game(){
        this(new Board());
    }

    public void nextTurn(){
        turn++;
        //TODO ALL OTHER THINGS
    }

}
