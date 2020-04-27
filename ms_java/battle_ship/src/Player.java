import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Player{
    Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
    public String[][] Map;
    int[][] MapC;
    int numShip;
    int numShipC;

    public Player(){
        Map = new String[10][10];
        MapC =  new int[10][10];
        numShip = 5;
        numShipC = 5;
    }

    public void fillMap(){
        System.out.println("watch out");
        for(int i=0; i<5; i++){
            while(true){
                System.out.print("Enter X coordinate for your ship " + i + ": ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship " + i + ": ");
                int y = input.nextInt();
                if(Map[x][y]==null && x>=0 && y>=0 && x<10 && y<10){
                    // float 어떻게 할건지
                    Map[x][y] = "@";
                    break;
                }
                System.out.println("duplicated or out of bound");
            }
        }
    }



    public boolean isAlive(){
        if(numShip == 0) {
            return false;
        }
        return true;
    }



    public void printMap(){
        System.out.println("   0123456789\r");
        for(int i = 0; i< Map.length; i++){
            System.out.print(i);
            System.out.print(" |");
            for(int j = 0; j< Map[0].length; j++){
                if(Map[i][j]==null){
                    System.out.print(" ");
                }
                else{
                    System.out.print(Map[i][j]);
                }
            }
            System.out.print(" |");
            System.out.println(i);
        }
        System.out.println("   0123456789\r");
    }

}