import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class Battleship {

    public class Coordinates{
        int x;
        int y;

        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return  "\tx:\t" + x + "\ty:\t" + y ;
        }
    }

    public static void main(String args[]){

        Random _Random = new Random();

        //step1. create the ocean map
        String[][] map = new String[10][10];
        System.out.println("   0123456789\r");
        for(int i=0; i<map.length; i++){
            System.out.print(i);
            System.out.print(" |");
            for(int j=0; j<map[0].length; j++){
                System.out.print(" ");
            }
            System.out.print(" |");
            System.out.println(i);
        }
        System.out.println("   0123456789\r");

        //step2. deploy player's ships
        Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use

        for(int i=0; i<5; i++){
            while(1==1){
                System.out.print("Enter X coordinate for your ship " + i + ": ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship " + i + ": ");
                int y = input.nextInt();
                if(map[x][y]==null && x>0 && y>0 && x<10 && y<10){
                    // float 어떻게 할건지
                    map[x][y] = "@";
                    break;
                }
                System.out.println("duplicated or out of bound");
        }
        }
        //현재 상태 프린트 하는 줄 추가해야함

        //step3. deploy computer's ships
        int mapComp[][] = new int[10][10];

        for(int i=0; i<5; i++){
            while(1==1){
                int x = _Random.nextInt(10);
                int y = _Random.nextInt(10);

                if(map[x][y]==null && x>0 && y>0 && x<10 && y<10){
                    mapComp[x][y] = 2;
                    System.out.println("computer's ship"+i+" deployed");
                    break;
                }
            }
        }

        //step4. battle
        int numCom = 5;
        int numPlayer = 5;

        ArrayList<Coordinates[]> comGuess = new ArrayList<Coordinates[]>();
        ArrayList<Coordinates[]> playerGuess = new ArrayList<Coordinates[]>();
        //ArrayList<int[]> playerGuess = new ArrayList<int[]>();

        Coordinates xyRandom = new Coordinates(0, 0);
        Coordinates xyPlayer = new Coordinates(0,0);
        //int[] xyRandom = new int[2]; // 컴퓨터 이 때까지 추측 보관할 리스트
        //int[] xyPlayer = new int[2];
        //x,y 좌표 보관을 위해 클래스 구현하고, 여기까지 코드 바꾸다 그만둠.


        while(numCom!=0 && numPlayer!=0) {

            System.out.println("YOUR TURN");
            Scanner playerInput = new Scanner(System.in);
            int x;
            int y;
            while(1==1) {
                System.out.print("Enter X coordinate: ");
                x = playerInput.nextInt();
                System.out.print("Enter Y coordinate: ");
                y = playerInput.nextInt();

                xyPlayer.x = x;
                xyPlayer.y = y;

                if(playerGuess.contains(xyPlayer) == true || comGuess.contains(xyPlayer) == true){
                    System.out.println(xyPlayer.toString());
                    System.out.println("Already destroyed");
                }
                else{
                    playerGuess.add(xyPlayer); //
                    break;
                }
            }
                if (mapComp[x][y] == 2) {
                    System.out.println("Boom! You sunk the ship!");
                    map[x][y] = "!";
                    --numCom;


                }
                if (map[x][y] == "@") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    map[x][y] = "X";
                    --numPlayer;

                }
                if (map[x][y] == null && mapComp[x][y] == 0) {
                    System.out.println("Sorry, you missed");
                    map[x][y] = "-";

                }


            System.out.println("COMPUTER'S TURN");


            int xRandom = 0;
            int yRandom = 0;

            while (1 == 1) {
                xRandom = _Random.nextInt(10);
                yRandom = _Random.nextInt(10);
                xyRandom.x = xRandom;
                xyRandom.y = yRandom;
                if (comGuess.contains(xyRandom) == false && playerGuess.contains(xyRandom) == false) {
                    comGuess.add(xyRandom);
                    break;
                }
            }


            if (mapComp[xRandom][yRandom] == 2) {
                System.out.println("The Computer sunk one of its own ships");
                map[xRandom][yRandom] = "!";
                --numCom;
            }

            if (map[xRandom][yRandom] == "@") {
                System.out.println("The Computer sunk one of your ships!");
                map[xRandom][yRandom] = "x";
                --numPlayer;
            }

            if (map[xRandom][yRandom] == null && mapComp[xRandom][yRandom] == 0) {
                System.out.println("Computer missed");
            }
        }




    }


}
