package bullsncows;

import java.util.Scanner;

public class BullNCows{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        do {
            Game game = new Game();
            game.start();
            System.out.println("Do you want to play again? (Y/N)");
        } while (!scan.next().equalsIgnoreCase("N"));
    }


}