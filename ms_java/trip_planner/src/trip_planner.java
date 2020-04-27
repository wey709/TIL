import java.util.Scanner;

public class trip_planner {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.print("Nice to meet you " +name+" where are you travelling to? " );
        String place = input.next();
        System.out.println("Great! " + place + " sounds like a great trip");
        System.out.println("**********");
        System.out.print("How many days? " );
        int days = input.nextInt();
        System.out.print("How much money, in USD? ");
        double budget = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String symbol = input.next();
        System.out.print("How many " +symbol+ " are there in 1 USD? ");
        double perUsd = input.nextDouble();

        System.out.print("If you are travelling for 14 days that is the same as "+days*24+" hours or "+days*24*60+ " minutes");
        System.out.print("If you are going to spend $"+budget+" USD that means per day you can spend up to "+budget/days+ " USD");
        System.out.print("Your total budget in "+symbol+" is "+ part2(perUsd,budget) +symbol+ ", which per day is "+ part2(perUsd,budget)/days);
        System.out.println("**********");

        //part3 time difference
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int timeDiff = input.nextInt();
        int newTimeDiff = part3(timeDiff);
        System.out.println("That means that when it is midnight at home it will be "+ timeDiff + ":00 in your travel destination and when it it noon at home it will be "+newTimeDiff+":00");
        System.out.println("**********");

        //part4 country area
        System.out.print("What is the square area of your destination country in km2? ");
        double km2 = input.nextDouble();
        System.out.println("In miles2 that is "+part4(km2));

    }

    public static double part2(double perUsd, double budget){
        double inSymbol = perUsd*budget;
        return inSymbol;
    }

    public static int part3(int timeDiff){
        int newDiff = 0;
        if(12+timeDiff>24) {
            newDiff = (12 + timeDiff) % 24;
        }
        else{
            newDiff = 12+timeDiff;
        }
        return newDiff;
    }

    public static double part4(double km2){
        double mile2 = km2*0.386102;
        return mile2;
    }
}

