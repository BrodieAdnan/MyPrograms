gazi = {};
window.onload = function () {
    gazi.tag = document.getElementById("albero");
    gazi.individuo=new AlberoBinario("gazi", new AlberoBinario("gertrude", new AlberoBinario("gaetana", new AlberoBinario("addolorata"), new AlberoBinario("caloggero")), new AlberoBinario("pasquale", new AlberoBinario("annunziata"), new AlberoBinario("salvo"))), new AlberoBinario("ermengildo", new AlberoBinario("concetta", new AlberoBinario("rosa"), new AlberoBinario("salvatore")), new AlberoBinario("ciro", new AlberoBinario("melissa"), new AlberoBinario("felice"))));
    gazi.individuo.getD().getD().setD(new AlberoBinario("felice", new AlberoBinario("novara"), new AlberoBinario("rosario")));
    gazi.grafica = new Grafica(gazi.tag);
    gazi.grafica.play(gazi.individuo);
}


