const apiUtenti = 'http://localhost:3000/utenti'

const TABELLA = document.querySelector('#tabella-utenti')

fetch(apiUtenti)
    .then(res => res.json())
    .then(utenti => {
        for (let utente of utenti) {

            let tr = document.createElement('tr')
            let tdNome = document.createElement('td')
            let tdCognome = document.createElement('td')
            let tdEta = document.createElement('td')

            tdNome.innerHTML = utente.nome
            tdCognome.innerHTML = utente.cognome
            tdEta.innerHTML = utente.eta


            let tdAzioni = document.createElement('td')
            let btnModifica = document.createElement('a')
            let btnElimina = document.createElement('button')
            btnModifica.href = 'modifica.html?id=' + utente.id;

            btnModifica.innerHTML = "modifica"
            btnElimina.innerHTML = "elimina"
            
            btnElimina.addEventListener('click',() => {
                eliminaUtente(utente.id,tr)
            })

            btnModifica.classList.add("btn", 'btn-warning', 'text-dark')
            btnElimina.classList.add("btn", 'btn-danger', 'text-dark')

            tdAzioni.append(btnModifica, btnElimina)


            tr.append(tdNome, tdCognome, tdEta, tdAzioni)

            TABELLA.append(tr);

        }
    })