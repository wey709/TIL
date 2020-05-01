import java.util.ArrayList;
import java.util.Scanner;



public class FractionCalculator {
    public static void main(String args[]){
        System.out.println("이건 분수 계산기다! ");
        String operation = getOperation();
        Fraction frOne = getFraction();
        Fraction frTwo = getFraction();
        Fraction results = new Fraction();
        if(operation.equals("+")){
            results= frOne.add(frTwo);
        }
        else if(operation.equals("-")){
            results = frOne.subtract(frTwo);
        }
        else if(operation.equals("*")){
            results = frOne.multiply(frTwo);
        }
        else if(operation.equals("/")){
            results = frOne.divide(frTwo);
        }
        else{
            System.exit(0);
        }
        results.toLowestTerms();
        String strFrOne = frOne.toString();
        String strFrTwo = frTwo.toString();
        String res = results.toString();

        System.out.println(strFrOne + operation + strFrTwo +" = "+res);
    }
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> negativeAt = new ArrayList<Integer>();
    static int slashAt = 0;

    private static String getOperation(){
        String[] opArr = {"+", "-", "/", "*", "="};
        System.out.println("please enter an operation (+, -, /, *, = or Q to quit) ");
        String inputOp = input.next();
        for(int i=0;i<opArr.length; i++){
            if(opArr[i].equals(inputOp)){
                return inputOp;
            }
        }
        if(inputOp.equals("q") || inputOp.equals("Q")){
            System.exit(0);
        }
        while(true){
            System.out.println("Invalid input. please enter an operation (+, -, /, *, = or Q to quit) ");
            for(int i=0;i<opArr.length; i++){
                if(opArr[i].equals(inputOp)){
                    return inputOp;
                }
            }
            if(inputOp.equals("q") || inputOp.equals("Q")){
                System.exit(0);
            }
            inputOp = input.next();
        }
    }

    private static boolean validFraction(String str) {
        removeNegative(str); //그냥 마이너스 0~2개라고 가정, '/'도 하나라고 가정.
        Boolean isNum = isNumber(str);
        return isNum;
    }

    private static void removeNegative(String str){

        System.out.println("print arraylist size: "+ negativeAt.size());
        int len = str.length();
        for (int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '-'){
                negativeAt.add(i);
            }
        }
        if(negativeAt.size()==1){
            String strOne = str.substring(0, negativeAt.get(0));
            String strTwo = str.substring(negativeAt.get(0)+1,len);
            str = strOne.concat(strTwo);
        }
        else if(negativeAt.size()==2){
            String strOne = str.substring(0, negativeAt.get(0));
            String strTwo = str.substring(negativeAt.get(0)+1, negativeAt.get(1));
            String strThree = str.substring(negativeAt.get(1)+1, negativeAt.size());
            str = strOne.concat(strTwo);
            str = str.concat(strThree);
        }

    }


    private static boolean isNumber(String str){
        for(int i =0; i<str.length();i++){
            int ascii = str.charAt(i);
            if(ascii <47 || ascii>57){ //slash까지 포함
                return false;
            }
        }
        return true;
    }

    private static Fraction getFraction(){
        int denominator = 1;
        int numerator = 0;
        System.out.println("Please enter a fraction (a/b) or (a), where a and b are integers and b is not zero");
        String inputFrac = input.next();
        while(!validFraction(inputFrac)){
            System.out.println("Invalid input. Please enter a fraction (a/b) or (a), where a and b are integers and b is not zero");
            inputFrac = input.next();
        }
        int len = inputFrac.length();
        for (int i = 0; i<inputFrac.length(); i++){
            if(inputFrac.charAt(i) == '/'){
                slashAt = i;
            }
        }
        if(slashAt!=0){
            numerator = Integer.parseInt(inputFrac.substring(0,slashAt));
            denominator = Integer.parseInt(inputFrac.substring(slashAt+1,inputFrac.length()));
            //slash 사이로 substring 각각이 numerator & denominator
        }
        else if(slashAt==0 && len!=0){
            numerator = Integer.parseInt(inputFrac);
        }

        Fraction fr = new Fraction(numerator, denominator);
        return fr;
    }




}
