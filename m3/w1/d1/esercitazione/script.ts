const G1: HTMLInputElement | null = document.querySelector('#g1');
const G2: HTMLInputElement | null = document.querySelector('#g2');
const BTN: HTMLElement | null = document.querySelector('#btn');
const RAND: HTMLElement | null = document.querySelector('#rand');
const WINNER: HTMLElement | null = document.querySelector('#winner');

function genNum(): number { return Math.floor(Math.random() * 100 + 1); }

function win(diffG1: number, diffG2: number): string {
    if (diffG1 < diffG2) {

        return diffG1 == 0 ? 'IL giocatore 1 ha vinto' :
            'Nessuno dei due ha indovinato ma il giocatore 1 si è avvicinato di più'

    } else if (diffG1 > diffG2) {

        return diffG2 == 0 ? 'Il giocatore 2 ha vinto' :
            'Nessuno dei due ha indovinato ma il giocatore 2 si è avvicinato di più'

    } else {
        return 'Parità'
    }
}

if (BTN) BTN.addEventListener('click', (): void => {

    let random: number = genNum()
    if (RAND) RAND.innerHTML = 'Il numero estratto è: ' + random;

    let giocatore1: number = Number(G1?.value);
    let giocatore2: number = Number(G2?.value)

    let diffG1: number = Math.abs(random - giocatore1);
    let diffG2: number = Math.abs(random - giocatore2);

    if (WINNER) WINNER.innerHTML = (giocatore1 && giocatore2) ? win(diffG1, diffG2) : 'Valori inseriti errati'

})

