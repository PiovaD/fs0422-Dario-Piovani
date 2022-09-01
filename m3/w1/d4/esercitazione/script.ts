const API = 'http://localhost:3000/abbigliamento'

interface ICapi {

    id: number
    codprod: number
    collezione: string
    capo: string
    modello: string
    quantita: number
    colore: string
    prezzoivaesclusa: number
    prezzoivainclusa: number
    disponibile: string
    saldo: number

}

class Capi implements ICapi {

    id: number
    codprod: number
    collezione: string
    capo: string
    modello: string
    quantita: number
    colore: string
    prezzoivaesclusa: number
    prezzoivainclusa: number
    disponibile: string
    saldo: number

    constructor(capo: ICapi) {

        this.id = capo.id
        this.codprod = capo.codprod
        this.collezione = capo.collezione
        this.capo = capo.capo
        this.modello = capo.modello
        this.quantita = capo.quantita
        this.colore = capo.colore
        this.prezzoivaesclusa = capo.prezzoivaesclusa
        this.prezzoivainclusa = capo.prezzoivainclusa
        this.disponibile = capo.disponibile
        this.saldo = capo.saldo
    }

    get getsaldocapo(): number {
        return (this.prezzoivainclusa / 100) * this.saldo;
    }

    get getacquistocapo(): number {
        return this.prezzoivainclusa - this.getsaldocapo;
    }

}


fetch(API)
    .then(res => res.json())
    .then(arrCapi => {
        let negozio: Capi[] = [];

        for (let capo of arrCapi) {
            negozio.push(new Capi(capo))
        }

        console.log(negozio)

        console.log(negozio.find(p => p.capo == 't-shirt')?.getacquistocapo)

        negozio.filter(capo => capo.collezione == 'primavera').forEach(element => console.log(element.getacquistocapo))
    })