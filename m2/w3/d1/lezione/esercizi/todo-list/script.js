let bottone = document.querySelector('#salva');
bottone.addEventListener('click', function () {

    let testo = document.querySelector('#testo');

    let div = document.createElement('div');

    div.classList.add('alert', 'alert-success');

    div.innerHTML = testo.value;

    testo.value = '';

    div.addEventListener('click', function () {
        div.remove();
    })

    console.log(div);

    document.querySelector('#lista').append(div);
});