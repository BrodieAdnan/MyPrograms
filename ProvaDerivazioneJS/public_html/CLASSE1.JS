window.onload = function () {
    new classe1();
    new classe2();
}

function classe1() {
    this.messaggio1 = "messaggioUno";
    this.messaggio2 = "messaggioDue";
}
classe1.prototype.getMessaggio = function () {
    return "ciao" + 1 + 2;//messaggioUno messaggioDue
}

classe1.prototype.terzoMessaggio = function () {
    return "messaggioTre";
}

