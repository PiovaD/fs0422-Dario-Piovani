"use strict";
class SonAccount {
    constructor() {
        this.balanceInit = 0;
    }
    deposit(versamento) {
        return this.balanceInit += versamento;
    }
    draw(prelievo) {
        if (this.balanceInit - prelievo >= 0) {
            return this.balanceInit -= prelievo;
        }
        else {
            throw new Error(`Hai finito i soldi`);
        }
    }
    stampBalance() { console.log(this.balanceInit); }
}
class MotherAccount extends SonAccount {
    constructor() {
        super(...arguments);
        this.interest = 0;
    }
    set addInterest(interest) {
        this.interest = interest;
    }
    draw(prelievo) {
        prelievo = prelievo + (prelievo / 100 * this.interest);
        if (this.balanceInit - prelievo >= 0) {
            return this.balanceInit -= prelievo;
        }
        else {
            throw new Error(`Hai finito i soldi`);
        }
    }
}
let figlio = new SonAccount();
let madre = new MotherAccount();
figlio.deposit(100);
figlio.draw(10);
figlio.stampBalance();
madre.addInterest = 10;
madre.deposit(200);
madre.draw(50);
madre.stampBalance();
madre.draw(140);
madre.stampBalance();
//# sourceMappingURL=script.js.map