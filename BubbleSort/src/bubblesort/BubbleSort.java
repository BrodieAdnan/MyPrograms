package bubblesort;

import java.util.*;

/**
 @Param esegue la scansione a bolla per riordinare un array.
 @author Adnan Gazi Latif.
 */
public class BubbleSort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Dimmi la lunghezza del vettore : ");
		int lung = input.nextInt();
		int[] vettore = new int[lung];
		for (int i = 0; i < lung; i++) {
			vettore[i] = input.nextInt();
		}
		int appoggio;
		for (int k = 0; k < lung; k++) {
			for (int i = lung - 1; i > k; i--) {
				if (vettore[i] < vettore[i - 1]) {
					appoggio = vettore[i - 1];
					vettore[i - 1] = vettore[i];
					vettore[i] = appoggio;
				}
			}
		}
		for (int i = 0; i < lung; i++) {
			System.out.print(vettore[i] + " ");
		}
	}
}
