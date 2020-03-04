package decorazionequadrato;

import java.util.Scanner;
import zuclib.Tartaruga;

/**
 @author adnan.gazi
 */
public class DecorazioneQuadrato {
	public static void quadrato(Tartaruga t, double lato) {

		for (int i = 0; i < 4; i++) {
			t.avanti(lato);
			t.destra(90);
		}
	}

	public static void quadratiInterni(Tartaruga t, double lato, int numQuadrati) {

		for (int i = 0; i < numQuadrati; i++) {
			quadrato(t, lato);
			lato = lato / 2;
			t.avanti(lato);
			t.destra(45);
			lato = Math.sqrt(Math.pow(lato, 2) * 2);
		}
	}

	public static void main(String[] args) {
		Tartaruga t = new Tartaruga();
		Scanner input = new Scanner (System.in);
		double lato = 0.4;
		System.out.print("Numero quadrati: ");
		int numQuadrati = input.nextInt();
		t.pennaSu();
		t.gotoXY(0.5 - lato / 2, 0.5 - lato / 2);
		t.pennaGiu();
		quadratiInterni(t, lato, numQuadrati);
	}
}
