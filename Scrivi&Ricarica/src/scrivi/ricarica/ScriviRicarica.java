package scrivi.ricarica;

/**
 * **********************************************************
 * SCRIVI&RICARICA
 *
 * @author Gazi Adnan Latif
 * @brief scrive utilizzando le caratteristiche di una stilo.
 * @date 11/04/2017
 ************************************************************
 */
import java.util.Scanner;

public class ScriviRicarica {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayLogico a = new ArrayLogico(1, 1);
        Stilografica p = new Stilografica(50);
        System.out.println("Inserisci quà la tua frase :");
        String s = "";
        String temp = "";
        int i = 0;
        while (!s.equals("fine")) {
            if (s.equals("ricarica") || p.scarico()) {
                ricaricamento(p);
            }
            s = in.next();
            if (!p.scarico()) {
                temp = p.scrivi(s);
            }
            System.out.println(p.getInk());

            if (i < a.getDim()) {
                a.set(i, temp);
            } else {
                if (!p.scarico()) {
                    a.add(temp);
                }
            }
            i++;
            temp = null;
        }

        for (int j = 0; j < a.getDim(); j++) {
            System.out.print(a.get(j) + " ");
        }
    }

    public static void ricaricamento(Stilografica p) {
        int q = 0;
        System.out.println("Di quanto?");
        q = in.nextInt();
        if (q > 0 && q < 50) {
            p.ricarica(q);
        } else {
            p.ricarica();
        }
    }
}
