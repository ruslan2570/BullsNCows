package bullsncows;

import java.util.Random;
import java.util.Scanner;

public class Game{

    private final String hiddenNumber;
    private int attempts;
    private final Scanner scanner;

    public Game(){
        hiddenNumber = generateHiddenNumber();
        attempts = 0;
        scanner = new Scanner(System.in);
    }

    public void start(){
        loop();
        win();
    }

    private void loop(){
        while(true) {
            String num = "";
            while(!isRightNumber(num)){
                num = getNumber();
                if (!isRightNumber(num)) {
                    System.out.println("Enter a valid number!");
                }
            }

            attempts++;

            System.out.printf("Bulls: %d\nCows: %d\n%n",
                    getBulls(num), getCows(num));

            if (isWin(num)) {
                return;
            }
        }
    }

    private String getNumber(){
        System.out.print("Enter a number: ");
        return scanner.next();
    }

    private String generateHiddenNumber(){
        Random rnd = new Random();
        while(true){
            Integer num = rnd.nextInt(1000, 9999);
            if(isRightNumber(num.toString()))
                return (num).toString();
        }
    }

    private boolean isRightNumber(String num){
        if(num.length() != 4)
            return false;
        else{
            char[] numArr = num.toCharArray();
            for (int i = 0; i < 4; i++) {
                for (int j = i+1; j < 4; j++) {
                    if(numArr[i] == numArr[j])
                        return false;
                }
            }
            return true;
        }
    }

    private boolean isWin(String num){
        return hiddenNumber.equals(num);
    }
    private int getBulls(String number){
        char[] numberArr = number.toCharArray();
        char[] hiddenArr = hiddenNumber.toCharArray();

        int counter = 0;

        for (int i = 0; i < 4; i++) {
            if(numberArr[i] == hiddenArr[i])
                counter++;
        }

        return counter;
    }

    private int getCows(String number){
        char[] numberArr = number.toCharArray();
        char[] hiddenArr = hiddenNumber.toCharArray();

        int bulls = getBulls(number);

        int counter = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(numberArr[i] == hiddenArr[j])
                    counter++;
            }
        }
        return counter - bulls;
    }

    private void win(){
        System.out.printf("You are win!\nYou guessed the number %s in %d attempts%n",
                hiddenNumber, attempts);
    }

}