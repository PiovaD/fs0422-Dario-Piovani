


function numero(x: number): number {
    return x;
}

numero(5);

function numeroGenerics<T>(x: T): T {
    return x;
}

numeroGenerics<number>(5)

function sommaOConcatena<T, U>(x: T, y: U): any {

}

sommaOConcatena<string[], number>(['ciao', 'come'], 5)

function prova<T>(x: T): string {
    return typeof x;
}


interface KeyValue<T, U> {
    prop1: T,
    prop2: U
}

let obj: KeyValue<string, number> = {
    prop1: 'prova',
    prop2: 5
}

class CustomArray<T>{
    private arr: T[] = [];

    getItems(): T[] {
        return this.arr
    }

    addItem(item: T): void {
        this.arr.push(item)
    }

    removeItem(item: T): void {
        let i: number = this.arr.indexOf(item)
        i > -1 && this.arr.splice(i, 1);
    }

    removeItemPro(item: T): void {
        this.arr = this.arr.filter((i:T) => i != item)
    }
}

let arr: CustomArray<string> = new CustomArray()

console.log(arr.getItems())
arr.addItem('ciao')
console.log(arr.getItems())


function provaSpread <T>(...caratteri:T[]):T[]{
    return caratteri
}