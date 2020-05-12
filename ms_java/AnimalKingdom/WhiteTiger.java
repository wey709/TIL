import java.awt.*;

public class WhiteTiger extends Critter {

    boolean hasInfected = false;

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        if(hasInfected){
            return "TGR";
        }
        else
            return "tgr";
    }

    public Action getMove(CritterInfo info) {
        if(info.frontThreat()){
            hasInfected = true;
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
