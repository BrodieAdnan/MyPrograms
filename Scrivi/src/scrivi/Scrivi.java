package scrivi;

import java.util.Scanner;

/**
 * **********************************************************
 * SCRIVI
 *
 * @author Gazi Adnan Latif
 * @brief scrive utilizzando le caratteristiche di una penna.
 * @date 11/04/2017
 * **********************************************************
 */
public class Scrivi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayLogico a = new ArrayLogico(1, 1);
        Penna p = new Penna(16);
        System.out.println("Inserisci quà la tua frase :");
        String s = "";
        String temp = "";
        int i = 0;
        while (!s.equals("fine")) {
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
}
