package model;

public class Buff {
    protected int tag;
    protected int value;
    protected int timeLeft;

    public Buff(int tag, int value, int time){
        this.tag = tag;
        this.value = value;
        this.timeLeft = time;
    }

    public void decrementTime(){
        --timeLeft;
    }

    public boolean isFinished(){
        return timeLeft <= 0;
    }
}
