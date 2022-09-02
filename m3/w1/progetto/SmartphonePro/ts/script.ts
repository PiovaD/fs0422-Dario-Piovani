import { Smart } from "./Modules/Sim.js";
import { IPianoTariffe } from "./Modules/ISmartphone.js"

const target: HTMLElement | null = document.querySelector('#smartphone')

class Home {

    sim: Smart;
    target: HTMLElement;
    app: any[]
    display!: HTMLElement

    constructor(target: HTMLElement, app: any[], sim: Smart) {
        this.target = target
        this.app = app
        this.sim = sim
        this.HTMLConstructorHome()
    }

    HTMLConstructorHome(): void {
        let div: HTMLElement = this.HTMLElementConstructor('div', "container text-center border border-dark border-5 w-50 mt-5 rounded")

        this.display = this.HTMLElementConstructor('section', "col-12 border-bottom border-dark border-3")
        this.display.style.height = "80vh"

        let grid = this.createGrid()

        div.append(this.display, grid)

        this.target.append(div)

    }

    HTMLElementConstructor(type: string, classi: string = ''): HTMLElement {
        let elem: HTMLElement = document.createElement(type)
        elem.className = classi
        return elem
    }

    createGrid(): HTMLElement {

        let row: HTMLElement = this.HTMLElementConstructor('div', "row m-3 fs-1")

        for (let i: number = 0; i < this.app.length; i++) {

            let btn: HTMLButtonElement = document.createElement('button')
            btn.className = `border border-0 bg-transparent col-${12 / this.app.length}`
            btn.innerText = this.app[i];

            btn.addEventListener('click', () => {
                switch (this.app[i]) {
                    case '✉️':
                        this.message();
                        break;
                    case '📞':
                        this.call()
                        break;
                    case '💲':
                        this.ricarica()
                        break;
                    case '📊':
                        this.data()
                        break;
                }
            })

            row.append(btn)

        }

        return row

    }

    message(): void {

        let arr = this.createScreen()

        arr['h2'].innerHTML = 'MESSAGGIO'

        let textArea: HTMLTextAreaElement = document.createElement('textarea')
        textArea.className = 'container'
        textArea.style.height = "40vh"

        arr['btn'].className = "btn btn-outline-secondary"
        arr['btn'].innerText = 'Invia'

        arr['btn'].addEventListener("click", () => {

            arr['h2'].classList.replace('text-success', 'text-info')

            arr['h2'].innerText = this.sim.messaggio(textArea.value) ? 'MESSAGGIO INVIATO' : 'INVIO NON RIUSCITO'

            this.display.innerHTML = '';

            this.display.prepend(arr['h2'])
        })

        this.display.innerHTML = '';
        this.display.append(arr['h2'], textArea, arr['btn'])
    }

    call(): void {

        let arr = this.createScreen()

        arr['h2'].innerHTML = 'CHIAMA'

        arr['h4'].innerHTML = `Il tempo massimo per la chimata in base al credito è di: ${(this.sim.carica / this.sim.tariffe.costoChiamata).toFixed(2)} min`

        arr['span'].innerText = 'Min'
        arr['span'].id = "inputGroup-sizing-default"

        arr['input'].type = 'number'
        arr['input'].classList.add("form-control")
        arr['input'].setAttribute("aria-describedby", "inputGroup-sizing-default")

        arr['btn'].className = "btn btn-outline-secondary"
        arr['btn'].innerText = 'Chiama'

        arr['btn'].addEventListener("click", () => {

            arr['h2'].classList.replace('text-success', 'text-info')

            let oldCarica = this.sim.carica

            arr['h2'].innerText = this.sim.chiamata(Number(arr['input'].value)) ? 'CHIAMATA EFFETTUATA' : 'CHIAMATA NON RIUSCITA'

            this.display.innerHTML = '';

            if (oldCarica > 0 && oldCarica / this.sim.tariffe.costoChiamata < Number(arr['input'].value)) {
                arr['h4'].innerText = `SI È INTERROTTA AL MIN: ${(oldCarica / this.sim.tariffe.costoChiamata).toFixed(2)} PER ASSENZA DI CREDITO`
                this.display.append(arr['h4'])
            }

            this.display.prepend(arr['h2'])
        })

        arr['div'].append(arr['span'], arr['input'], arr['btn'])


        this.display.innerHTML = '';
        this.display.append(arr['h2'], arr['h4'], arr['div'])
    }

    ricarica(): void {

        let arr = this.createScreen()

        arr['h2'].innerHTML = 'RICARICA'

        arr['h4'].innerHTML = 'Importo della ricarica'

        arr['span'].innerText = '€'
        arr['span'].id = "inputGroup-sizing-default"

        arr['input'].type = 'number'
        arr['input'].classList.add("form-control")
        arr['input'].setAttribute("aria-describedby", "inputGroup-sizing-default")

        arr['btn'].className = "btn btn-outline-secondary"
        arr['btn'].innerText = 'Ricarica'

        arr['btn'].addEventListener("click", () => {

            arr['h2'].classList.replace('text-success', 'text-info')

            arr['h2'].innerText = this.sim.ricarica(Number(arr['input'].value)) ? 'RICARICA EFFETTUATA' : 'RICARICA FALLITA';

            this.display.innerHTML = '';
            this.display.append(arr['h2'])
        })

        arr['div'].append(arr['span'], arr['input'], arr['btn'])

        this.display.innerHTML = '';
        this.display.append(arr['h2'], arr['h4'], arr['div'])

    }

    createScreen(): { [key: string]: any } {
        let h2: HTMLElement = this.HTMLElementConstructor('h2', 'pt-5 text-success ')
        let h4: HTMLElement = this.HTMLElementConstructor('h4', 'mt-3 ')
        let div: HTMLElement = this.HTMLElementConstructor('div', 'input-group my-3')
        let span: HTMLElement = this.HTMLElementConstructor('span', 'input-group-text')
        let input: HTMLInputElement = document.createElement('input')
        let btn: HTMLButtonElement = document.createElement('button')

        return {
            ['h2']: h2,
            ['h4']: h4,
            ['div']: div,
            ['span']: span,
            ['input']: input,
            ['btn']: btn
        }

    }

    data(): void {

        let credito: HTMLElement = this.HTMLElementConstructor('h3', 'pt-5')
        credito.innerHTML = `Credito residuo: ${this.sim.numero404}€`

        let chiamate: HTMLElement = this.HTMLElementConstructor('h3', 'pt-5')
        chiamate.innerHTML = `Numero chiamate: ${this.sim.getNumeroChiamate}`

        let btn: HTMLButtonElement = document.createElement('button')
        btn.innerHTML = `Azzera chiamate`

        btn.addEventListener('click', () => {
            this.sim.azzeraChiamate();
            chiamate.innerHTML = `Numero chiamate: ${this.sim.getNumeroChiamate}`
        })

        this.display.innerHTML = '';
        this.display.append(credito, chiamate, btn)
    }

}

let app: string[] = ['✉️', '📞', '💲', '📊']

let tariffa: IPianoTariffe = {
    costoChiamata: 0.20,
    costoMessaggio: 0.15
}

let sim: Smart = new Smart(10, tariffa)

if (target) {
    let myPhone = new Home(target, app, sim)
}