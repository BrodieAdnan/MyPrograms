function AlberoBinario(info, sx, dx) {
    this.isEmpty = function () {
        return this == AlberoBinario.EMPTY;
    };

    if (sx == undefined) {
        sx = AlberoBinario.EMPTY;
    }

    if (dx == undefined) {
        dx = AlberoBinario.EMPTY;
    }

    this.getInfo = function () {
        if (this.isEmpty()) {
            throw exception;
        }
        return info;
    }

    this.setSx = function (s) {
        if (sx.constructor == AlberoBinario) {
            sx = s;
        } else {
            throw exception;
        }
    }

    this.setDx = function (d) {
        if (dx.constructor == AlberoBinario) {
            dx = d;
        } else {
            throw exception;
        }
    }

    this.getSx = function () {
        return sx;
    }

    this.getDx = function () {
        return dx;
    }

    //altezza//
    function altezza(alb) {
        if (alb.isEmpty()) {
            return -1;
        } else {
            return Math.max(altezza(alb.getSx()), altezza(alb.getDx())) + 1;
        }
    }

    ///metodo per verificare se un albero è pieno e bilanciato//
    function pieno(alb) {
        if (alb.getSx().isEmpty() && alb.getDx().isEmpty()) {//sono entrambi vuoti
            return true;
        } else if (!alb.getSx().isEmpty() && !alb.getDx().isEmpty()) {//sono entrambi pieni
            return (pieno(alb.getSx()) && pieno(alb.getDx()));
        }
        return false;
    }
    ;

    this.bilanciato = function (alb) {
        if (alb.isEmpty()) {
            return false;
        } else if (!alb.getSx().isEmpty() && !alb.getDx().isEmpty()) {
            var HSX = altezza(alb.getSx());
            var HDX = altezza(alb.getDx());
            if (HSX == HDX) {
                return pieno(alb);
            }
        }
        return false;
    };
    //fine metodo//
}
;