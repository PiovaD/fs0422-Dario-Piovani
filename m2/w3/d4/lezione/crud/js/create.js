const apiUtenti = 'http://localhost:3000/utenti';

let button = document.querySelector('#create button');

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
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }

    fetch(apiUtenti, options)
        .then(res => res.json())
        .then(res => {
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: 'Nuvo utente creato',
                text: `L'utente ${res.nome} ${res.cognome} con id: ${res.id} è stato creato`,
                showConfirmButton: false,
                timer: 2000
            })
        })
})