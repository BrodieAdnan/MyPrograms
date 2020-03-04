function createGraphics() {
    this.create = function () {
        primo = document.getElementById("uno");
        secondo = document.getElementById("due");
        terzo = document.getElementById("tre");
        quarto = document.getElementById("quattro");
        quinto = document.getElementById("cinque");
        sesto = document.getElementById("sei");
        settimo = document.getElementById("sette");
        ottavo = document.getElementById("otto");
        nono = document.getElementById("nove");
        decimo = document.getElementById("dieci");
        undicesimo = document.getElementById("undici");
        dodicesimo = document.getElementById("dodici");
    }
    this.play = function () {
        primo.addEventListener("click", function () {
            if(primo.innerHTML=="click me"){primo.innerHTML = primo.id;}else{primo.innerHTML = "click me";}
        });
        secondo.addEventListener("click", function () {
            if(secondo.innerHTML==" "){secondo.innerHTML = secondo.id;}else{secondo.innerHTML = " ";}
        });
        terzo.addEventListener("click", function () {
            if(terzo.innerHTML==" "){terzo.innerHTML = terzo.id;}else{terzo.innerHTML = " ";}
        });
        quarto.addEventListener("click", function () {
            if(quarto.innerHTML==" "){quarto.innerHTML = quarto.id;}else{quarto.innerHTML = " ";}
        });
        quinto.addEventListener("click", function () {
            if(quinto.innerHTML==" "){quinto.innerHTML = quinto.id;}else{quinto.innerHTML = " ";}
        });
        sesto.addEventListener("click", function () {
            if(sesto.innerHTML==" "){sesto.innerHTML = sesto.id;}else{sesto.innerHTML = " ";}
        });
        settimo.addEventListener("click", function () {
            if(settimo.innerHTML==" "){settimo.innerHTML = settimo.id;}else{settimo.innerHTML = " ";}
        });
        ottavo.addEventListener("click", function () {
            if(ottavo.innerHTML==" "){ottavo.innerHTML = ottavo.id;}else{ottavo.innerHTML = " ";}
        });
        nono.addEventListener("click", function () {
            if(nono.innerHTML==" "){nono.innerHTML = nono.id;}else{nono.innerHTML = " ";}
        });
        decimo.addEventListener("click", function () {
            if(decimo.innerHTML==" "){decimo.innerHTML = decimo.id;}else{decimo.innerHTML = " ";}
        });
        undicesimo.addEventListener("click", function () {
            if(undicesimo.innerHTML==" "){undicesimo.innerHTML = undicesimo.id;}else{undicesimo.innerHTML = " ";}
        });
        dodicesimo.addEventListener("click", function () {
            if(dodicesimo.innerHTML==" "){dodicesimo.innerHTML = dodicesimo.id;}else{dodicesimo.innerHTML = " ";}
        });
    }
}
