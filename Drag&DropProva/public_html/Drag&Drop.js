window.onload = function () {
    var immagine = document.createElement("img");
    var body = document.getElementById("ciao");
    var cella = document.createElement("div");
    cella.id = "ciao2";
    cella.style.height = "200px";
    cella.style.width = "100px";
    cella.style.border = "1px solid";
    cella.style.background = "white";
    cella.ondrop = "drop(event)";
    cella.ondragover = "allowDrop(event)";
    body.appendChild(cella);
    immagine.src = "b01.jpg";
    immagine.draggable = true;
    immagine.addEventListener("dragstart", drag);
    immagine.id = "drag1";
    body.appendChild(immagine);
    uno();
    due();
}
var ciao;
function uno() {
    ciao = 2;
}
function due() {
    alert(ciao);
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
}