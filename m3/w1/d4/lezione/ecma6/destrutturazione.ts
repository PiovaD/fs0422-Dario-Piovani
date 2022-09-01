let lista:number[] = [1,7,3,8]

let [n1,n2,n3,n4] = lista

console.log(n4) //8

let[num1,,,num2] = lista

console.log(num2)

let [nm1,...n] = lista

console.log(n)


//destrutturzione object
let res = {
    gusto:'Margherita',
    tipo: 'Napoletana',
    prezzo: '5'
}

let {gusto,tipo,prezzo} = res