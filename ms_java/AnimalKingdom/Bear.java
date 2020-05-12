import java.awt.*;


public class Bear extends Critter {
    boolean isPolar;
    public Bear(boolean polar){
        isPolar = polar;
    }

    @Override
    public Color getColor() {
        if(isPolar){
            return Color.WHITE;
        }
        return super.getColor();
    }


    @Override
    public String toString() {
        //잘 모르겠음
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()){
            return Action.INFECT;
        }
        if(info.getFront()==Neighbor.EMPTY){ //조건 맞는지 잘 모르겠음
            return Action.HOP;
        }
        return super.getMove(info);
    }
}
