class todoElemet{
    constructor(testo,data){
        this.testo = testo;
        this.data = data;
    }
}

let button = document.querySelector('#salva');

let coseDaFare = localStorage.getItem('lista') ? JSON.parse(localStorage.getItem('lista')) : [];

for(let cosa of coseDaFare){

    createToDo(cosa.testo, cosa.data)

}

button.addEventListener('click', function (e){

    e.preventDefault();

    let testo = document.querySelector('#testo');    
    let date = document.querySelector('#date');

    let list = document.querySelector('#list');

    let todo = new todoElemet(testo.value, date.value)

    createToDo(todo.testo, todo.data)

    coseDaFare.push(todo);

    localStorage.setItem('lista',JSON.stringify(coseDaFare))

    console.log(todo);

    document.querySelector('#form').reset()
    

})

function createToDo(testo, date){
    let div = document.createElement('div');
    div.innerHTML = testo;
    div.classList.add('alert', 'alert-success');
    div.addEventListener('click', () => div.remove())

    let dateDiv = document.createElement('div');
    dateDiv.innerText = date;

    div.append(dateDiv);
    list.append(div);

}