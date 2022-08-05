class User {
    constructor(name, lastName, birth) {

        this.name = name;
        this.lastName = lastName;
        this.birth = new Date(birth).toLocaleDateString();

    };

}

class Form {

    constructor() {

        this.button = '';

        this.formCreation();

    };

    elementCreation(tag, cName, type,placeholder) {
        let element = document.createElement(tag);
        element.className = cName;

        if (tag == 'input') {
            let div = document.createElement('div');
            let label = document.createElement('label');
            label.innerHTML = placeholder + ':';

            element.placeholder = placeholder;
            element.type = type
            element.required = true;

            div.append(label,element);
            return div;
        }

        return element;
    };

    formCreation() {
        this.form = this.elementCreation('form', 'form');

        let username = this.elementCreation('input', 'username', 'text','Username');
        let firstName = this.elementCreation('input', 'first-name', 'text','Nome');
        let lastName = this.elementCreation('input', 'last-name', 'text','Cognome');
        let email = this.elementCreation('input', 'email', 'email','Email');

        let male = this.elementCreation('radio', 'last-name', 'text','Cognome');
        let female = this.elementCreation('radio', 'last-name', 'text','Cognome');
        let other = this.elementCreation('radio', 'last-name', 'text','Cognome');

        let button = this.elementCreation('button', 'btn btn-success');
        button.innerText = 'Salva';

        this.button = button;

        this.form.append(username, firstName, lastName, email, button);

        /*button.addEventListener('click', (e) => {
            e.preventDefault();
            this.createUser(inputName, inputLastName, inputBirth)
        });*/
    };

    /*createUser(name, lastName, birth) {
        let user = new User(name.value, lastName.value, birth.value);

        name.value = '';
        lastName.value = '';
        birth.value = '';

        this.table.append(user.printUser());
    }*/

}