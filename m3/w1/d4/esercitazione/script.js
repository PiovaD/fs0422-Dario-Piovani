"use strict";
const API = 'http://localhost:3000/abbigliamento';
class Capi {
    constructor(capo) {
        this.id = capo.id;
        this.codprod = capo.codprod;
        this.collezione = capo.collezione;
        this.capo = capo.capo;
        this.modello = capo.modello;
        this.quantita = capo.quantita;
        this.colore = capo.colore;
        this.prezzoivaesclusa = capo.prezzoivaesclusa;
        this.prezzoivainclusa = capo.prezzoivainclusa;
        this.disponibile = capo.disponibile;
        this.saldo = capo.saldo;
    }
    get getsaldocapo() {
        return (this.prezzoivainclusa / 100) * this.saldo;
    }
    get getacquistocapo() {
        return this.prezzoivainclusa - this.getsaldocapo;
    }
}
fetch(API)
    .then(res => res.json())
    .then(arrCapi => {
    var _a;
    let negozio = [];
    for (let capo of arrCapi) {
        negozio.push(new Capi(capo));
    }
    console.log(negozio);
    console.log((_a = negozio.find(p => p.capo == 't-shirt')) === null || _a === void 0 ? void 0 : _a.getacquistocapo);
    negozio.filter(capo => capo.collezione == 'primavera').forEach(element => console.log(element.getacquistocapo));
});
