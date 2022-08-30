//tipizazzione dati uscita

function prova(): void {
    //col void non permette return di elementi
}

function striga(): string {
    return '';
}

//tipizazzione dati entarta

function bold(text: string): string {
    return `<b>${text}</b>`;
}

let boldCiao: string = bold('ciao');

console.log(boldCiao);

/* 
function $(selector: string): HTMLElement | null {
    return document.querySelector(selector)
} */

let $ = (selector: string): HTMLElement | null => document.querySelector(selector)

$('.elem')?.style.color;
