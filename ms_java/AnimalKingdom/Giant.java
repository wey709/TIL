import java.awt.*;

public class Giant extends Critter {
    static int moves = 0;
    public Giant(){
        super();
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()){
            return Action.INFECT;
        }
        else if(info.)
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
