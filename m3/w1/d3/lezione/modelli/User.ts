import { Address } from "./Address";

export class User {

    protected id: number | undefined;
    name: string;
    lastName: string;

    address: Address | undefined;
    billingAddress: Address | undefined;

    constructor(name: string, lastName: string) {
        this.name = name;
        this.lastName = lastName;
    }

    set setAddress(address: Address){
        this.address = address;
    }

    set setBillingAddress(address: Address){
        this.billingAddress = address;
    }
}

let user = new User('Mario', 'Rossi');

////////////////////////////////////////////////////////////////////////
let address = new Address ('Via Roma 1','Roma', 'Italia', 222100)
user.setAddress = address;
