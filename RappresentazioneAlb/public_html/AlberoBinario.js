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
    
    this.rappresentazione=function(alb){
        if (alb.isEmpty()) {
            return " ";
        } else {
            return alb.getInfo()+" ( "+this.rappresentazione(alb.getSx())+" ,  "+this.rappresentazione(alb.getDx())+" ) ";
        }
    }
}
;