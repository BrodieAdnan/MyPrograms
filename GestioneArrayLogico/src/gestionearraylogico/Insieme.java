package gestionearraylogico;

/**
 * ***************************************
 INSIEME

 @author Gazi Adnan Latif
 @brief gestisce un insieme di elementi.
 @date 26/04/2017
 * ***************************************
 */
public class Insieme {

	private ArrayLogico valori;
	private ArrayLogico c;

	public Insieme() {
		valori = new ArrayLogico(0, 1);
		c = new ArrayLogico(0, 1);

	}

	public boolean aggiungi(int elem) {
		int i = 0;
		///scorre tutto l'array solo se l'elemento non è già presente.
		for (; i < valori.getDim() && valori.get(i) != elem; i++);
		///se 'i' è pari alla lunghezza dell'array, l'elemento non è già presente.
		if (i >= valori.getDim()) {
			valori.add(elem);
			return true;
		} else {
			return false;
		}
	}

	public boolean appartieni(int elem) {
		for (int i = 0; i < valori.getDim(); i++) { //controllo tutto l'array.
			if (valori.get(i) == elem) { //metodo finisce non appena viene trovato l'elemento.
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String ris = "{";
		int i = 0;
		for (; i < valori.getDim() - 1; i++) { //ciclo fino al penultimo elemento.
			ris += valori.get(i) + ", ";
		}
		ris += valori.get(i) + "}"; //aggiunge ultimo elemnto.
		return ris;
	}

	public boolean equals(Object o) {
		Insieme temp = (Insieme) o; //Object casted to Insieme.
		boolean presente = temp.valori.getDim() == valori.getDim();
			for (int i = 0; i < valori.getDim() && presente; i++) {
				presente = false;
				for (int j = 0; j < temp.valori.getDim() && !presente ; j++) {
					if (valori.get(i) == temp.valori.get(j)) { //controllo per valore in tutto il secondo array.
						presente = true;
					}
				}
			}
			return presente;
	
	}

	public Insieme intersezione(Insieme a) {
		
		for (int k = 0; k < valori.getDim(); k++) {
			for (int j = 0; j < a.valori.getDim(); j++) {
				if (valori.get(k) == a.valori.get(j)) { //controllo per valore in tutto il secondo array.
					c.add(j);
				}
			}
		}
		return c;
	}
}
