let stringa: string = 'Mario';
let numero: number = 0;
let booleano: boolean = false;
let oggetto: object = {}
let array: any[] = []
let union: (string | number | boolean)
let any: any = {
    nome: 'Mario',
    cognome: 'Rossi'
}

console.log(any.nome);

let sconosciuto: unknown = {
    nome: 'Mario',
    cognome: 'Rossi'
}

//console.log(sconosciuto.nome);

function saluta(): void {
    console.log('ciao')
}

saluta()

function saluta2(): string {
    return 'ciao 2'
}

console.log(saluta2())

function saluta3(saluta: string): string {
    return saluta
}

console.log(saluta3('ciao 3'));

function saluta4(saluta: string | null = null): string | null {
    return saluta
}

console.log(saluta4('ciao 4'), saluta4());


// tipizazzione oggetti

let oggetto2: { nome: string, cognome: string } = {
    nome: 'Mario2',
    cognome: 'Rossi'
}

console.log(oggetto2.nome);

class User {
    nome: string;
    cognome: string;
}

let oggetto3: User = { nome: 'Mario3', cognome: 'Rossi' }

console.log(oggetto3.nome);

let utenti:User[] = [oggetto2, oggetto3]

console.log(utenti, utenti.length);

/*date*/

let oggi:Date = new Date()
console.log(oggi)