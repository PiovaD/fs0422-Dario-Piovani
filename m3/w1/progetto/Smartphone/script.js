"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
const sim = __importStar(require("./Modules/UserClass"));
let first = new sim.FirstUser(10);
let second = new sim.SecondUser(0);
let third = new sim.ThirdUser(5, 5, 0.5);
//primo utente
console.log('Primo utente');
first.ricarica(10);
console.log(`Credito: ${first.numero404}`);
first.chiamata(8);
first.chiamata(20);
first.chiamata(10);
first.chiamata(7);
first.chiamata(2);
console.log(`Credito: ${first.numero404}`);
console.log(`Numero Chiamate: ${first.numeroChiamate}`);
first.azzeraChiamate();
console.log(`Numero Chiamate: ${first.numeroChiamate}`);
//secondo utente
console.log('Secondo utente');
console.log(`Credito: ${second.numero404}`);
second.chiamata(8);
second.chiamata(20);
second.ricarica(5);
second.chiamata(7);
second.chiamata(2);
console.log(`Credito: ${second.numero404}`);
second.chiamata(20);
console.log(`Credito: ${second.numero404}`);
console.log(`Numero Chiamate: ${second.numeroChiamate}`);
//terzo utente
console.log('Terzo utente');
console.log(`Credito: ${third.numero404}`);
console.log(`Numero chiamate: ${third.numeroChiamate}`);
third.azzeraChiamate();
third.ricarica(15);
third.chiamata(200);
console.log(`Credito: ${third.numero404}`);
console.log(`Numero chiamate: ${third.numeroChiamate}`);
third.azzeraChiamate();
