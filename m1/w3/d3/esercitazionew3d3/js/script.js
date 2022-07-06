/*function miaFunzione() {
    console.log('hello world');
}

miaFunzione();
miaFunzione();

function scegliFrutto(mele, arance) {
    const succoFrutta = `Succo  con ${mele} mele e ${arance} arance`;
    return succoFrutta;
}

console.log(scegliFrutto(4, 5));

let succoMela = scegliFrutto(6);
console.log(succoMela);
let succoArance = scegliFrutto(4);
console.log(succoArance);

function calcolaAnni(compleanno) {
    return 2050 - compleanno;
}

alert(calcolaAnni(1991));

const anni = calcolaAnni(1997);
console.log(anni);

const calcolaAnni2 = compleanno => 2040 - compleanno;

let anni2 = calcolaAnni2(1980);
console.log(anni2);

const pensionamento = (compleanno, nome) => {
    const eta = 2037 - compleanno;
    const anniPensione = 65 - eta;
    //return anniPensione;
    return `${nome} va in pensione tra ${anniPensione} anni`;
}

console.log(pensionamento(1975, 'Pinco'));
console.log(pensionamento(1980, 'Pallino'));


function tagliaFette(torta) {
    return torta * 3;
}

function scegliTorta(mela, arancia) {
    const fetteMela = tagliaFette(mela);
    const fetteArancia = tagliaFette(arancia);

    const torta = `Torta con ${fetteMela} fette di mela e ${fetteArancia} fette di arancia.`;
    return torta;
}

console.log(scegliTorta(3, 5));

const calcolaSpesa = function(conto) {
    return conto >= 50 && conto <= 300 ? conto * 0.15 : conto * 0.2;
}

console.log(calcolaSpesa(320));*/

function range() {

    let prima = document.querySelector('#inizio').value;
    let seconda = document.querySelector('#fine').value;
    let risultato = document.querySelector('.data-risultato');

    prima = prima || 0;
    seconda = seconda || 0;

    let difTrue = (a, b) => a - b;

    let difFalse = (a, b) => b - a;

    console.log(typeof (prima * 1), prima, typeof (seconda * 1), seconda);

    return risultato.innerHTML = prima * 1 > seconda * 1 ? difTrue(prima, seconda) : difFalse(prima, seconda);


    /*if (prima > seconda){
        return risultato.innerHTML = prima - seconda;
    }else{
        return risultato.innerHTML = seconda - prima;
    }*/
}


//sistema solare

let rotazione;

let buttonStart = document.querySelector('#start');
let buttonReset = document.querySelector('#reset');

let orbitaTerra = document.querySelector('#orbita-t');
let orbitaLuna = document.querySelector('#orbita-l');

function start() {

    let gradi = 0;
    let scalaRotazione = document.querySelector('#scala').value;
    
let nGiri = document.querySelector('#giri').value;


    buttonStart.classList.toggle('show');
    buttonReset.classList.toggle('show');


    scalaRotazione = scalaRotazione || 1;

    nGiri = nGiri || 1;    

    function ciclo() {

            orbitaTerra.style.transform = 'rotate(' + gradi + 'deg)';
            orbitaLuna.style.transform = 'rotate(' + gradi * 13 + 'deg)';

            if (gradi <= 360 * nGiri) {

                gradi += 0.98;

            } else {

                console.log('fin');

                clearInterval(rotazione);

                buttonStart.classList.toggle('show');
                buttonReset.classList.toggle('show');

            }
    }


    console.log(scalaRotazione, typeof (scalaRotazione))

    rotazione = setInterval(ciclo, (scalaRotazione * 1));
}


function reset(){

    orbitaTerra.style.transform = 'rotate(-1deg)';

    console.log('fin');

    clearInterval(rotazione);
    
    buttonStart.classList.toggle('show');
    buttonReset.classList.toggle('show');

}