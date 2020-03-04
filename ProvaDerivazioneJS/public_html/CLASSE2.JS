function classe2() {
    var i;
    //i=this.messaggio1;
    //i=this.messaggio2;
    i=this.getMessaggio();
    //i=this.terzoMessaggio();
    alert(i);
}

classe2.prototype = new classe1();
classe2.constructor = classe2;