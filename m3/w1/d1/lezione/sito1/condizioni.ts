let day: number = new Date().getDay()
console.log(day);

/* if (day == 0) {
    console.log("Domenica")
} else if (day == 1) {
    console.log("Lunedi")
} */

switch (day) {
    case 0:
        console.log("Domenica")
        break;
    case 1:
        console.log("Lunedi")
        break;
    case 2:
        console.log("Martedi")
        break;
    case 3:
        console.log("Mercoledi")
        break;
    case 4:
        console.log("Giovedi")
        break;
    case 5:
        console.log("Venderdi")
        break;
    case 6:
        console.log("Sabato")
        break;
}