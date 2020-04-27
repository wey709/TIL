import java.util.Scanner;

public class MazeRunner {
    static Maze myMap = new Maze();
    public static void main(String[] args) {

        intro();

        int moves = 0;
        String msg = "";
        String dir = "";

        while (!myMap.didIWin()) {

            dir = userMove();


            switch (dir){
                case "R":
                    myMap.moveRight();
                    myMap.printMap();
                    moves++;
                    break;

                case "L":
                    myMap.moveLeft();
                    myMap.printMap();
                    moves++;
                    break;

                case "U":
                    myMap.moveUp();
                    myMap.printMap();
                    moves++;
                    break;

                case "D":
                    myMap.moveDown();
                    myMap.printMap();
                    break;
            }

            if(moves==50 || moves==75 || moves==90 || moves==100){
                msg = movesMessage(moves);
                System.out.println(msg);
            }
            if(moves==100 && !myMap.didIWin()){
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
            }
            myMap.printMap();
        }
        System.out.println("Congratulations, you made it out alive! and you did it in " + moves + " moves.");
    }

    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String userMove(){
        Scanner input = new Scanner(System.in); //scanner 객체 전역에서 생성하면 안되나?
        String direction="";
        while(true){
            System.out.println("Where would you like to move? (R, L, U, D)");
            //System.out.println("Can I move right? " + myMap.canIMoveRight() );
            //System.out.println(myMap.col);
            direction = input.next();
            switch (direction){
                case "R":
                    if(myMap.canIMoveRight()) {
                        return direction;
                    }
                    else{
                        if(myMap.isThereAPit("R")){
                            navigatePit("R");
                        }
                        else{
                            System.out.println("Sorry, you\'ve hit a wall");
                        }
                    }
                    break;

                case "L":
                    if(myMap.canIMoveLeft()) {
                        return direction;
                    }
                    else{
                        System.out.println("Sorry, you\'ve hit a wall");
                    }
                    break;

                case "U":
                    if(myMap.canIMoveUp()) {
                        return direction;
                    }
                    else{
                        System.out.println("Sorry, you\'ve hit a wall");
                    }
                    break;

                case "D":
                    if(myMap.canIMoveDown()) {
                        return direction;
                    }
                    else{
                        System.out.println("Sorry, you\'ve hit a wall");
                    }
                    break;

                default:
                    System.out.println("Pick a letter from R, L, U, D");
                    break;


            }

        }

    }
    public static String movesMessage(int moves){
        String msg = "";
        if(moves==50){
            msg = "Warning: You have made 50 moves, you have 50 remaining before the maze exit closes\n";
        }
        else if(moves==75){
            msg = "Alert! You have made 75 moves, you only have 25 moves left to escape.\n";
        }
        else if(moves==90){
            msg = "DANGER! You have made 90 moves, you only have 10 moves left to escape!!\n";
        }
        else {
            msg = "Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[";
        }
        return msg;
    }
    public static void navigatePit(String dir){
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if(answer.substring(0,1).equals("y") || answer.substring(0,1).equals("Y")){
            myMap.jumpOverPit(dir);
        }
        else{
            System.out.println("Choose any other direction: ");
        }
    }
}

