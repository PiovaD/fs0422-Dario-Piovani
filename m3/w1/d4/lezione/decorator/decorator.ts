function logger(f:Function){
    console.log('...loading');
    console.log(f);
}

@logger
class Person{
    name:string = 'John';

    constructor(){ 
        console.log('Istanziato')
    }
}

let person = new Person();
console.log(person)

function AggiungiMetodo(f:Function){
    console.log(f)
    f.prototype.mostraNome = function(){
        console.log('Margherita')
    }

    f.prototype.prezzo = 5;
}

@AggiungiMetodo
class Pizza {
    gusto:string = 'Margherita'
}

let margherita:any = new Pizza();

margherita.mostraNome();

console.log(margherita.prezzo)
