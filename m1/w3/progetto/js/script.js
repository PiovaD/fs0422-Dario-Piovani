let isFirst = true;

reset();

function addElem(elem) {
    let display = document.querySelector('#display');
    let symbol = elem.getAttribute('data-elem');
    const OPERATOR = ['*', '/', '+', '.'];
    const MINUS = ['-'];

    if (isFirst && !OPERATOR.includes(symbol)) {

        display.value = symbol;

    } else if ((MINUS.includes(symbol) || OPERATOR.includes(symbol))
        && (OPERATOR.includes(display.value[display.value.length - 1]) || MINUS.includes(display.value[display.value.length - 1]))) 
        {

        display.value = display.value.replace(display.value[display.value.length - 1], symbol);

    } else {

        display.value += symbol;

    }

    isFirst = false;
}

function calcola() {
    let display = document.querySelector('#display');
    display.value = eval(display.value)
    isFirst = true;
}

function reset() {
    document.querySelector('#display').value = 0;
    isFirst = true;
}

function changeTheme() {
    let buttonNum = document.querySelectorAll('.num');
    let buttonOperator = document.querySelectorAll('.operator');
    let buttonEqual = document.querySelectorAll('.equal');
    let buttonReset = document.querySelectorAll('.reset');
    let calc = document.querySelectorAll('#calcolatrice');
    let container = document.body;
    let moon = document.querySelector('#moon');

    toggleDark(buttonNum);
    toggleDark(buttonOperator);
    toggleDark(buttonEqual);
    toggleDark(buttonReset);
    toggleDark(calc);

    container.classList.toggle('dark')
    moon.classList.toggle('animation')
}

function toggleDark(elem) {
    for (let i = 0; i < elem.length; i++) {
        elem[i].classList.toggle('dark');
    }
}