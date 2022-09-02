"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ThirdUser = exports.SecondUser = exports.FirstUser = void 0;
class FirstUser {
    constructor(carica, numeroChiamate = 0, costoChiamata = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
        this.costoChiamata = costoChiamata;
    }
    ricarica(unaRicarica) {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    chiamata(minutiDurata) {
        if (this.carica > 0) {
            this.numeroChiamate++;
            let costoTot = this.costoChiamata * minutiDurata;
            if ((this.carica - costoTot) >= 0) {
                this.carica -= costoTot;
            }
            else {
                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `);
                this.carica = 0;
            }
        }
        else {
            console.log('Credito insufficente');
        }
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
    get numero404() {
        return Number(this.carica.toFixed(2));
    }
    get getNumeroChiamate() {
        return this.numeroChiamate;
    }
}
exports.FirstUser = FirstUser;
class SecondUser {
    constructor(carica, numeroChiamate = 0, costoChiamata = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
        this.costoChiamata = costoChiamata;
    }
    ricarica(unaRicarica) {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    chiamata(minutiDurata) {
        if (this.carica > 0) {
            this.numeroChiamate++;
            let costoTot = this.costoChiamata * minutiDurata;
            if ((this.carica - costoTot) >= 0) {
                this.carica -= costoTot;
            }
            else {
                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `);
                this.carica = 0;
            }
        }
        else {
            console.log('Credito insufficente');
        }
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
    get numero404() {
        return Number(this.carica.toFixed(2));
    }
    get getNumeroChiamate() {
        return this.numeroChiamate;
    }
}
exports.SecondUser = SecondUser;
class ThirdUser {
    constructor(carica, numeroChiamate = 0, costoChiamata = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate;
        this.costoChiamata = costoChiamata;
    }
    ricarica(unaRicarica) {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    chiamata(minutiDurata) {
        if (this.carica > 0) {
            this.numeroChiamate++;
            let costoTot = this.costoChiamata * minutiDurata;
            if ((this.carica - costoTot) >= 0) {
                this.carica -= costoTot;
            }
            else {
                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `);
                this.carica = 0;
            }
        }
        else {
            console.log('Credito insufficente');
        }
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
    get numero404() {
        return Number(this.carica.toFixed(2));
    }
    get getNumeroChiamate() {
        return this.numeroChiamate;
    }
}
exports.ThirdUser = ThirdUser;
