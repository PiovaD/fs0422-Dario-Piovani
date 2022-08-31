var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Laborer = /** @class */ (function () {
    function Laborer(codredd, redditoannuolordo) {
        this.codredd = codredd;
        this.redditoannuolordo = redditoannuolordo;
    }
    Laborer.prototype.getUtileTasse = function () {
        return this.getTasseInps() + this.getTasseIrpef();
    };
    Laborer.prototype.getTasseInps = function () {
        this.tasseinps = ((this.redditoannuolordo / 100) * 22);
        return this.tasseinps;
    };
    Laborer.prototype.getTasseIrpef = function () {
        var tax;
        switch (true) {
            case (this.redditoannuolordo >= 0 && this.redditoannuolordo <= 15000):
                tax = 23;
                break;
            case (this.redditoannuolordo >= 15001 && this.redditoannuolordo <= 28000):
                tax = 27;
                break;
            case (this.redditoannuolordo >= 28001 && this.redditoannuolordo <= 55000):
                tax = 38;
                break;
            case (this.redditoannuolordo >= 55001 && this.redditoannuolordo <= 75000):
                tax = 41;
                break;
            case (this.redditoannuolordo > 75000):
                tax = 43;
                break;
        }
        this.tasseirpef = (this.redditoannuolordo / 100) * tax;
        return this.tasseirpef;
    };
    Laborer.prototype.getRedditoAnnuoNetto = function () {
        var redditoAnnuoNetto = this.redditoannuolordo - this.getUtileTasse();
        return redditoAnnuoNetto;
    };
    return Laborer;
}());
var Artigiano = /** @class */ (function (_super) {
    __extends(Artigiano, _super);
    function Artigiano(codredd, redditoannuolordo) {
        var _this = _super.call(this, codredd, redditoannuolordo) || this;
        _this.getRedditoAnnuoNetto();
        return _this;
    }
    return Artigiano;
}(Laborer));
var x = new Artigiano(0, 25000);
console.log(x, x.getRedditoAnnuoNetto());
