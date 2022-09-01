let nome:string = 'Mario'
let cognome:string = 'Rossi'

let nomeCognome = 'ciao mi chiamo' + nome + ' ' + cognome + '<br>'
let nomeCognome2 = `Ciao mi chiamo ${nome} ${cognome} <br>`

let htmlStr:string = "<div class=\""+ nome +"\">"
let htmlStr2:string = '<div class="' +nome+ '">'
let htmlStr3:string = `<div class="${nome}">`
 