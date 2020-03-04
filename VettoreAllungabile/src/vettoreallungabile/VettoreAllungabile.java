package vettoreallungabile;

import java.util.Scanner;

/**
 * ****************************************
 * VETTOREALLUNGABILE
 *
 * classe principale
 *
 * @author Gazi Adnan Latif
 * @brief utilizzo vario di un array logico.
 * @date 11/04/2017 ****************************************
 */
public class VettoreAllungabile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayLogico a = new ArrayLogico(1, 1);
        String parola = "";
        int i = 0;
        while (!parola.equals("fine")) {
            System.out.print("Inscerisci quà la parola : ");
            parola = in.next();
            if (i < a.getDim()) {
                a.set(i, parola);
            } else {
                a.add(parola);
            }
            i++;
        }
        //System.out.println(a.getDim());
        //System.out.println(a.getLength());
        for (int j = 0; j < a.getDim()-1; j++) {
            System.out.print(a.get(j) + " ");
        }
    }
}
