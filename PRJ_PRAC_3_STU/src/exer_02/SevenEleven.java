package exer_02;

import java.awt.Color;
import java.util.Random;
import jconsole.JConsole;

public class SevenEleven {

    public static void main(String[] args) {
        // Declarar variables
        int experiment = 0; // inicializar variable experimento
        int maxExperiments = 9; // máximo número de intentos posibles
        boolean matchFound = false;

        JConsole console = new JConsole(110, 40);
        Random alea = new FakeRandom(console);

        console.println("--------------------------------");
        console.println("SEVEN-ELEVEN Matching Experiment");
        console.println("--------------------------------\n");

        while (experiment < maxExperiments && !matchFound) { // Mientras los trials no superen 9 y no haya match, entonces...
            console.print("TRIAL " + (experiment + 1) + " :");

            // inicializadores de contadores, alea1, alea2 y sum
            int pairCount = 0;
            int elevenCount = 0;
            int sevenCount = 0;
            int one, two, sum;

            
            while (pairCount < 10 && !matchFound) { // Mientras haya menos de 10 pares y no haya match, entonces...
                one = alea.nextInt(1, 7); // alea1
                two = alea.nextInt(1, 7); // alea2
                ShowPair(one, two, console);
                sum = one + two; // Establecer la suma de alea1 alea2 
                if (sum == 11) {
                    elevenCount++; // Contador de elevens
                }
                if (sum == 7) {
                    sevenCount++; // Contador de sevens
                }
                
                // Manejo de la continuidad del bucle
                if (elevenCount == 1 && sevenCount == 1) {
                    break;
                } else if (sevenCount >= 2) {
                    break;
                } else if (pairCount == 10) {
                    break;
                } else if (elevenCount == 1 && sevenCount == 0) {
                    break;
                } else {
                    pairCount++; // Si nada sucede seguir generando parejas
                }

            } 

            // Seguir bucle experimento o parar con MATCH
            if (elevenCount == 1 && sevenCount == 1) { // Seven-Eleven [MATCH]
                matchFound = true;
                console.print("[Seven-eleven MATCH]");
                console.print("\n\n\nSEVEN-ELEVEN Matching experiment ends because:  ");
                console.setForegroundColor(Color.GREEN);
                console.print("a MATCH has occured");
            } else if (sevenCount >= 2) { // Seven excess
                console.print("[Seven Excess]");
                experiment++;
                console.println();
            } else if (elevenCount == 1 && sevenCount == 0) { // Orphan eleven
                console.print("[Orphan Eleven]");
                experiment++;
                console.println();
            } else if (pairCount == 10) { // 10 pair
                console.print("[10 pairs]");
                experiment++;
                console.println();
            }

        }
    }




    public static void ShowPair(int one, int two, JConsole console) {
        if (one + two == 7) console.setForegroundColor(Color.CYAN);
        else if (one + two == 11) console.setForegroundColor(Color.MAGENTA);
        console.print("(" + one + " " + two + ") ");
        console.resetColor();
    }

}

//do not modify this code.
class FakeRandom extends Random {
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

    public FakeRandom(JConsole console) {
        int seqNum;
        console.print("Enter sequence>");
        console.setForegroundColor(Color.GREEN);
        seqNum = console.readInt();
        console.resetColor();
        console.clear();

        sequence = seqs[seqNum - 1];
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

} // FakeRandom ends here
