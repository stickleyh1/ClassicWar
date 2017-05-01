package cardGame;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CardGame game = new CardGame();
//        System.out.println("How many players are in the game?(2, 4, or 13)");
//        while (in.hasNextLine()) {
//            try {
//                int players = Integer.parseInt(in.nextLine());
//                if (players < 52) {
//                    if (players > 1 && (players == 2 || players == 4 || players == 13)) {
//                        game.play(players);
//                        break;
//                    } else if (players == 1) {
//                        System.out.println("Everyone wins! That was a lonely game.");
//                    } else if (players == 0) {
//                        System.out.println("No one wins, or everyone wins, your call really.");
//                    }else{
//                        System.out.println("Enter a valid number of players!");
//                    }
//                } else {
//                    System.out.println("Enter a valid number of players!");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Enter a valid number of players!");
//            }
//        }
        game.play(2);
    }

}
