/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Scanner;

/**
 *
 * @author Principe & Bertoldi
 */
public class MergeSort {

    public static int[] scambia(int V[], int i, int j) {
        int[] appoggio = V;
        int temp = appoggio[i];
        appoggio[i] = appoggio[j];
        appoggio[j] = temp;
        return appoggio;
    }

    public static int[] inserisci(int V[], int n) {
        Scanner in = new Scanner(System.in);
        int[] appoggio = V;
        for (int i = 0; i < n; i++) {
            System.out.print("V[" + (i + 1) + "]=");
            appoggio[i] = in.nextInt();
        }
        return appoggio;
    }

    public static void stampa(int V[]) {
        for (int i = 0; i < V.length-1; i++) {
            System.out.println("V[" + (i + 1) + "]=" + V[i]);
        }
    }

    public static int[] bubblesort(int V[]) {
        int i, pass;
        int[]appoggio = V;
        for (pass = 0; pass < appoggio.length - 1; pass++) {
            for (i = 0; i < appoggio.length - 1; i++) {
                if (appoggio[i] > appoggio[i + 1]) {
                    appoggio = scambia(appoggio, i, i + 1);
                }
            }
        }
        return appoggio;
    }

    public static int[] bubblesort_sentinella(int V[]) {
        int[]appoggio = V;
        int ultimo_scambiato, sup = V.length - 1, i;
        while (sup != 0) {
            ultimo_scambiato = 0;
            for (i = 0; i < sup; i++) {
                if (V[i] > V[i + 1]) {
                    appoggio = scambia(appoggio, i, i + 1);
                    ultimo_scambiato = i;
                }
            }
            sup = ultimo_scambiato;
            //il vettore è ordinato da sup+1 a n-1
        }
        return appoggio;
    }
//trova l'indice del minimo nel sottovettore di V da ini a n-1

    public static int minimo(int V[], int ini) {
        int min = V[ini];
        int pos = -1;
        for (int i = ini; i < V.length-1; i++) {
            if (V[i] < min) {
                min = V[i];
                pos = i;
            }
        }
        return pos;
    }

    public static int[] selectionsort(int V[]) {
        int[]appoggio = V;
        for (int i = 0; i < (V.length - 1); i++) {
            appoggio=scambia(appoggio, i, minimo(V, i));
        }
        return appoggio;
    }

    public static int[] merge(int c[],int d[]) {
        int aux[] = new int[c.length+d.length];
        int i = 0, j = 0, k = 0;

        while ((i < c.length) && (j < d.length)) {

            if (c[i] < d[j]) {
                aux[k] = c[i];
                i++;
                k++;
            } else {
                aux[k] = d[j];
                j++;
                k++;
            }
        }
        while (i < c.length) {
            aux[k] = c[i];
            i++;
            k++;
        }
        while (j < d.length) {
            aux[k] = d[j];
            j++;
            k++;
        }
        return aux;
    }

    public static int[] mergesort(int b[], int inf, int sup) {
        int[] appoggio1, appoggio2;
        int med;
        if (inf < sup) {
            med = (inf + sup) / 2;
            appoggio1 =mergesort(b, inf, med);
            appoggio2 =mergesort(b, med + 1, sup);
            b=merge(appoggio1,appoggio2);
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("dimmi la dimensione dell'array: ");
        int n = input.nextInt();
        int V[] = new int[n+1];
        V=inserisci(V, n);
        V=selectionsort(V);
        stampa(V);
    }

}
