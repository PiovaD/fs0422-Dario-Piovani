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

    ricarica(unaRicarica: number): void {
        this.carica += unaRicarica;
    }
    
    chiamata(minutiDurata: number): void {

        if (this.carica > 0) {

            this.numeroChiamate++

            let costoTot: number = this.tariffe.costoChiamata * minutiDurata

            if ((this.carica - costoTot) >= 0) {

                this.carica -= costoTot;

            } else {

                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.tariffe.costoChiamata).toFixed(2)} minuto `)

                this.carica = 0;
            }

        } else {
            console.log('Credito insufficente')
        }

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