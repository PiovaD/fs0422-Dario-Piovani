
const BUDGET = 10000;

let rand = (max) => Math.floor(Math.random() * max) + 1;

function sottrazione() {
    let spese = 0

    while (spese <= BUDGET) {
        spese += rand(BUDGET-spese);
        console.log(BUDGET-spese);

        if (spese >= BUDGET / 2 && BUDGET - spese > BUDGET / 100 * 5) {
            console.log(BUDGET - spese + ', Meno della metà del budget');

        }else if (BUDGET- spese <= BUDGET / 100 * 5) {
           return console.log(BUDGET - spese + ', Manaca meno del 5%');

        }


    }
}

sottrazione();