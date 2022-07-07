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

function persona(n, c, e) {
    this.nome = n,
        this.cognome = c,
        this.eta = e
};

let esempio = new persona('Mario', 'Rossi', 30);

console.log(esempio);

let coda = [new persona('Jhon', 'Doe', 70), new persona('Giacomo', 'Poretti', 66), new persona('Aldo', 'Baglio', 63), new persona('Giovanni', 'Storti', 65)]

console.log(coda);
console.log(coda[2]);

console.log(coda.length);

coda.push(esempio);

console.log(coda);

console.log(coda.length);

let shiftElim = coda.shift() //primo
console.log(shiftElim);

console.log(coda);

coda.unshift(shiftElim);
console.log(coda);

let popElim = coda.pop() //ultimo
console.log(popElim);

console.log(coda);

coda.push(popElim);
console.log(coda);

let coda2 = coda.splice(2,2); 

console.log(coda,coda2);

coda.splice(2,0,coda2[coda2.length - 1]);

console.log(coda);

