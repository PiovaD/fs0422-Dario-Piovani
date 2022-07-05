let l = 5;
var v = 50;
let s = '1'
let b = false;
const C = 500



function somma(num) {
    num++;
    return num;
}

console.log(somma(l));
console.log(somma(v));
console.log(somma(s));
console.log(somma(b));
console.log(somma(C));

let sstring = 'prova' + ' ' + b + ' ' + s + C;
console.log(sstring);


// numero primo
function isPrime() {
    let num = document.querySelector('#richiesta').value;
    let div = 2;

    if (num == 0) {

        return document.querySelector('.result').innerHTML = ("zero è indivisibile");

    } else {
        if (num < 0) {

            return document.querySelector('.result').innerHTML = ("inserimento errato numero negativo");

        } else if (num == 1) {

            return document.querySelector('.result').innerHTML = (num + " è primo")

        } else {

            while (num % div != 0) {
                div++;
            }

            if (num == div) {
                return document.querySelector('.result').innerHTML = (num + " è primo")

            } else {
                return document.querySelector('.result').innerHTML = (num + " non è primo, mcm: " + div);
            }
        }
    }
}

//game

let mat = [['-','-','-'],['-','-','-'],['-','-','-']];
 let cont = 1;
console.log(mat);

function stamp(){
  document.querySelector('.top').innerHTML = (mat[0][0]+ '-' + mat[0][1] + '-' + mat[0][2]);
  document.querySelector('.mid').innerHTML = (mat[1][0]+ '-' + mat[1][1] + '-' + mat[1][2]);
  document.querySelector('.bot').innerHTML = (mat[2][0]+ '-' + mat[2][1] + '-' + mat[2][2]);
}

stamp()

function verifica(){
    let x = document.querySelector('#asse-x').value;
    let y = document.querySelector('#asse-y').value;
    console.log(x,y);
    if((x>0 && x<4)&&(y>0 && y<4)){

        

        cont++
        if (!(cont%2)){
            return document.querySelector('.messaggio').innerHTML = "tocca  a o";
        }else{
            return document.querySelector('.messaggio').innerHTML = "tocca  a x";
        }
    }else{
        return document.querySelector('.messaggio').innerHTML = "inserimento errato riprova";
    }
}