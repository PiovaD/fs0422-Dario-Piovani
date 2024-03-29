import * as Sim from "./ISmartphone";


export class Smart implements Sim.ISmartphone {
    carica: number;
    numeroChiamate: number;
    tariffe: Sim.IPianoTariffe;

    constructor(carica: number, tariffe: Sim.IPianoTariffe, numeroChiamate: number = 0) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate
        this.tariffe = tariffe
    }

    ricarica(unaRicarica: number): boolean {
        if (unaRicarica >= 0) {
            this.carica += unaRicarica
            return true
        }
        return false
    }

    chiamata(minutiDurata: number): boolean {

        if (this.carica > 0) {

            this.numeroChiamate++

            let costoTot: number = this.tariffe.costoChiamata * minutiDurata

            if ((this.carica - costoTot) >= 0) {

                this.carica -= costoTot;

            } else {

                this.carica = 0;
            }

            return true
        }

        return false


    }

    messaggio(text: string):boolean {

        if(this.carica > this.tariffe.costoMessaggio && text.length > 0) {

            let costo:number = Math.ceil(text.length / 200)

            this.carica -= (costo * this.tariffe.costoMessaggio)

            return true;
        }

        return false
    }

    azzeraChiamate(): void {
        this.numeroChiamate = 0
    }

    get numero404(): number {
        return Number(this.carica.toFixed(2))
    }

    get getNumeroChiamate(): number {
        return this.numeroChiamate
    }

}