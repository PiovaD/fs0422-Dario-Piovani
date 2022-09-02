var Smart = /** @class */ (function () {
    function Smart(carica, tariffe, numeroChiamate) {
        if (numeroChiamate === void 0) { numeroChiamate = 0; }
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
        this.tariffe = tariffe;
    }
    Smart.prototype.ricarica = function (unaRicarica) {
        if (unaRicarica >= 0) {
            this.carica += unaRicarica;
            return true;
        }
        return false;
    };
    Smart.prototype.chiamata = function (minutiDurata) {
        if (this.carica > 0) {
            this.numeroChiamate++;
            var costoTot = this.tariffe.costoChiamata * minutiDurata;
            if ((this.carica - costoTot) >= 0) {
                this.carica -= costoTot;
            }
            else {
                this.carica = 0;
            }
            return true;
        }
        return false;
    };
    Smart.prototype.messaggio = function (text) {
        if (this.carica > this.tariffe.costoMessaggio && text.length > 0) {
            var costo = Math.ceil(text.length / 200);
            this.carica -= (costo * this.tariffe.costoMessaggio);
            return true;
        }
        return false;
    };
    Smart.prototype.azzeraChiamate = function () {
        this.numeroChiamate = 0;
    };
    Object.defineProperty(Smart.prototype, "numero404", {
        get: function () {
            return Number(this.carica.toFixed(2));
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Smart.prototype, "getNumeroChiamate", {
        get: function () {
            return this.numeroChiamate;
        },
        enumerable: false,
        configurable: true
    });
    return Smart;
}());
export { Smart };
//# sourceMappingURL=Sim.js.map