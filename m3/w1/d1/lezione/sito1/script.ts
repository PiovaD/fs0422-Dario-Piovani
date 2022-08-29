let a: number = 8;
let b: string = '5';


let ternario: string = a < 5 ? 'vero' : 'falso';

console.log(ternario);

let bool: boolean = false;

if (!bool) {
    console.log('ciao')
}

let c: string | [] = b || []

let arr: string[] = ['ciao'];
let arrMisto: any[] = [1, 'ciao'];

/* cicli */

for (let i: number = 0; i <=10; i++) {
    console.log(i);
}
