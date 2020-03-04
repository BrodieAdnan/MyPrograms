gazi = {};
window.onload = function () {
    this.callback = function (d) {
        var i = document.getElementById("in");
        var o = document.getElementById("out");
        if (d == "C") {
            o.innerHTML = i.value * 9 / 5 + 32;
        } else {
            o.innerHTML = (i.value - 32) * 5 / 9;
        }
    }
};