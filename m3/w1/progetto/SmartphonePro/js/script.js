import { Smart } from "./Modules/Sim.js";
var target = document.querySelector('#smartphone');
var Home = /** @class */ (function () {
    function Home(target, app, sim) {
        this.target = target;
        this.app = app;
        this.sim = sim;
        this.HTMLConstructorHome();
    }
    Home.prototype.HTMLConstructorHome = function () {
        var div = this.HTMLElementConstructor('div', "container text-center border border-dark border-5 w-50 mt-5 rounded");
        this.display = this.HTMLElementConstructor('section', "col-12 border-bottom border-dark border-3");
        this.display.style.height = "80vh";
        var grid = this.createGrid();
        div.append(this.display, grid);
        this.target.append(div);
    };
    Home.prototype.HTMLElementConstructor = function (type, classi) {
        if (classi === void 0) { classi = ''; }
        var elem = document.createElement(type);
        elem.className = classi;
        return elem;
    };
    Home.prototype.createGrid = function () {
        var _this = this;
        var row = this.HTMLElementConstructor('div', "row m-3 fs-1");
        var _loop_1 = function (i) {
            var btn = document.createElement('button');
            btn.className = "border border-0 bg-transparent col-".concat(12 / this_1.app.length);
            btn.innerText = this_1.app[i];
            btn.addEventListener('click', function () {
                switch (_this.app[i]) {
                    case '✉️':
                        _this.message();
                        break;
                    case '📞':
                        _this.call();
                        break;
                    case '💲':
                        _this.ricarica();
                        break;
                    case '📊':
                        _this.data();
                        break;
                }
            });
            row.append(btn);
        };
        var this_1 = this;
        for (var i = 0; i < this.app.length; i++) {
            _loop_1(i);
        }
        return row;
    };
    Home.prototype.message = function () {
        var _this = this;
        var arr = this.createScreen();
        arr['h2'].innerHTML = 'MESSAGGIO';
        var textArea = document.createElement('textarea');
        textArea.className = 'container';
        textArea.style.height = "40vh";
        arr['btn'].className = "btn btn-outline-secondary";
        arr['btn'].innerText = 'Invia';
        arr['btn'].addEventListener("click", function () {
            arr['h2'].classList.replace('text-success', 'text-info');
            arr['h2'].innerText = _this.sim.messaggio(textArea.value) ? 'MESSAGGIO INVIATO' : 'INVIO NON RIUSCITO';
            _this.display.innerHTML = '';
            _this.display.prepend(arr['h2']);
        });
        this.display.innerHTML = '';
        this.display.append(arr['h2'], textArea, arr['btn']);
    };
    Home.prototype.call = function () {
        var _this = this;
        var arr = this.createScreen();
        arr['h2'].innerHTML = 'CHIAMA';
        arr['h4'].innerHTML = "Il tempo massimo per la chimata in base al credito \u00E8 di: ".concat((this.sim.carica / this.sim.tariffe.costoChiamata).toFixed(2), " min");
        arr['span'].innerText = 'Min';
        arr['span'].id = "inputGroup-sizing-default";
        arr['input'].type = 'number';
        arr['input'].classList.add("form-control");
        arr['input'].setAttribute("aria-describedby", "inputGroup-sizing-default");
        arr['btn'].className = "btn btn-outline-secondary";
        arr['btn'].innerText = 'Chiama';
        arr['btn'].addEventListener("click", function () {
            arr['h2'].classList.replace('text-success', 'text-info');
            var oldCarica = _this.sim.carica;
            arr['h2'].innerText = _this.sim.chiamata(Number(arr['input'].value)) ? 'CHIAMATA EFFETTUATA' : 'CHIAMATA NON RIUSCITA';
            _this.display.innerHTML = '';
            if (oldCarica > 0 && oldCarica / _this.sim.tariffe.costoChiamata < Number(arr['input'].value)) {
                arr['h4'].innerText = "SI \u00C8 INTERROTTA AL MIN: ".concat((oldCarica / _this.sim.tariffe.costoChiamata).toFixed(2), " PER ASSENZA DI CREDITO");
                _this.display.append(arr['h4']);
            }
            _this.display.prepend(arr['h2']);
        });
        arr['div'].append(arr['span'], arr['input'], arr['btn']);
        this.display.innerHTML = '';
        this.display.append(arr['h2'], arr['h4'], arr['div']);
    };
    Home.prototype.ricarica = function () {
        var _this = this;
        var arr = this.createScreen();
        arr['h2'].innerHTML = 'RICARICA';
        arr['h4'].innerHTML = 'Importo della ricarica';
        arr['span'].innerText = '€';
        arr['span'].id = "inputGroup-sizing-default";
        arr['input'].type = 'number';
        arr['input'].classList.add("form-control");
        arr['input'].setAttribute("aria-describedby", "inputGroup-sizing-default");
        arr['btn'].className = "btn btn-outline-secondary";
        arr['btn'].innerText = 'Ricarica';
        arr['btn'].addEventListener("click", function () {
            arr['h2'].classList.replace('text-success', 'text-info');
            arr['h2'].innerText = _this.sim.ricarica(Number(arr['input'].value)) ? 'RICARICA EFFETTUATA' : 'RICARICA FALLITA';
            _this.display.innerHTML = '';
            _this.display.append(arr['h2']);
        });
        arr['div'].append(arr['span'], arr['input'], arr['btn']);
        this.display.innerHTML = '';
        this.display.append(arr['h2'], arr['h4'], arr['div']);
    };
    Home.prototype.createScreen = function () {
        var _a;
        var h2 = this.HTMLElementConstructor('h2', 'pt-5 text-success ');
        var h4 = this.HTMLElementConstructor('h4', 'mt-3 ');
        var div = this.HTMLElementConstructor('div', 'input-group my-3');
        var span = this.HTMLElementConstructor('span', 'input-group-text');
        var input = document.createElement('input');
        var btn = document.createElement('button');
        return _a = {},
            _a['h2'] = h2,
            _a['h4'] = h4,
            _a['div'] = div,
            _a['span'] = span,
            _a['input'] = input,
            _a['btn'] = btn,
            _a;
    };
    Home.prototype.data = function () {
        var _this = this;
        var credito = this.HTMLElementConstructor('h3', 'pt-5');
        credito.innerHTML = "Credito residuo: ".concat(this.sim.numero404, "\u20AC");
        var chiamate = this.HTMLElementConstructor('h3', 'pt-5');
        chiamate.innerHTML = "Numero chiamate: ".concat(this.sim.getNumeroChiamate);
        var btn = document.createElement('button');
        btn.innerHTML = "Azzera chiamate";
        btn.addEventListener('click', function () {
            _this.sim.azzeraChiamate();
            chiamate.innerHTML = "Numero chiamate: ".concat(_this.sim.getNumeroChiamate);
        });
        this.display.innerHTML = '';
        this.display.append(credito, chiamate, btn);
    };
    return Home;
}());
var app = ['✉️', '📞', '💲', '📊'];
var tariffa = {
    costoChiamata: 0.20,
    costoMessaggio: 0.15
};
var sim = new Smart(10, tariffa);
if (target) {
    var myPhone = new Home(target, app, sim);
}
//# sourceMappingURL=script.js.map