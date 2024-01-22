package model.entityAssets;

public class Buff {
    protected int tag;
    protected int value;
    protected int timeLeft;

    public Buff(int tag, int value, int time){
        this.tag = tag;
        this.value = value;
        this.timeLeft = time;
    }

    /**
     * 
     * @param tag target the stats chosen
     * @param value the amount of points
     * if the time equals -1 it means it's a permanent item
     */
    public Buff(int tag, int value){
        this(tag, value, -1);
    }

    public void decrementTime(){
        --timeLeft;
    }

    public boolean isFinished(){
        return timeLeft == 0;
    }
}
