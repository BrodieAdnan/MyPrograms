/**
 * this._adiacenze - true = adiacenza, false = NON adiacenza
 */
function Grafo(vertici) {
    this._vertici = vertici;
    this._adiacenze = new Array(vertici);

    this._adiacenze.fill([]);
}

Grafo.prototype.addArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");
    assert.preCondizione(this._adiacenze[vert1].indexOf(vert2) === -1, "esiste già un arco!");
    this._adiacenze[vert1].push(vert2);
    this._adiacenze[vert2].push(vert1);
};//addArco

Grafo.prototype.deleteArco = function (vert1, vert2) {
    assert.preCondizione(vert1 < this._vertici && vert2 < this._vertici, "vertici in input non validi!");
    assert.preCondizione(this._adiacenze[vert1].indexOf(vert2) !== -1, "non esiste un arco!");
    this._adiacenze[vert1].splice(this._adiacenze[vert1].indexOf(vert2), 1);
    this._adiacenze[vert2].splice(this._adiacenze[vert2].indexOf(vert1), 1);
};//deleteArco

Grafo.prototype.getVertici = function () {
    return this._vertici;
};

Grafo.prototype.getGrado = function (vert) {
    return this._adiacenze[vert].length;
};

Grafo.prototype.grafoIndotto = function (vertici) {
    var grafo = new Grafo(vertici.length);
    for (var i = 0; i < vertici.length - 1; i++) {
        for (var j = i; j < vertici.length; j++) {
            if (this._adiacenze[vertici[j]].indexOf(vertici[i]) !== -1) grafo.addArco(j, i);
        }
    }
    return grafo;
};

Grafo.prototype.intorno = function (vert) {
    assert.preCondizione(vert < this._vertici, "vertici in input non validi!");
    var adiacenti = [];
    for (var i = 0; i < this._adiacenze[vert].length; i++) {
        adiacenti.push(this._adiacenze[vert][i]);
    }
    return adiacenti;
};

Grafo.prototype.grafoMatrice = function () {
    var ris = new GrafoArray(this._vertici);
    for (var i = 0; i < this._vertici; i++) {
        for (var j = 0; j < this._adiacenze[i].length; j++) {
            ris._adiacenze[i][this._adiacenze[i][j]] = true;
        }
    }
    return ris;
};

function BFSIterator(grafo, verticeIniziale) {
    var coda = [verticeIniziale];
    var visitati = [verticeIniziale];

    this.hasNext = function () {
        return coda.length !== 0;
    };

    this.next = function () {
        if (!this.hasNext()) throw new Error("Nessun elemento rimanente");
        var next = coda.shift();
        var vicini = next.intorno(next);
        for (var i = 0; i < vicini.length; i++) {
            if (vicini.indexOf(vicini[i]) === -1) {
                coda.push(vicini[i]);
                visitati.push(vicini[i]);
            }
        }
        return next;
    }
}

function grafoIterator(grafo) {
    var visitati = [];
    var corrente = {"r": 0, "c": 0};

    this.hasNext = function () {
        return visitati.length !== grafo._vertici;
    };

    this.next = function () {
        if (!this.hasNext()) throw new Error("Nessun elemento rimanente");
        var next;
        do {
            next = grafo._adiacenze[corrente.r][corrente.c];
            if (corrente.c >= grafo._adiacenze[corrente.r].length) {
                corrente.r++;
                corrente.c = 0;
            }
        } while (visitati.indexOf(next) === -1);
        visitati.push(next);
        return next;
    }
}