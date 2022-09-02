import { ISmartphone } from "./ISmartphone";

export class FirstUser implements ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoChiamata: number;

    constructor(carica: number, numeroChiamate: number = 0, costoChiamata: number = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate
        this.costoChiamata = costoChiamata
    }

    ricarica(unaRicarica: number): void {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    
    chiamata(minutiDurata: number): void {

        if (this.carica > 0) {

            this.numeroChiamate++

            let costoTot: number = this.costoChiamata * minutiDurata

            if ((this.carica - costoTot) >= 0) {

                this.carica -= costoTot;

            } else {

                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `)

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

export class SecondUser implements ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoChiamata: number;

    constructor(carica: number, numeroChiamate: number = 0, costoChiamata: number = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate
        this.costoChiamata = costoChiamata
    }

    ricarica(unaRicarica: number): void {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    chiamata(minutiDurata: number): void {

        if (this.carica > 0) {

            this.numeroChiamate++

            let costoTot: number = this.costoChiamata * minutiDurata

            if ((this.carica - costoTot) >= 0) {

                this.carica -= costoTot;

            } else {

                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `)

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

export class ThirdUser implements ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoChiamata: number;

    constructor(carica: number, numeroChiamate: number = 0, costoChiamata: number = 0.20) {
        this.carica = carica;
        this.numeroChiamate = numeroChiamate
        this.costoChiamata = costoChiamata
    }

    ricarica(unaRicarica: number): void {
        unaRicarica >= 0 && (this.carica += unaRicarica);
    }
    chiamata(minutiDurata: number): void {

        if (this.carica > 0) {

            this.numeroChiamate++

            let costoTot: number = this.costoChiamata * minutiDurata

            if ((this.carica - costoTot) >= 0) {

                this.carica -= costoTot;

            } else {

                console.log(`Credito esaurito. Chimata conclusa al ${(this.carica / this.costoChiamata).toFixed(2)} minuto `)

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