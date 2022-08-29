var G1 = document.querySelector('#g1');
var G2 = document.querySelector('#g2');
var BTN = document.querySelector('#btn');
var RAND = document.querySelector('#rand');
var WINNER = document.querySelector('#winner');
function genNum() { return Math.floor(Math.random() * 100 + 1); }
function win(diffG1, diffG2) {
    if (diffG1 < diffG2) {
        return diffG1 == 0 ? 'IL giocatore 1 ha vinto' :
            'Nessuno dei due ha indovinato ma il giocatore 1 si è avvicinato di più';
    }
    else if (diffG1 > diffG2) {
        return diffG2 == 0 ? 'Il giocatore 2 ha vinto' :
            'Nessuno dei due ha indovinato ma il giocatore 2 si è avvicinato di più';
    }
    else {
        return 'Parità';
    }
}
if (BTN)
    BTN.addEventListener('click', function () {
        var random = genNum();
        var giocatore1 = Number(G1 === null || G1 === void 0 ? void 0 : G1.value);
        var giocatore2 = Number(G2 === null || G2 === void 0 ? void 0 : G2.value);
        var diffG1 = Math.abs(random - giocatore1);
        var diffG2 = Math.abs(random - giocatore2);
        if (RAND)
            RAND.innerHTML = 'Il numero estratto è: ' + random;
        if (WINNER)
            WINNER.innerHTML = (giocatore1 && giocatore2) ? win(diffG1, diffG2) : 'Valori inseriti errati';
    });
