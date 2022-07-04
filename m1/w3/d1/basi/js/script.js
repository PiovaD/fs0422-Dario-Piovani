
document.write('Hello world!');

document.getElementById('test').innerHTML = 'Ciao';
document.getElementById('test').style.backgroundColor = 'red';


console.log('Hello world!');
console.log(3 + 4)

//commenti come su c++

//variabli

var nomeVariable = 'ciao';

var a = 4;
var b = 5;

console.log(a, b);
console.log(a + b);

console.log(c);
var c = 5;
console.log(c);

a = 1;
console.log(a);

/*
Tipi di dato

number
string
boolean
array
object

*/

var x = 5; //number
var y = '5' //stringa

var bo = true;


var nome = 'Mario';
var saluto = 'Ciao';

console.log(saluto + ' ' + nome + ', sono già le ' + y);

var h = [1, 2, 3, 4, 5, 666, 'ciao'];
console.log(h[5]);

var o = {
    nome: "Edoardo",
    eta: 27,
    sposato: false
};

console.log(o.nome, o.sposato)
console.table(o);

//conversioni e operazioni
//operatori matematici


a = 2;
b = 2;

console.log(a + b);

c = '3';
console.log(b + c); // var numerica conversione in stringa
console.log(b * c); // var num convs stirng

var e = '2a';
console.log(a * e); // (NaN non a number)

//casting forzo trsformazione

console.log(typeof c);
console.log(typeof a);
console.log(typeof e);


console.log(typeof String(a));

//funzioni

function saluta(){
    console.log('Ciao')
    console.log(e)
    var xy = 'prova'// nasce e muore qui
}

saluta();