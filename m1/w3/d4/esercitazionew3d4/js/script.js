//----------------------------------------------------------------

let string = 'Lorem ipsum dolor sit amet, consect'
console.log(string.toUpperCase());
console.log(string.toLowerCase());

let stringaScomposta = string.split(/[ ,-]+/);

console.log(stringaScomposta);

function rand(lunghezza) {
    return Math.floor(Math.random() * lunghezza);
}

console.log(rand(stringaScomposta.length));

let stringaUnita = `${stringaScomposta[rand(stringaScomposta.length)]} ${stringaScomposta[rand(stringaScomposta.length)]}`

console.log(stringaUnita);

//----------------------------------------------------------------

function Persona(n, c, e) {
    this.nome = n,
        this.cognome = c,
        this.eta = e
};

let esempio = new Persona('Mario', 'Rossi', 30);

console.log(esempio);

let coda = [new Persona('Jhon', 'Doe', 70), new Persona('Giacomo', 'Poretti', 66), new Persona('Aldo', 'Baglio', 63), new Persona('Giovanni', 'Storti', 65)]

console.log(coda);
console.log(coda[2]);

console.log(coda.length);

coda.push(esempio);

console.log(coda);

console.log(coda.length);

let shiftElim = coda.shift() //primo
console.log(shiftElim);

console.log(coda);
//stampa(coda, coda.length);

coda.unshift(shiftElim);
console.log(coda);
//stampa(coda, coda.length);

let popElim = coda.pop() //ultimo
console.log(popElim);

console.log(coda);
//stampa(coda, coda.length);

coda.push(popElim);
console.log(coda);
//stampa(coda, coda.length);

let coda2 = coda.splice(2, 2);

console.log(coda, coda2);

coda.splice(2, 0, coda2[coda2.length - 1]);

console.log(coda);

console.log(coda[rand(coda.length)].nome);


/*function stampa(arr) {

    for (let i = 0; i < arr.length; i++) {
        console.log(stampaObj(arr[i]));
    }

}*/

function stampa(arr, i) {
    --i; 
    if (i > 0) stampa(arr, i);

    return console.log(`Elem ${i+1}: ${stampaObj(arr[i])}`);
}

function stampaObj(obj) {
    return `nome: ${obj.nome}, cognome:${obj.cognome}, età:${obj.eta}\n`
}

//stampa(coda);
stampa(coda, coda.length);