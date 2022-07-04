//var 1 pet_preferito = 'gatto';
//console.log(1 pet_preferito);

/*var pet = 'gatto';
var Pet = 'cane';
var petPreferito = 'criceto';
var PetPreferito = 'coniglio';

var $pet = 'giraffa';
console.log($pet);
var _pet = 'leone';
console.log(_pet);
var _pet2 = 'pantera';
document.write(_pet2);

//var 12 = 'numero';*/

var selezione = document.querySelector('#sfondo');

console.log(selezione);

function changeBackground(color) {
    selezione.style.backgroundColor = color;
    alert('background color: ' + color);
    console.log(color);
    selezione.innerHTML = 'Colore selezionato: ' +  color;
}

function provaClick(n){
    alert('addio n: ' + n);
    if (n < 5){
        return provaClick(++n);
    }
}

/*-------------------------------------------------------------------*/

var grassetto = document.querySelector('.grassetto');
var corsivo = document.querySelector('.corsivo');
var corsivoGrassetto = document.querySelector('.cors-grass');
var caps = document.querySelector('.caps');

grassetto.style.fontWeight = 'bold'; 
corsivo.style.fontStyle = 'italic'; 
corsivoGrassetto.style.fontStyle = 'italic';
corsivoGrassetto.style.fontWeight = 'bold';
caps.style.textTransform = 'uppercase';


/*------------------------------------------------------------------*/

var matrice = [[1,2,3],[4,5,6],[7,8,9]]

console.log(matrice);

matrice[1][1] = 'centro'; 
console.log(matrice);

/*---------------------------------------------------------------- */

function stampLog(user){
    var presentation = user.firstName + ' ' + user.lastName + ' ' + user.age;
    console.log(presentation);
}

var person = {
    firstName: "Mario",
    lastName: "Rossi",
    age: 35
}

stampLog(person);

person.firstName = 'Ajeje';

stampLog(person);

var person2 = {
    firstName: "Giacomo",
    lastName: "Poretti",
    age: 66
}

stampLog(person2);

var differenzaEtà = person2.age - person.age
console.log(differenzaEtà);

var somString= person2.firstName + person.firstName
console.log(somString);

/*---------------------------------------------------------------------------*/

var arr = ['a', 'b', 'c'];
console.log(arr);

arr[3] = 'd';
console.log(arr);

arr = arr + 'e';
console.log(arr);

