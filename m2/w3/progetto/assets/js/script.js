const apiUsers = 'assets/json/users.json';
const target = document.querySelector('#target');

class Card {
    constructor(user) {

        this.div = document.createElement("div");
        this.div.className = "card col-12 col-sm-5 col-xl-3 col-xxl-2 bg-light";

        let img = document.createElement("img");
        img.src = user.profileURL;
        img.className = "card-img-top rounded-circle bg-white shadow my-2";

        this.div.append(img, this.cardTitle(user));

        this.div.append(this.cardBody(user));
    }

    cardTitle(user) {

        let div = document.createElement('div');
        div.className = "card-body text-center bg-info text-bg-info rounded"

        let h5 = document.createElement('h5');
        h5.className = "card-title"
        h5.innerText = user.username;

        div.append(h5)
        return div;
    }

    cardBody(user) {

        let title = '';
        switch (user.gender.toLowerCase()) {
            case 'male':
                title = 'Mr'
                break;
            case 'female':
                title = 'Ms'
                break;
            default:
                title = 'Mx'
        }

        return this.createUl(`${title} ${user.firstName} ${user.lastName}`, user.email);
    }

    //creo la lista partendo da un array di stringhe che indicano il testo al interno dei li
    createUl(...arrString) {

        let ul = document.createElement('ul');
        ul.className = "list-group list-group-flush text-center rounded my-2"

        for (let string of arrString) {
            let li = document.createElement('li');
            li.className = "list-group-item bg-secondary text-bg-secondary";
            li.innerHTML = string;
            ul.append(li);
        }

        return ul;
    }
}

fetch(apiUsers)
.then(res => res.json())
.then(users => {
    
    for (let user of users) {
        
        let card = new Card(user);
        
        target.append(card.div);
    }

})


