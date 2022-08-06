const apiUsersPro = 'https://62ebe240705264f263e2c5b2.mockapi.io/api/1/users';

class CardPro extends Card {
    constructor(user, target) {
        super(user).div.append(this.cardFooter());

        this.user = user;
        this.target = target;
    }

    cardFooter() {

        let div = document.createElement('div');
        div.className = "row gap-1 card-footer text-center justify-content-center rounded mb-2"

        let buttonUpdate = document.createElement('button');
        buttonUpdate.className = "btn btn-warning col-6"
        buttonUpdate.innerHTML = "Modifica";

        buttonUpdate.addEventListener('click', () => {
            this.updateUser()
        })

        let buttonDelete = document.createElement('button');
        buttonDelete.className = "btn btn-danger col-5"
        buttonDelete.innerHTML = "Elimina";

        buttonDelete.addEventListener('click', () => {
            this.deleteUser()
        })

        div.append(buttonUpdate, buttonDelete);

        return div;
    }

    // update user
    updateUser() {

        this.target.innerHTML = '';

        let updateForm = new Form()

        this.target.append(updateForm.form)

        updateForm.updateForm(this.user);

    }

    //delete user 
    deleteUser() {

        let options = {
            method: 'DELETE',
            headers: {
                "content-type": "application/json"
            }
        }

        fetch(apiUsersPro + '/' + this.user.id, options)
            .then(res => res.json())
            .then(res => {

                Swal.fire({
                    position: 'top',
                    icon: 'success',
                    title: 'Utente Eliminato',
                    text: `L'utente è stato eliminato`,
                    showConfirmButton: false,
                    timer: 3000
                }).then(() => homePage())
            })
    }
}

//CRUD

/*
disabilitato per permettere la visualizzazione del esercizio base
se si vuole abilitare commentare la fetch nel file script.js
*/

//homePage() 

//read user
document.querySelector('#home').addEventListener('click', () => {
    homePage();
})

function homePage() {

    target.innerHTML = '';

    fetch(apiUsersPro)
        .then(res => res.json())
        .then(users => {

            for (let user of users) {

                let card = new CardPro(user, target);

                target.append(card.div);

            }

        })
};

//create user
document.querySelector('#new').addEventListener('click', () => {
    createPage();
})

function createPage() {

    target.innerHTML = '';

    let createForm = new Form()

    target.append(createForm.form)

};
