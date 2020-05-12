import java.awt.*;


public class Bear extends Critter {
    boolean isPolar;
    int moves = 0;
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
        String str = "";
        for(int i=0;i<moves;i++){
            if(i%2==0){
                str = str + "/";
            }
            else{
                str = str + "\\";
            }
        }
        return str;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.frontThreat()){
            moves++;
            return Action.INFECT;
        }
        else{ //다시 해야함
            moves++;
            return Action.HOP;
        }
    }
}
