var Smart = /** @class */ (function () {
    function Smart(carica, tariffe, numeroChiamate) {
        if (numeroChiamate === void 0) { numeroChiamate = 0; }
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
        this.tariffe = tariffe;
    }
    Smart.prototype.ricarica = function (unaRicarica) {
        this.carica += unaRicarica;
    };
    Smart.prototype.chiamata = function (minutiDurata) {
        if (this.carica > 0) {
            this.numeroChiamate++;
            var costoTot = this.tariffe.costoChiamata * minutiDurata;
            if ((this.carica - costoTot) >= 0) {
                this.carica -= costoTot;
            }
            else {
                console.log("Credito esaurito. Chimata conclusa al ".concat((this.carica / this.tariffe.costoChiamata).toFixed(2), " minuto "));
                this.carica = 0;
            }
        }
        else {
            console.log('Credito insufficente');
        }
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