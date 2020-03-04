package gestionearraylogico;

import java.util.Scanner;

/**
 * ***********************************
 * GESTIONEARRAYLOGICO
 *
 * classe principale
 *
 * @author Gazi Adnan Latif
 * @brief lavoro sulla classe Insieme.
 * @date 26/04/2017
 * ***********************************
 */
public class GestioneArrayLogico {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Insieme a = new Insieme(); //insieme 'a'.
        Insieme b = new Insieme(); //insieme 'b'.
        String s = "";
        System.out.println("Scrivi 'fine' per concludere l'insieme :");
        System.out.println("Caricamento primo insieme...(inserisci numeri)");
        a = riempiInsieme(a, s);
        System.out.println("Caricamento secondo insieme...(inserisci numeri)");
        b = riempiInsieme(b, s);
        System.out.println("Il primo insieme contiene :");
        out(a); //output nel formato richiesto.
        System.out.println("Il secondo insieme contiene :");
        out(b);
        if (a.equals(b)) {
            System.out.println("I due insiemi contengono gli stessi elementi.");
        } else {
            System.out.println("I due insiemi non contengono gli stessi elementi.");
        }
		intersezione(a, b);
    }

    public static Insieme riempiInsieme(Insieme i, String s) { //riempie l'insieme passato fino a quando è richiesto dall'utente.
        while (!s.equals("fine")) {
            System.out.print("->");
            s = in.next();
            if (!s.equals("fine")) {
                int n = Integer.parseInt(s);
                i.aggiungi(n);
            }
        }
        return i;
    }

    public static void out(Insieme i) {
        System.out.println(i.toString());
    }
	
	public static void intersezione(Insieme a, Insieme b){
		Insieme c=new Insieme();
		System.out.println("Questa è l'intersezione tra i due insiemi...");
		out(c.intersezione(a, b));
	}
}
