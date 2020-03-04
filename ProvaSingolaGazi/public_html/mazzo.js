function Mazzo(semi, valori) {
    var carte = [];
    this.creaCarte = function (percorso, mazzo) {
        semi.forEach(function (s) { // Initializza l'array
            valori.forEach(function (v) {
                carte.push(new Carta(s, v, percorso + s.getNome()[0] + ("0" + (v.getValore()+1)).substring(String(v.getValore()+1).length - 1) + ".jpg", Mazzo.COPERTA, mazzo));
            });
        });
    }

    this.getCarte = function () {
        return carte.length;
    }

    this.getCarta = function (i) {
        return carte.pop();
    }

    this.carta = function (seme,valore) {
        var carta=new Carta(seme,valore,"","");
        return carte.find(function(c){return c.equals(carta)});
    }
}

Mazzo.COPERTA = "immagini/coperta.jpg";
Mazzo.SEMEPROVA = new Enum(["cuori", "quadri"],"Seme");
Mazzo.VALOREPROVA = new Enum(["A", "2", "3"],"Valore");
