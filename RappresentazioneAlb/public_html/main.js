gazi = {};
window.onload = function () {
    gazi.x = document.getElementById("div");
    gazi.span = document.createElement("span");
    gazi.x.appendChild(gazi.span);
    gazi.alb=new AlberoBinario("A", new AlberoBinario("B", new AlberoBinario("C", new AlberoBinario("D"), new AlberoBinario("E")), new AlberoBinario("pasquale", new AlberoBinario("annunziata"), new AlberoBinario("F"))), new AlberoBinario("G", new AlberoBinario("H", new AlberoBinario("I"), new AlberoBinario("L")), new AlberoBinario("M", new AlberoBinario("N"), new AlberoBinario("O"))));
    gazi.span.innerHTML = gazi.alb.rappresentazione(gazi.alb);
};
