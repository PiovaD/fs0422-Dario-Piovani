type StrNum = number | string;

let x: StrNum = '4'
let y: StrNum = 4

function combina(input1: StrNum, input2: StrNum): StrNum {

    if (typeof input1 === 'number' && typeof input2 === 'number') {
        var result: StrNum = input1 + input2
    } else {
        var result: StrNum = String(input1) + String(input2)
    }

    return result
}

let saluto = combina('ciao ', 'come stai?')// ciao come stai?

let somma = combina(5, 2) //10

let combinazione = combina(5, '2') //52

//tipi d'intersezione

type admin = {
    name: string,
    privileges: string[]
}

type employee = {
    StartDate: Date,
    skills: string[]
}

let amministratore: admin = {
    name: 'Rossana',
    privileges: ['access']
}

type promotedEmployee = admin & employee

let superUser: promotedEmployee = {
    name: 'Mario',
    privileges: ['access'], 
    StartDate: new Date(),
    skills: ['HTML', 'css']
}

/* promemoria */

interface superEmployee {
    name: string,
    privileges: string[],
    StartDate: Date,
    skills: string[]
}
