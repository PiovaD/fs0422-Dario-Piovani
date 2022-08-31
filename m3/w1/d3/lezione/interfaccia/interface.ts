interface IBook {

    nPagine: number;


    getBook(x: number): string;
}

interface IBook2 {

    nPagine: number;


    getBook2(x: number): string;
}

class Book implements IBook, IBook2 {

    nPagine: number;

    getBook(): string {
        return '';
    }

    getBook2(x: number): string {
        throw new Error("Method not implemented.");
    }

}