export interface ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoChiamata: number;

    ricarica(unaRicarica: number): void
    chiamata(minutiDurata: number): void;
    azzeraChiamate(): void
    get numero404(): number
    get getNumeroChiamate(): number

}