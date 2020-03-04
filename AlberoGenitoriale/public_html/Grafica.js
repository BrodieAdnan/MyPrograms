function Grafica(tag) {
    div = tag;
    var i = {"type": "text"};
    var b = {"type": "button", "value": "search"};
    input = createTag("input", i);
    button = createTag("input", b);

    this.play = function (albero) {
        alberoBin = albero;
        button.addEventListener("click", callback);
    }

    function createTag(tipo, json) {
        var a = document.createElement(tipo);
        var x;
        for (x in json) {
            a.setAttribute(x, json[x]);
        }
        div.appendChild(a);
        div.appendChild(document.createElement("div"));
        return a;
    }

    function callback() {
        cercato = input.value;
        if (alberoBin.simmetricVisitation(alberoBin, cercato)) {
            tableManage(alberoBin.getNode());
        } else {
            alert(cercato + " non trovato!");
        }
    }

    function tableManage(nodo) {
        tabella = document.createElement("table");
        for (var r = 0; r < 3; r++) {
            var riga = tabella.insertRow(r);
            for (var c = 0; c < 7; c++) {
                riga.insertCell(c);
            }
        }
        div.appendChild(tabella);
        tabella.rows[0].cells[3].innerHTML = nodo.getI();
        if (nodo.getS() != undefined) {
            tabella.rows[1].cells[1].innerHTML = nodo.getS().getI();
            tabella.rows[1].cells[5].innerHTML = nodo.getD().getI();
        }
        if (nodo.getS().getS() != undefined) {
            tabella.rows[2].cells[0].innerHTML = nodo.getS().getS().getI();
            tabella.rows[2].cells[2].innerHTML = nodo.getS().getD().getI();
            tabella.rows[2].cells[4].innerHTML = nodo.getD().getS().getI();
            tabella.rows[2].cells[6].innerHTML = nodo.getD().getD().getI();
        }
    }
}


