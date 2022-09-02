export interface ISmartphone {
    carica: number;
    numeroChiamate: number;
    tariffe: IPianoTariffe;
    

    ricarica(unaRicarica: number): boolean
    chiamata(minutiDurata: number): boolean;
    azzeraChiamate(): void
    get numero404(): number
    get getNumeroChiamate(): number

}

export interface IPianoTariffe{    
    costoChiamata:number,
    costoMessaggio:number
}