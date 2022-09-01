"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
function logger(f) {
    console.log('...loading');
    console.log(f);
}
let Person = class Person {
    constructor() {
        this.name = 'John';
        console.log('Istanziato');
    }
};
Person = __decorate([
    logger
], Person);
let person = new Person();
console.log(person);
function AggiungiMetodo(f) {
    console.log(f);
    f.prototype.mostraNome = function () {
        console.log('Margherita');
    };
    f.prototype.prezzo = 5;
}
let Pizza = class Pizza {
    constructor() {
        this.gusto = 'Margherita';
    }
};
Pizza = __decorate([
    AggiungiMetodo
], Pizza);
let margherita = new Pizza();
margherita.mostraNome();
console.log(margherita.prezzo);
