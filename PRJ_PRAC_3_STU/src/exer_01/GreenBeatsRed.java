package exer_01;

import jconsole.JConsole;
import java.awt.Color;
import java.util.*;

public class GreenBeatsRed {

    public static void main(String[] args) {

        boolean playTheGame;
        char answer;
        int gameNumber, moneySpent, moneyWon;
        int roll1, roll2, roll3;
        int cast;

        JConsole console = new JConsole(80, 40);
        Random alea = new ChargedDie(console);

        gameNumber = 0;
        moneySpent = 0;
        moneyWon = 0;

        Introduction(console);

        playTheGame = true;
        while (playTheGame) {
            gameNumber++;
            moneySpent += 6;

            console.print("GAME #");
            console.setForegroundColor(Color.YELLOW);
            console.print(gameNumber);
            console.resetColor();
            console.print(" Spent: ");
            console.setForegroundColor(Color.RED);
            console.print(moneySpent);
            console.resetColor();
            console.print(" Won: ");
            console.setForegroundColor(Color.GREEN);
            console.println(moneyWon);
            console.resetColor();
            console.println("");

            cast = 1;
            console.println("Game is about to start. Press any key to roll your dice\n");

            int greenWins = 0;

            while (cast <= 3) {
                console.readKey();
                console.print("  CAST #");
                console.setForegroundColor(Color.YELLOW);
                console.print(cast);
                console.resetColor();
                console.println("  Green   Red   Red");
                console.println("           -----   ---   ---");

                roll1 = alea.nextInt(1, 7);
                roll2 = alea.nextInt(1, 7);
                roll3 = alea.nextInt(1, 7);

                console.print("         ");
                console.setForegroundColor(Color.GREEN);
                console.print("    " + roll1 + "     ");
                console.resetColor();
                console.setForegroundColor(Color.RED);
                console.print(roll2 + "     ");
                console.print(roll3);
                console.resetColor();
                console.println("\n");

                if (roll1 >= Math.max(roll2, roll3)) {
                    greenWins++;
                    console.println("  GOOD, green beats the higher red. Press any key to roll the dice again\n");
                } else {
                    console.println("  NOPE, green does not beat higher red. Gambler, game #" + gameNumber + " ends here\n");
                    break;
                }

                cast++;
            }

            if (greenWins == 3) {
                console.setForegroundColor(Color.GREEN);
                console.print("EXCELLENT !!! ");
                console.resetColor();
                console.println("green die BESTED the red ones THREE times");
                console.println("You win 60 bucks");
                moneyWon += 60;
            } else if (greenWins == 2) {
                console.setForegroundColor(Color.RED);
                console.print("OH PITY !!! ");
                console.resetColor();
                console.println("green die couldn't do it three times");
                console.println("but it managed to do it TWICE. YOU WIN THREE bucks");
                moneyWon += 3;
            } else if (greenWins == 1) {
                console.setForegroundColor(Color.RED);
                console.print("OH PITY !!! ");
                console.resetColor();
                console.println("green die couldn't do it three times");
                console.println("but it managed to do it ONCE. YOU WIN TWO bucks");
                moneyWon += 2;
            } else {
                console.setForegroundColor(Color.RED);
                console.print("OH PITY !!! ");
                console.resetColor();
                console.println("green die couldn't do it three times");
                console.println("it didn't do it even once. YOU WIN NOTHING");
            }

            console.println("\nPlay Again? (y/Y or n/N)");
            console.setForegroundColor(Color.GREEN);
            answer = console.readChar();
            console.resetColor();

            while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
                console.setForegroundColor(Color.RED);
                console.println("Wrong Answer!!!");
                console.resetColor();
                console.println("\nPlay Again? (y/Y or n/N)");
                console.setForegroundColor(Color.GREEN);
                answer = console.readChar();
                console.resetColor();
            }

            if (answer == 'y' || answer == 'Y') {
                playTheGame = true;
                console.clear();
            } else {
                playTheGame = false;
            }

        }

        console.clear();
        console.println();
        console.print("After ");
        console.setForegroundColor(Color.YELLOW);
        console.print(gameNumber);
        console.resetColor();
        console.println(" games you have decided not to play again");
        console.print("You have spent ");
        console.setForegroundColor(Color.RED);
        console.print(moneySpent);
        console.resetColor();
        console.print(" bucks and you have won ");
        console.setForegroundColor(Color.GREEN);
        console.println(moneyWon);
        console.resetColor();
        console.print("The final balance is: ");
        if (moneyWon - moneySpent >= 0) console.setForegroundColor(Color.GREEN);
        else console.setForegroundColor(Color.RED);
        console.println(moneyWon - moneySpent);
        console.resetColor();
        console.println("\n");
        console.print("Press any key to leave the casino ");
        console.readKey();
        System.exit(0);
    }

    private static void Introduction(JConsole console) {
        console.println("---------------");
        console.println("GREEN BEATS RED");
        console.println("---------------");
        console.println();
        console.println("WELCOME to this humble casino");
        console.println("Here you can play our star (and only) game: GREEN BEATS RED");
        console.println();
        console.println("You play with three regular dice: one green two red");
        console.println("You pay 6 bucks to enter each game");
        console.println("You cast your three dice once, twice or three times");
        console.println();
        console.println("If, FOR THREE TIMES IN A ROW, your green is higher than or equal to the maximum of the red ones");
        console.println("YOU GET 60 BUCKS");
        console.println();
        console.println("If, FOR TWO TIMES IN A ROW, your green is higher than or equal to the maximum of the red ones");
        console.println("but in the third cast your green is lower than the maximum of the red ones");
        console.println("YOU GET 3 BUCKS");
        console.println();
        console.println("If, in the first cast, your green is higher than or equal to the maximum of the red ones");
        console.println("but in the second cast your green is lower than the maximum of the red ones");
        console.println("there's no third cast but YOU GET 2 BUCKS");
        console.println();
        console.println("But, if in the first cast, your green is lower than the maximum of the reds");
        console.println("there's no second cast and YOU GET NOTHING");
        console.println();

        console.print("Press any key to enter your first game. Good Lucky luck ");
        console.readKey(true);
        console.clear();
    }
}

//do not modify this code.
class ChargedDie extends Random {
    private static String[] seqs = {
        "432525321656212451323546415"
    };

    private int pos = 0;
    private String sequence;

    public ChargedDie(JConsole console) {
        console.println("Reproducing fixed sequence");
        console.print("Press any key to proceed ");
        console.readKey();
        console.clear();

        sequence = seqs[0];
    }

    public int nextInt(int lower, int upper) {
        int value;

        value = Integer.parseInt(sequence.substring(pos, pos + 1));

        pos = (pos + 1) % sequence.length();
        return value;
    }

    public int nextInt(int upper) {
        return nextInt(1, upper) - 1;
    }
}
