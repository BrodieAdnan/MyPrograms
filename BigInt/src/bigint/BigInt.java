package bigint;

import java.util.*;

/**
 * @return somma tra stringhe.
 * @param converte stringhe in vttori.
 * @author Gazi Adnan Latif.
 * @date 8/02/2017
 */
public class BigInt {

    static Scanner input = new Scanner(System.in);
    static String a = input.next();
    static String b = input.next();
    static int sizeA = a.length();
    static int sizeB = b.length();
    static int[] A;
    static int[] B;
    static int[] RIS;
    static String ris;
    static int max;
    static int min;

    public static void main(String[] args) { //gestisce solo le funzioni.
        stringMax();
        convertiStringhe();
        riempiStringhe();
        ris();
        for (int i=RIS.length; i > 0; i--) {
            System.out.print(RIS[i-1]);
        }
    }

    public static void stringMax() {
        max = (sizeA > sizeB) ? sizeA : sizeB;
        min = (sizeA < sizeB) ? sizeA : sizeB;
    }

    public static void convertiStringhe() { //conversione in vettore.
        A = new int[max];
        B = new int[max];
    }

    public static void riempiStringhe() { //copia i valori da stringa a vettore.
        for (; sizeA > 0; sizeA--) {
            A[sizeA - 1] = a.charAt(sizeA - 1) - '0';
        }
        for (; sizeB > 0; sizeB--) {
            B[sizeB - 1] = b.charAt(sizeB - 1) - '0';
        }
    }

    public static void ris() { //crea il vettore risultato: +1 per il riporto.
        RIS = new int[max + 1];
    }

    public static void somma() {
        int somma = 0;
        int riporto = 0;
        for (; max > 0; max--) {
            somma = A[max - 1] + B[max - 1] + riporto;
            System.out.println(somma + "somma");
            if (somma >= 10) {
                RIS[max - 1] = somma % 10 + riporto;

            } else {
                RIS[max - 1] = (somma + riporto);
            }
            System.out.println(RIS[max - 1]);
            riporto = somma / 10;
            System.out.println(riporto + "riporto");
        }
    }
}
