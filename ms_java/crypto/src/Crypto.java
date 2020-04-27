import java.util.Scanner;
public class Crypto {
public static void main(String[] args){
    //part1
    Scanner input= new Scanner(System.in);
    System.out.print("say something: ");
    String inputText = input.nextLine();
    System.out.print("shift : ");
    int inputShift = input.nextInt();
    System.out.print("size : ");
    int inputSize = input.nextInt();

    String encRes = encryptString(inputText,inputShift,inputSize);
    System.out.println(encRes);

}
public static String normalizeText(String str){
    str = str.replaceAll(" ", "");
    str = str.replaceAll("[^a-zA-Z ]", "");
    str = str.toUpperCase();
    return str;
}

public static String shiftAlphabet(int shift) {
    int start = 0;
    if (shift < 0) {
        start = (int) 'Z' + shift + 1;
    } else {
        start = 'A' + shift;
    }
    String result = "";
    char currChar = (char) start;
    for(; currChar <= 'Z'; ++currChar) {
        result = result + currChar;
    }
    if(result.length() < 26) {
        for(currChar = 'A'; result.length() < 26; ++currChar) {
            result = result + currChar;
        }
    }
    return result;
}

public static String groupify(String str, int size){
    int lens = str.length();
    int iter = lens/size;
    int remainder = lens%size;

    String paddedStr="";
    String subStr="";
    String results="";

    for(int i=0;i<lens;){
        if(i+size > lens){
            break;
        }
        subStr = str.substring(i, i+size);
        subStr = subStr + " ";
        results = results + subStr;
        i = i+size;
    }

    if(remainder!=0){
        paddedStr = str.substring(lens-remainder);
        String x = "";
        for(int j=0;j<size-remainder;j++){
            x = x + "x";
        }
        paddedStr = paddedStr + x;
    }

    results = results + paddedStr;

    return results;
}

public static String encryptString(String str, int shiftBy, int size){
String normedStr = normalizeText(str);
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String alphabetT = shiftAlphabet(shiftBy);
String results = "";
int chaIdx=0;
char cha;
char chaResult;
for(int i=0;i<normedStr.length();i++){
    cha = normedStr.charAt(i); // 알파벳 추출
    chaIdx = alphabet.indexOf(cha); // 원래 알파벳에서의 위치
    chaResult = alphabetT.charAt(chaIdx); //
    results = results + chaResult;
}
results = groupify(results, size);
return results;
}
}