"use strict";
var Color;
(function (Color) {
    Color["red"] = "#970000";
    Color["grey"] = "#ccc";
    Color["black"] = "#000";
})(Color || (Color = {}));
console.log(Color.red);
var Months;
(function (Months) {
    Months[Months["Gennaio"] = 1] = "Gennaio";
    Months[Months["Febbraio"] = 2] = "Febbraio";
    Months[Months["Marzo"] = 3] = "Marzo";
})(Months || (Months = {}));
console.log(Months.Gennaio);
console.log(Months.Febbraio);
//# sourceMappingURL=script.js.map