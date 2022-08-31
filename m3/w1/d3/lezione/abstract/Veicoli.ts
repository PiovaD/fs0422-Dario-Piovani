abstract class Veicolo {
    nRuote: number = 1;
    vel: number = 0;
    velMax: number;
    motore: boolean;

    constructor(nRuote: number, velMax: number, motore: boolean) {
        this.nRuote = nRuote;
        this.velMax = velMax;
        this.motore = motore;
    }

    fermaVeicolo(): void {
        this.vel = 0;
    }

    limiteVelocità(vel: number): boolean {
        return vel <= this.velMax
    }

    abstract accelera(vel: number):void
    abstract frena(vel: number):void
}

class Automobile extends Veicolo {

    constructor(velMax: number) {
        super(4, velMax, true);
    }

    
    accelera(vel: number):void {
        this.vel += vel
    }

    frena(vel: number): void {        
        this.vel -= vel
    }

}

let auto = new Automobile(280)

class Bicicletta extends Veicolo {

    constructor(velMax: number) {
        super(2, velMax, false);
    }

    
    accelera():void {
        this.vel ++
    }

    frena(): void {        
        this.vel --
    }

}

let bici = new Bicicletta(250)

bici.accelera()