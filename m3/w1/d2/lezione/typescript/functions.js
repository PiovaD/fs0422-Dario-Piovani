//tipizazzione dati uscita
var _a;
function prova() {
    //col void non permette return di elementi
}
function striga() {
    return '';
}
//tipizazzione dati entarta
function bold(text) {
    return "<b>".concat(text, "</b>");
}
var boldCiao = bold('ciao');
console.log(boldCiao);
/*
function $(selector: string): HTMLElement | null {
    return document.querySelector(selector)
} */
var $ = function (selector) { return document.querySelector(selector); };
(_a = $('.elem')) === null || _a === void 0 ? void 0 : _a.style.color;
