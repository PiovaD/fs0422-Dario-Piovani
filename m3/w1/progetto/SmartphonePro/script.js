import { Smart } from "./Modules/Sim";
var target = document.querySelector('#smartphone');
var Home = /** @class */ (function () {
    function Home(target, app, sim) {
        this.target = target;
        this.app = app;
        this.sim = sim;
        this.HTMLConstructor();
    }
    Home.prototype.HTMLConstructor = function () {
        var div = this.HTMLElementConstructor('div', "container text-center border border-dark border-5 w-50 mt-5");
        var display = this.HTMLElementConstructor('section', "col-12 border-bottom border-dark border-3");
        display.style.height = "80vh";
        var grid = this.createGrid();
        div.append(display, grid);
        this.target.append(div);
    };
    Home.prototype.HTMLElementConstructor = function (type, classi) {
        if (classi === void 0) { classi = ''; }
        var elem = document.createElement(type);
        elem.className = classi;
        return elem;
    };
    Home.prototype.createGrid = function () {
        var row = this.HTMLElementConstructor('div', "row m-3 fs-1");
        for (var i = 0; i < this.app.length; i++) {
            var btn = document.createElement('button');
            btn.className = "border border-0 bg-transparent col-".concat(12 / this.app.length);
            btn.innerText = this.app[i];
            switch (this.app[i]) {
                case '✉️':
                    btn.addEventListener('click', function () { });
                    break;
                case '📞':
                    btn.addEventListener('click', function () { });
                    break;
                case '💲':
                    btn.addEventListener('click', function () { });
                    break;
                case '📊':
                    btn.addEventListener('click', function () { });
                    break;
            }
            row.append(btn);
        }
        return row;
    };
    Home.prototype.message = function () { };
    Home.prototype.call = function () { };
    Home.prototype.ricarica = function () { };
    Home.prototype.data = function () { };
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