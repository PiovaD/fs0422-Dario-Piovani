import * as sim from './Modules/UserClass'

let first = new sim.FirstUser(10)
let second = new sim.SecondUser(0)
let third = new sim.ThirdUser(5, 5, 0.5)

//primo utente
console.log('Primo utente')

first.ricarica(10)

console.log(`Credito: ${first.numero404}`)

first.chiamata(8)
first.chiamata(20)
first.chiamata(10)
first.chiamata(7)
first.chiamata(2)

console.log(`Credito: ${first.numero404}`)
console.log(`Numero Chiamate: ${first.numeroChiamate}`)

first.azzeraChiamate()

console.log(`Numero Chiamate: ${first.numeroChiamate}`)

 //secondo utente

console.log('Secondo utente')
console.log(`Credito: ${second.numero404}`)

second.chiamata(8)
second.chiamata(20)

second.ricarica(5)

second.chiamata(7)
second.chiamata(2)

console.log(`Credito: ${second.numero404}`)

second.chiamata(20)

console.log(`Credito: ${second.numero404}`)
console.log(`Numero Chiamate: ${second.numeroChiamate}`)


//terzo utente

console.log('Terzo utente')
console.log(`Credito: ${third.numero404}`)


console.log(`Numero chiamate: ${third.numeroChiamate}`)

third.azzeraChiamate()

third.ricarica(15)

third.chiamata(200)

console.log(`Credito: ${third.numero404}`)
console.log(`Numero chiamate: ${third.numeroChiamate}`)

third.azzeraChiamate()
