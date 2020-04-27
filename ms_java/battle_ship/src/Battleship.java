import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class Battleship {
    //Random random = new Random();
    //Player player = new Player();

    public static class Coordinates{
        int x;
        int y;

        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String args[]){
        Player player = new Player();
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        ArrayList<Coordinates> comGuessed = new ArrayList<Coordinates>();
        ArrayList<Coordinates> playerGuessed = new ArrayList<Coordinates>();

        //step1. create the ocean map & print it
        player.printMap();

        //step2. deploy player's ships
        player.fillMap();

        //step3. deploy computer's ships
        int[][] MapC = new int[10][10];
        int numShipC = 5;
        for(int i=0; i<5; i++){
            while(true){
                int x = random.nextInt(10);
                int y = random.nextInt(10);

                if(player.Map[x][y]==null && x>=0 && y>=0 && x<10 && y<10){
                    MapC[x][y] = 2;
                    System.out.println("computer's ship"+i+" deployed");
                    break;
                }
            }
        }

        //step4. battle
        while(true){
            System.out.println("Your turn");
            while(true) {
                Coordinates coordinates = new Coordinates(0,0);
                System.out.print("Enter X coordinates: ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinates: ");
                int y = input.nextInt();
                coordinates.x = x;
                coordinates.y = y;
                boolean alreadyChose = false; // 이렇게까지 구질구질하게 해야하는가...
                for(int i=0; i<playerGuessed.size();i++){
                    if(coordinates.x == playerGuessed.get(i).x && coordinates.y == playerGuessed.get(i).y){
                        alreadyChose = true;
                        break;
                    }
                }
                if(!alreadyChose){
                    playerGuessed.add(coordinates);

                    if(player.Map[x][y]=="@"){
                        player.Map[x][y]="x";
                        player.numShip--;
                        System.out.println("Oh no, you sunk your own ship :(");

                    }
                    else if(MapC[x][y]==2){
                        player.Map[x][y]="!";
                        numShipC--;
                        System.out.println("Boom! You sunk the ship!");

                    }
                    else{
                        player.Map[x][y]="-";
                        System.out.println("Sorry, you missed");

                    }
                    break;
                }
                else{
                    //System.out.println("뭐야? "+playerGuessed.contains(coordinates));
                    System.out.println("You already chose.");
                }
            }
            if(!player.isAlive() || numShipC==0){
                if(!player.isAlive()){
                    System.out.println("You lose!");
                    System.exit(0);
                }
                else{
                    System.out.println("You win!");
                }
            }
            player.printMap();
            System.out.println("COMPUTER'S TURN");
            while(true){
                Coordinates coordinates = new Coordinates(0,0);
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                coordinates.x = x;
                coordinates.y = y;
                if(!comGuessed.contains(coordinates)){
                    comGuessed.add(coordinates);
                    if(player.Map[x][y]=="@"){
                        player.Map[x][y]="x";
                        player.numShip--;
                        System.out.println("The Computer sunk one of your ships!");

                    }
                    else if(MapC[x][y]==2){
                        player.Map[x][y]="!";
                        numShipC--;
                        System.out.println("The Computer sunk one of its own ships");
                    }
                    else{
                        player.Map[x][y]="-";
                        System.out.println("Computer missed");

                    }
                    break;
                }

            }
            if(!player.isAlive() || numShipC==0){
                if(!player.isAlive()){
                    System.out.println("You lose!");
                    System.exit(0);
                }
                else{
                    System.out.println("You win!");
                }
            }

        }
    }
}
