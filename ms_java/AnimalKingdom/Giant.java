import java.awt.*;

public class Giant extends Critter {
    int moves = -1;
    //boolean isHop = false;
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
            moves++;
            return Action.INFECT;
        }
        else{ // 다시 해야함
            moves++;
            return Action.HOP;
        }
    }

    @Override
    public String toString() {
        if(moves == -1){
            return "";
        }
        int dividedMoves = moves/6;

        if(dividedMoves%3 == 0){
            return "fee";
        }
        else if(dividedMoves%3 ==1 ){
            return "fie";
        }
        else{
            return "foe";
        }
    }


}
