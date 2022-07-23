//let arrayAnimali = ['🐱', '🦉', '🐾', '🦁', '🦋', '🐛', '🐝', '🐬', '🦊', '🐨', '🐰', '🐯', '🐱', '🦉', '🐾', '🦁', '🦋', '🐛', '🐝', '🐬', '🦊', '🐨', '🐯', '🐰'];
let arrayAnimali = ['🐱', '🐱', '🦉', '🦉']
//libreria per icone
//https://html-css-js.com/html/character-codes/

let arrayComparison = [];

let click = document.querySelector(".click")
let clickCount = 0;

let display = document.querySelector('.timer')
let printTime = () => `${timer.getMinutes()} min ${zero(timer.getSeconds())} sec`

let refresh = 500;
let timer = new Date()
let myInterval;

timer.setTime(0);

let score = 0;

document.body.onload = startGame();

function shuffle(a) {
    var currentIndex = a.length;
    var temporaryValue, randomIndex;

    while (currentIndex !== 0) {
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;
        temporaryValue = a[currentIndex];
        a[currentIndex] = a[randomIndex];
        a[randomIndex] = temporaryValue;
    }
    return a;
}

function startGame() {

    clickCount = 0;
    score = 0;

    resetTimer()

    myInterval = setInterval(myTimer, refresh);

    let griglia = document.querySelector('#griglia');

    griglia.innerHTML = '';
    arrayComparison = [];

    let shuffled = shuffle(arrayAnimali);

    for (icon of shuffled) {

        let card = document.createElement('div')
        let innerIcon = document.createElement('div')

        innerIcon.addEventListener('click', displayIcon)

        innerIcon.classList.add('icon')
        innerIcon.innerHTML = icon;

        card.append(innerIcon);
        griglia.append(card)
    }

    click.innerHTML = `Click totali: ${clickCount}, Punteggio: ${score}`
}

function displayIcon() {

    clickCount++;

    var icon = document.getElementsByClassName("icon");
    var icons = [...icon];

    let iconsFind = document.querySelectorAll(".find");

    //mette/toglie la classe show
    this.classList.add("show");

    //aggiunge l'oggetto su cui ha cliccato all'array del confronto
    arrayComparison.push(this);

    var len = arrayComparison.length;
    //se nel confronto ci sono due elementi
    if (len === 2) {
        //se sono uguali aggiunge la classe find
        if (arrayComparison[0].innerHTML === arrayComparison[1].innerHTML &&
            clickError(arrayComparison)) {

            arrayComparison[0].classList.add("find", "disabled");
            arrayComparison[1].classList.add("find", "disabled");
            arrayComparison = [];

            updateScore(true);
            completeGame();

        } else {

            //altrimenti (ha sbagliato) aggiunge solo la classe disabled
            icons.forEach(function (item) {
                item.classList.add('disabled');

            });

            // con il timeout rimuove  la classe show per nasconderli
            setTimeout(function () {

                arrayComparison[0].classList.remove("show");
                arrayComparison[1].classList.remove("show");

                icons.forEach(function (item) {
                    item.classList.remove('disabled');

                    for (var i = 0; i < iconsFind.length; i++) {
                        iconsFind[i].classList.add("disabled");
                    }
                });

                arrayComparison = [];

            }, 700);

            updateScore(false);
        }
    }
    click.innerHTML = `Click totali: ${clickCount}, Punteggio: ${score}`
}

// risolve problema al click sulla stessa icona
function clickError(list) {

    if (list[0].offsetTop == list[1].offsetTop && list[0].offsetLeft == list[1].offsetLeft) {

        return false
    }

    return true;

}

//una funzione che viene mostrata alla fine quando sono tutte le risposte esatte

function completeGame() {

    let iconsFind = document.querySelectorAll(".find")

    if (iconsFind.length == arrayAnimali.length) {

        stop()

        let modal = document.querySelector('#modal');
        let span = modal.querySelector('p span');

        modal.classList.add('active');

        span.innerHTML = `${printTime()} e ${clickCount} click, hai fatto: ${score} punti.`;

        switch (true) {
            case (clickCount == iconsFind.length):
                span.innerHTML += "<br>Complimenti al primo colpo"
                break;

            case (score <= iconsFind.length * 400):
                span.innerHTML += "<br>Potevi fare di meglio"
                break;

            case (score < iconsFind.length * 500):
                span.innerHTML += "<br>Bravo"
                break;

        }
    }
}

// una funzione che nasconde la modale alla fine e riavvia il gioco

function playAgain() {

    let modal = document.querySelector('#modal');

    modal.classList.remove('active');

    startGame();
}

// una funzione che calcola il tempo e aggiorna il contenitore sotto

function myTimer() {


    timer.setMilliseconds(timer.getMilliseconds() + refresh)

    display.innerHTML = "Tempo: " + printTime()

}

function zero(num) {
    num < 10 && (num = '0' + num);
    return num
}

function stop() {
    clearInterval(myInterval);
}

function resetTimer() {

    stop()

    timer.setTime(0);

    display.innerHTML = "Tempo: " + printTime()

}

function updateScore(bool) {
    bool ? score += 1000 : score -= 200

    score -= timer / 1000
}
