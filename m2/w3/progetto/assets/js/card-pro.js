const apiUsersPro = 'https://62ebe240705264f263e2c5b2.mockapi.io/api/1/users';

class CardPro extends Card {
    constructor(user) {
        super(user).div.append(this.cardFooter());
    }

    cardFooter() {

        let div = document.createElement('div');
        div.className = "row gap-1 card-footer text-center justify-content-center rounded mb-2"

        let buttonUpdate = document.createElement('button');
        buttonUpdate.className = "btn btn-warning col-6"
        buttonUpdate.innerHTML = "Modifica";

        let buttonDelate = document.createElement('button');
        buttonDelate.className = "btn btn-danger col-5"
        buttonDelate.innerHTML = "Elimina";

        div.append(buttonUpdate, buttonDelate);

        return div;
    }
}

//CRUD

/*
disabilitato per permettere la visualizzazione del esercizio base
se si vuole abilitare commentare la fetch nel file script.js
*/

//homePage() 

//create user 

document.querySelector('#home').addEventListener('click', () => {
    homePage();
})

document.querySelector('#new').addEventListener('click', () => {
    createPage();
})

function homePage() {

    target.innerHTML = '';

    fetch(apiUsersPro)
        .then(res => res.json())
        .then(users => {

            for (let user of users) {

                let card = new CardPro(user);

                target.append(card.div);

            }

        })
};

function createPage() {

    target.innerHTML = '';

    let createForm = new Form()

    target.append(createForm.form)

};