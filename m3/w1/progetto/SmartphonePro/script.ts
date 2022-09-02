import {Smart} from "./Modules/Sim";
import {IPianoTariffe} from "./Modules/ISmartphone"

const target: HTMLElement | null = document.querySelector('#smartphone')

class Home {

    sim: Smart;
    target: HTMLElement;
    app: any[]

    constructor(target: HTMLElement, app: any[], sim: Smart) {
        this.target = target
        this.app = app
        this.sim = sim
        this.HTMLConstructor()
    }

    HTMLConstructor(): void {
        let div: HTMLElement = this.HTMLElementConstructor('div', "container text-center border border-dark border-5 w-50 mt-5")

        let display: HTMLElement = this.HTMLElementConstructor('section', "col-12 border-bottom border-dark border-3")
        display.style.height = "80vh"

        let grid = this.createGrid()

        div.append(display, grid)

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

            switch (this.app[i]) {
                case '✉️': 
                btn.addEventListener('click', () => {})
                break;
                case '📞': 
                btn.addEventListener('click', () => {})
                break;
                case '💲': 
                btn.addEventListener('click', () => {})
                break;
                case '📊': 
                btn.addEventListener('click', () => {})
                break;
            }

            row.append(btn)

        }

        return row

    }

    message():void{}
    call():void{}
    ricarica():void{}
    data():void{}

}

let app: string[] = ['✉️', '📞', '💲', '📊']

let tariffa:IPianoTariffe = {
    costoChiamata: 0.20,
    costoMessaggio: 0.15
}

let sim:Smart = new Smart(10,tariffa)

if (target) {
    let myPhone = new Home(target, app, sim)
}