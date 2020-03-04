gazi = {};
window.onload = function () {
	gazi.numeriTombola = [];
	riempiArray(gazi.numeriTombola);
	gazi.numeriTombola = new Random(gazi.numeriTombola);
	gazi.gr = new Grafica();
	gazi.pos = 0;
	setAscoltatore();
	
	function setAscoltatore() {
		var button = document.getElementById("bottone");
		button.addEventListener("click", callBack);
	}
	
	function callBack() {
		gazi.pos++;
		estraiNumero();
		if (gazi.pos >= 90) {
			gazi.document.location.reload();
		}
	}

	function estraiNumero() {
		gazi.gr.mostraNumero(gazi.numeriTombola[gazi.pos - 1]);
	}

	function riempiArray(n) {
		for (var i = 0; i < 90; i++) {
			n[i] = i;
		}
	}
}
