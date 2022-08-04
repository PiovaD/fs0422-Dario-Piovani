function eliminaUtente(id,el){
    const apiUtenti = 'http://localhost:3000/utenti';
    
    let options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }

    fetch(apiUtenti + '/' + id, options)
    .then(res => res.json())
    .then(res => {

        el.remove();

        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Utente eliminato',
            text: `L'utente è stato eliminato`,
            showConfirmButton: false,
            timer: 2000
        })
    })
}