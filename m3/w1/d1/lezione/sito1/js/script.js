var a = 8;
var b = '5';
var ternario = a < 5 ? 'vero' : 'falso';
console.log(ternario);
var bool = false;
if (!bool) {
    console.log('ciao');
}
var c = b || [];
var arr = ['ciao'];
var arrMisto = [1, 'ciao'];
/* cicli */
for (var i = 0; i <= 10; i++) {
    console.log(i);
}
var day = new Date().getDay();
console.log(day);
/* if (day == 0) {
    console.log("Domenica")
} else if (day == 1) {
    console.log("Lunedi")
} */
switch (day) {
    case 0:
        console.log("Domenica");
        break;
    case 1:
        console.log("Lunedi");
        break;
    case 2:
        console.log("Martedi");
        break;
    case 3:
        console.log("Mercoledi");
        break;
    case 4:
        console.log("Giovedi");
        break;
    case 5:
        console.log("Venderdi");
        break;
    case 6:
        console.log("Sabato");
        break;
}
var stringa = 'Mario';
var numero = 0;
var booleano = false;
var oggetto = {};
var array = [];
var union;
var any = {
    nome: 'Mario',
    cognome: 'Rossi'
};
console.log(any.nome);
var sconosciuto = {
    nome: 'Mario',
    cognome: 'Rossi'
};
//console.log(sconosciuto.nome);
function saluta() {
    console.log('ciao');
}
saluta();
function saluta2() {
    return 'ciao 2';
}
console.log(saluta2());
function saluta3(saluta) {
    return saluta;
}
console.log(saluta3('ciao 3'));
function saluta4(saluta) {
    if (saluta === void 0) { saluta = null; }
    return saluta;
}
console.log(saluta4('ciao 4'), saluta4());
// tipizazzione oggetti
var oggetto2 = {
    nome: 'Mario2',
    cognome: 'Rossi'
};
console.log(oggetto2.nome);
var User = /** @class */ (function () {
    function User() {
    }
    return User;
}());
var oggetto3 = { nome: 'Mario3', cognome: 'Rossi' };
console.log(oggetto3.nome);
var utenti = [oggetto2, oggetto3];
console.log(utenti, utenti.length);
/*date*/
var oggi = new Date();
console.log(oggi);
