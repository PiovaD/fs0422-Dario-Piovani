

//singoli elementi di data

//funzione formattazione europea

//mostro  formattazione europea

let clock = document.querySelector("#clock");

//data presa da comando  
/*
variabile con data attuale
seleziono id clock
creo contenitore 
inserisco data dentro al contenitore
lo inserisco al interno di clock
*/

let p = document.createElement("p");

let currentDate = new Date();

p.innerHTML = currentDate;

clock.append(p);

/* dividere il risultato della data ,
prendendo ogni elemento (giorno, mese, anno, ora, minuto, secondo )
*/
let ul = document.createElement("ul")

prendi(currentDate.getDate());
prendi(currentDate.getMonth());
prendi(currentDate.getFullYear());

prendi(currentDate.getHours());
prendi(currentDate.getMinutes());
prendi(currentDate.getSeconds());

function prendi(gg) {
    let li = document.createElement("li");
    li.innerHTML = gg;
    ul.appendChild(li);
}

clock.append(ul);


let h1 = document.createElement('h1');

h1.innerHTML = 'Oggi è il:' + currentDate.getDate() +'/'+ currentDate.toLocaleString('it-IT', {month: 'long'}) +'/'+ currentDate.getFullYear();
currentDate.getMonth('long')
clock.append(h1);


//<h1>innerHTML</h1>