var bloccoRosso = document.getElementById('blocco-rosso');   //html element ricevo un solo elem
console.log(bloccoRosso);
console.log(bloccoRosso.id);
console.log(bloccoRosso.innerHTML);//comprende il contenuto del elem preso in causa

bloccoRosso.style.backgroundColor = 'red';


var div = document.getElementsByTagName('div');
console.log(div);
console.log(div[1].innerHTML);

div[1].style.backgroundColor = 'blue';
div[2].style.backgroundColor = 'blue';
div[3].style.backgroundColor = 'blue';

/*for (var i = 1; i < 4; i++){    
    div[i].style.backgroundColor = 'blue';
}*/ // lo vedremo più avanti

var blocchiGialli = document.getElementsByClassName('blocchi-gialli');

var primoBlocco = document.getElementsByClassName('blocchi-gialli')[0];// un solo elem 

console.log(blocchiGialli);

console.log(primoBlocco);

primoBlocco.style.backgroundColor = 'yellow';
blocchiGialli[1].style.backgroundColor = 'yellow';
blocchiGialli[2].style.backgroundColor = 'yellow';

var bloccoRossoNew = document.querySelector('#blocco-rosso');
//acccetta qualunque query di css, restituisce il primo elem selezionato

var primoBloccoNew = document.querySelector('.blocchi gialli');

var blocchiGiallinew = document.querySelectorAll('.blocchi-gialli');//array

var tutto = document.querySelectorAll('#blocchi-rossi, .blocchi-gialli');

console.log(tutto);

function saluta(){
    alert('CIAO ');
}