gazi = {};
window.onload = function () {
    create(div);
    cel1.addEventListener("click", callback);
    cel2.addEventListener("click", callback);
    cel3.addEventListener("click", callback);
    cel4.addEventListener("click", callback);
}
function create(div) {
    table = document.createElement("table");
    div.appendChild(table);

    t1 = table.insertRow(0);
    t2 = table.insertRow(1);

    cel1 = t1.insertCell(0);
    //cel1.setAttribute("id", "ciao");
    //cel1.innerHTML = "click me";

    cel2 = t1.insertCell(1);
   // cel2.setAttribute("id", "come");
    //cel2.innerHTML = "click me";

    cel3 = t2.insertCell(0);
//    cel3.setAttribute("id", "va");
//    cel3.innerHTML = "click me";

    cel4 = t2.insertCell(1);
//    cel4.setAttribute("id", "?");
//    cel4.innerHTML = "click me";
}

function callback() {
    if (this.innerHTML == "click me") {
        this.innerHTML = this.id;
    } else {
        this.innerHTML = "click me";
    }
}