abstract class Negozio{
    maglia:string;
    pantalone:string;
    scarpet:string;

    constructor(maglia:string, pantalone:string, scarpet:string){
        this.maglia = maglia;
        this.pantalone = pantalone;
        this.scarpet = scarpet;
    }

    abstract abbigliamento():any;
}

