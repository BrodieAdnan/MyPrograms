/**
 * this._adiacenze - true = adiacenza, false = NON adiacenza
 */
function Grafo(vertici) {
    this._vertici = vertici;
    this._adiacenze = new Array(vertici);

    for (var curr in this._adiacenze) {
        this._adiacenze[curr] = new Array(vertici);
        this._adiacenze[curr].fill(false);
    }
}

Grafo.prototype.addArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");
    this._adiacenze[vert1][vert2] = true;
};//addArco

Grafo.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");
    this._adiacenze[vert1][vert2] = false;
};//deleteArco

Grafo.prototype.getVertici = function () {
    return this._vertici;
};

Grafo.prototype.getGrado = function (vert) {
    var cont = 0;
    for (var i = 0; i < this._adiacenze[vert].length; i++) {
        if (this._adiacenze[vert][i]) cont++;
    }
    return cont;
};

Grafo.prototype.grafoIndotto = function (vertici) {
    // aggiungi controllo
    var grafo = new Grafo(vertici.length);
    for (var i = 0; i < vertici.length - 1; i++) {
        for (var j = i; j < vertici.length; j++) {
            if (this._adiacenze[vertici[j]][vertici[i]]) grafo.addArco(j, i);
        }
    }
    return grafo;
};

Grafo.prototype.intorno = function (vert) {
    assert.preCondizione(vert < this._vertici, "vertici in input non validi!");
    var adiacenti = [];
    for (var i = 0; i < this._adiacenze.length; i++) {
        if (this._adiacenze[vert][i]) adiacenti.push(i);
    }
    return adiacenti;
};