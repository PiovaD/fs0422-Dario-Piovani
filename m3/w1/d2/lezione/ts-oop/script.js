"use strict";
class User {
    constructor(name, cognome) {
        this.role = 'user';
        this.name = name;
        this.cognome = cognome;
    }
    saluto() {
        console.log(`Ciao mi chiamo ${this.name} ${this.cognome}`);
    }
    get GetNome() {
        return this.name;
    }
    set setId(id) {
        this.id = id;
    }
}
let user = new User('Mario', 'Rossi');
console.log(user.role);
user.saluto();
console.log(user.GetNome);
user.setId = 5;
class Admin extends User {
    constructor(name, cognome, fullAccess) {
        super(name, cognome);
        this.role = 'admin';
        this.fullAccess = fullAccess;
    }
}
let admin = new Admin('Maria', 'Bianchi', true);
console.log(admin.role);
console.log(admin.GetNome);
admin.saluto();
//# sourceMappingURL=script.js.map