class Form {

    constructor() {

        this.inputs = [];

        this.OldUser;

        this.formCreation();

    };

    elementCreation(tag, cName, id, type, placeholder, col = 4) {
        let element = document.createElement(tag);
        element.className = cName;
        id && (element.id = id);

        if (tag == 'input') {

            let div = document.createElement('div');
            div.className = 'col-sm-' + col

            let label = document.createElement('label');
            label.className = 'form-label'
            label.innerHTML = placeholder + ':';

            element.placeholder = placeholder;
            element.type = type
            element.required = true;

            div.append(label, element);

            this.inputs.push(element);

            return div;
        }

        return element;
    };

    selectorCreation(labelTitle, col, id, arrOptions, arrValue) {
        if (arrOptions.length == arrValue.length) {
            let div = this.elementCreation('div', 'col-sm-' + col);

            let label = this.elementCreation('label', 'form-label')
            label.innerHTML = labelTitle;

            let select = this.elementCreation('select', 'form-select', id)
            select.required = true;

            for (let i = 0; i < arrOptions.length; i++) {
                let option = document.createElement('option');
                option.value = arrValue[i];
                option.innerHTML = arrOptions[i];

                select.append(option);
            }

            this.inputs.push(select);

            div.append(label, select);
            return div;
        }

        console.log('!!Errore gli array sono di diverse lunghezze')
    }

    formCreation() {
        this.form = this.elementCreation('form', 'needs-validation', 'form');

        let div = this.elementCreation('div', 'container mx-auto row g-3');

        let firstName = this.elementCreation('input', 'form-control', 'firstName', 'text', 'Nome');
        let lastName = this.elementCreation('input', 'form-control', 'lastName', 'text', 'Cognome');
        let username = this.elementCreation('input', 'form-control', 'username', 'text', 'Username');
        let email = this.elementCreation('input', 'form-control', 'email', 'email', 'Email', 6);

        let gender = this.selectorCreation('Genere', 6, 'gender', ['Genere...', 'Uomo', 'Donna', 'Altro'], ['', 'male', 'female', 'other'])

        let button = this.elementCreation('button', 'btn btn-success col-12', 'submit', 'submit');
        button.innerText = 'Salva';

        div.append(firstName, lastName, username, email, gender, button)
        this.form.append(div);

        button.addEventListener('click', (e) => {

            e.preventDefault();

            let isValid = true

            //work around per il submit non valido dovuto al non funzionamento del 
            //preventDefault() in caso di event listener 'submit'
            //così facendo disattivo il controllo della validità degli input

            for (let input of this.inputs) {
                if (!input.value) {
                    input.classList.add('is-invalid');
                    isValid = false
                } else {
                    input.classList.add('is-valid')
                }
            }

            isValid && this.createUser(this.inputs)

        });
    };

    rand(num) {
        return Math.floor(Math.random() * num)
    }

    createUser(allInput) {

        this.User = {
            username: allInput.find(i => i.id == 'username').value,
            firstName: allInput.find(i => i.id == 'firstName').value,
            lastName: allInput.find(i => i.id == 'lastName').value,
            gender: allInput.find(i => i.id == 'gender').value,
            profileURL: this.OldUser ?
                this.OldUser.profileURL :
                `https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/${this.rand(1250)}.jpg`,
            email: allInput.find(i => i.id == 'email').value
        };

        this.saveUser()
    }

    saveUser() {

        let options = {};

        let apiLink = this.OldUser ? apiUsersPro + '/' + this.OldUser.id : apiUsersPro

        if (this.OldUser) {

            options = {
                method: 'PUT',
                body: JSON.stringify(this.User),
                headers: {
                    "content-type": "application/json"
                }
            }

        } else {

            options = {
                method: 'POST',
                body: JSON.stringify(this.User),
                headers: {
                    "content-type": "application/json"
                }
            }
        }

        fetch(apiLink, options)
            .then(res => res.json())
            .then(res => {
                Swal.fire({
                    position: 'top',
                    icon: 'success',
                    title: `${this.OldUser ? 'Utente aggiornato' : 'Nuovo utente creato'}`,
                    text: `L'utente ${res.username} con id ${res.id} è stato ${this.OldUser ? 'aggiornato' : 'creato'}`,
                    showConfirmButton: false,
                    timer: 2000
                }).then(() => homePage())
            })

    }

    updateForm(user) {

        for (let input of this.inputs) {
            input.value = user[input.id]
        }

        this.OldUser = user;
    }

}
