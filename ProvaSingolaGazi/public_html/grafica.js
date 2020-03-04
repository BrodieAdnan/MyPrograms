function Grafica() {
	var div = document.getElementById("div");
	var tabella = document.createElement("table");
	for (var rows = 0; rows < 9; rows++) {
		var riga = tabella.insertRow(rows);
		for (var column = 0; column < 10; column++) {
			riga.insertCell(column);
		}
	}
	div.appendChild(tabella);
	r = 0;
	c = 0;

	this.mostraNumero = function (numero) {
		var n = numero;
		
//		mostra le celle in ordine crescente.
//		var r = Math.floor(numero/10);
//		while((numero-10)>=0)numero-=10;
//		var c=numero;
//		tabella.rows[r].cells[c].innerHTML = n + 1;

//		mostra le celle in ordine di estrazione.
		tabella.rows[r].cells[c++].innerHTML = n + 1;
		if (c >= 10) {
			c = 0;
			r++;
		}
	}
}