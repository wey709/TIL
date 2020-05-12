import java.awt.*;
import java.lang.Math;


public class Tiger extends Critter {
    public Tiger(){
        super();
    }
    private static int getRandomNumber(){
        int x = (int)Math.random() * 3; //0~2
        return x;
    }

    @Override
    public Color getColor() {
        int randomInt = getRandomNumber();
        if(randomInt == 0){
            return Color.RED;
        }
        else if(randomInt ==1){
            return Color.GREEN;
        }
        else
            return Color.BLUE;
    }

    @Override
    public String toString() {
        String str="TGR";
        return str;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()){
            return Action.INFECT;
        }
        else if(info.getRight()==Neighbor.WALL || info.getFront()==Neighbor.WALL){
            return super.getMove(info);
        }
        else if(info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else
            return Action.HOP;
    }
}
