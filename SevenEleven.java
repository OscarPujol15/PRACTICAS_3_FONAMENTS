package exer_02;

import java.awt.Color;
import java.util.Random;
import jconsole.JConsole;

public class SevenEleven {
	
	public static void main (String [] args) {
		
		// Declare your variables here
        
        JConsole console = new JConsole(110, 40);
        
        //Random alea = new Random();
        Random alea = new FakeRandom(console);

        console.println("--------------------------------");
        console.println("SEVEN-ELEVEN Matching Experiment");
        console.println("--------------------------------\n");

        /* COMPLETE (Use procedure ShowPair whenever possible) */
        
        console.println();
        console.readKey(true);
        System.exit(0);
        
	} // end of main
	
	public static void ShowPair(int one, int two, JConsole console)
    {
        if (one + two == 7) console.setForegroundColor(Color.CYAN);
        else if (one + two == 11) console.setForegroundColor(Color.MAGENTA);
        console.print("("+one+" "+two+") ");
        console.resetColor();
    }

}

//do not modify this code.
class FakeRandom extends Random
{
    private static String[] seqs = {
        "2446311116445156",
        "25543425243133635333326465",
        "54323421164115546314115663624246531225332243442154645235533646362434542115253222154621236335336255261531253665",
        "15466116456524352614124442266616525316615463631324513266263551645611614261542251165321442522322543",
        "64323263462346666336624315313643642252442414164444633335161566642646451565431622263512642425165254323466324451414631411665",
        "433456654356",
        "56",
        "1652",
        "23"
    };

    private int pos = 0;
    private String sequence;

    public FakeRandom (JConsole console)
    {
        int seqNum;
        console.print("Enter sequence>");
        console.setForegroundColor(Color.GREEN);
        seqNum = console.readInt();
        console.resetColor();
        console.clear();

        sequence = seqs[seqNum - 1];
    }

    public  int nextInt(int lower, int upper)
    {
        int value;

        value = Integer.parseInt(sequence.substring(pos, pos+1));

        pos = (pos + 1) % sequence.length();
        return value;
    }
    
    public int nextInt (int upper) {
    	return nextInt(1, upper)-1;
    }
    
} // FakeRandom ends here
