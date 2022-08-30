class User {

    protected id: number | undefined;
    private name!: string;
    private cognome: string;
    public role: string = 'user';

    constructor(name: string, cognome: string) {
        this.name = name
        this.cognome = cognome;
    }

    public saluto() {
        console.log(`Ciao mi chiamo ${this.name} ${this.cognome}`)
    }

    get GetNome(): string {
        return this.name;
    }

    set setId(id: number) {
        this.id = id;
    }
}

let user = new User('Mario', 'Rossi')

console.log(user.role)

user.saluto();

console.log(user.GetNome)

user.setId = 5

class Admin extends User {
    public role: string = 'admin'

    private fullAccess: boolean;

    constructor(name: string, cognome: string, fullAccess: boolean) {
        super(name, cognome);
        this.fullAccess = fullAccess;
    }
}

let admin = new Admin('Maria', 'Bianchi',true);

console.log(admin.role)
console.log(admin.GetNome)

admin.saluto();