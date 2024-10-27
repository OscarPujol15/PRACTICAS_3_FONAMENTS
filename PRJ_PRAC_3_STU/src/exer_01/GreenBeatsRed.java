package exer_01;

import jconsole.JConsole;
import java.awt.Color;
import java.util.*;

public class GreenBeatsRed {
	
	public static void main (String [] args) {

        boolean playTheGame; // true if the user wants to play (again)
        char answer; // used to read y/Y/n/N answers from user 
        int gameNumber, moneySpent, moneyWon;
        

        JConsole console = new JConsole(80, 40);
        
        //Random alea = new Random();
        
        Random alea = new ChargedDie(console);
        
        gameNumber = 0;
        moneySpent = 0;
        moneyWon = 0;

        Introduction(console); // this is a procedure call. Leave it here. It just show the introduction text


        playTheGame = true;
        while (playTheGame) { 
        	 /* COMPLETE */
        } // End of the outer iteration
        // why has this point been reached?
        // because player has decided not to play again and as a consequence
        // variable playTheGame has been set to false
        
        // Farewell
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
	

	// this is a procedure. Do not remove it. Do not change it.
    private static void Introduction (JConsole console)
    {
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
class ChargedDie extends Random
{
    private static String[] seqs = {
        "432525321656212451323546415"
    };

    private int pos = 0;
    private String sequence;

    public ChargedDie(JConsole console)
    {
        console.println("Reproducing fixed sequence");
        console.print("Pres any key to proceed ");
        console.readKey();
        console.clear();

        sequence = seqs[0];
    }

    public int nextInt(int lower, int upper)
    {
        int value;

        value = Integer.parseInt(sequence.substring(pos, pos+1));

        pos = (pos + 1) % sequence.length();
        return value;
    }
    
    public int nextInt (int upper) {
    	return nextInt(1, upper)-1;
    }
    
    
} // ChargedDie ends here
