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
        	gameNumber ++; 
        	moneySpent= moneySpent+6;
        	 console.print("GAME #");
        	 console.setForegroundColor(Color.YELLOW);
        	 console.print(gameNumber);
        	 console.resetColor();
        	 console.print(" Spent: ");
        	 console.setForegroundColor(Color.RED);
        	 console.print(moneySpent);
        	 console.resetColor();
        	 console.print(" Won: " );
        	 console.setForegroundColor(Color.GREEN);
        	 console.println (moneyWon);
        	 console.resetColor();
        	 console.println("");
        	 cast=1;
         	 console.println ("Game is about to start. Press any key to roll your dice");
         	 console.println("");
      	 
         	 while(cast<=3) {
         		 	console.readKey();
         		 	console.print("CAST #"); 
         		 	console.setForegroundColor(Color.YELLOW);
         		 	console.print(cast); 
         		 	console.resetColor();
         		 	console.println("\tGeen\tRed\tRed");
         		 	console.println("\t\t -----\t-----\t-----");
         		 	roll1 = alea.nextInt(1, 7);
        			roll2 = alea.nextInt(1, 7);
        			roll3 = alea.nextInt(1, 7);
        			console.println("\t\t" + roll1 + "\t" + roll2 + "\t" + roll3);
        	
        				if (roll1 >= Math.max(roll2, roll3)) {
        					console.println("");
        					console.println("GOOD, green beats the higher red. Press any key to roll the dice again");
        					console.println("");
        				}
        
        				else {
        					console.println("");
        					console.println("\t NOPE, green does not beat higher red. Gambler, game #" + gameNumber + " ends here");
        					console.println("");
        					console.setForegroundColor(Color.RED);
        					console.print("OH PITTY ");
        					console.resetColor();
        					console.println("green die couldn't do it three times");
        				}
        	
        				if (roll1<roll2 && cast==1  || roll1<roll3 && cast ==1 ) {

        					console.println("it didn't do it even once. YOU WIN NOTHING");
        					cast=4;
        					playTheGame = false;
        				}
        				
        				else if (roll1<roll2 && cast==2 || roll1<roll3 && cast==2){
        					console.println("but it manage to do it ONCE. YOU WIN TWO bucks");
        					moneyWon += 2;
        					cast=4;
        					playTheGame = false;
        				}
        				else if (roll1<roll2 && cast==3 || roll1<roll3 && cast==3) {
        					console.println("but it manage to do it TWICE. YOU WIN THREE bucks");
        					moneyWon += 3;
        					cast=4;
        					playTheGame = false;
        				}
        				
        				
        				if (cast==3) {
        					console.println("Excelent! green die BEASTED the red ones THREE times");
        					console.println("You win 60 bucks");
        					moneyWon += 60;
        					playTheGame = false;
        				}
        				else {
        					console.print("");
        				}
        				
        	cast++;
      	 } 	
         	 console.println("");
         	 console.println("");
             console.println("Play again? (y/Y or n/N)");
             console.setForegroundColor(Color.GREEN);
             answer = console.readChar();
             console.resetColor();
             if (answer == 'y' || answer == 'Y') {
             	playTheGame = true;
             	console.clear();
             	
             	}
             	
             	else if	(answer ==  'n' || answer ==  'N' ) {

             		}
             			else {
             				while(answer !='y'&& answer !='Y'&& answer !='n'&& answer !='N') {
             						console.setForegroundColor(Color.RED);
             						console.println("Wrong answer");
             						console.setForegroundColor(Color.RED);
             			             answer = console.readChar();
             			             console.resetColor();
      
             				}
             			}
   }

	// End of the outer iteration
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
