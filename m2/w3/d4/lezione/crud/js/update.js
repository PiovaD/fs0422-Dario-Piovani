const apiUtenti = 'http://localhost:3000/utenti';

let params = new URLSearchParams(location.search);

if (!params.has('id')) {
    location.href = 'index.html';
}

let userId = params.get('id');

fetch(apiUtenti + '/' + userId)
    .then(res => res.json())
    .then(utente => {
        let nome = document.querySelector('#nome')
        let cognome = document.querySelector('#cognome')
        let eta = document.querySelector('#eta')

        nome.value = utente.nome
        cognome.value = utente.cognome
        eta.value = utente.eta


    })

let button = document.querySelector('#update button');

button.addEventListener('click', function (e) {
    e.preventDefault();

    let nome = document.querySelector('#nome')
    let cognome = document.querySelector('#cognome')
    let eta = document.querySelector('#eta')

    let user = {

        nome: nome.value,
        cognome: cognome.value,
        eta: eta.value
    }
    nome.value = ''
    cognome.value = ''
    eta.value = ''


    let options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }

    fetch(apiUtenti + '/' + userId, options)
        .then(res => res.json())
        .then(res => {
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: 'Utente modificato',
                text: `L'utente ${res.nome} ${res.cognome} con id: ${res.id} è stato modificato`,
                showConfirmButton: false,
                timer: 2000
            }).then(res => {
                location.href = 'index.html';
            })
        })
})