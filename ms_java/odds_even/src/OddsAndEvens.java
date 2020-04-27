import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args){
        //part1
        System.out.println("Let’s play a game called “Odds and Evens");
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
        String choosed = input.next();
        if (choosed.equals('O') || choosed.equals('o')){
            System.out.println(name +" has picked odds! The computer will be evens.");
        }
        else if (choosed.equals('E') || choosed.equals('e')){
            System.out.println(name +" has picked evens! The computer will be odds.");
        }
        System.out.println("-------------------------------------");

        //part2
        System.out.println("How many “fingers” do you put out?");
        int userFinger = input.nextInt();
        Random rand = new Random();
        int computerFinger = rand.nextInt(6);
        System.out.println("The computer plays number " + computerFinger);
        System.out.println("-------------------------------------");
        int sum = userFinger + computerFinger;
        boolean oddOrEven = sum % 2 ==0;
        System.out.println("-------------------------------------");

        //part3
        System.out.println(userFinger +" + " +computerFinger+" = "+sum);
        if (oddOrEven){
            System.out.println(sum + " is even");
            if (userFinger%2 == 0){
                System.out.println("That means "+name +"wins");
        }
            else{
                System.out.println("That means the computer wins");
            }
        }

        else{
            System.out.println(sum + " is odd");
            if (userFinger%2 == 1){
                System.out.println("That means "+name +"wins");
            }
            else{
                System.out.println("That means the computer wins");
            }
        }




    }
}
