class User {
    constructor(name, lastName, birth) {

        this.name = name;
        this.lastName = lastName;
        this.birth = new Date(birth).toLocaleDateString();

    };

    printUser() {

        return User.insertRow('td', this.name, this.lastName, this.birth)

    };

    static insertRow(tag, _name, _lastName, _date) {

        let tr = document.createElement('tr');

        let name = document.createElement(tag);
        let lastName = document.createElement(tag);
        let date = document.createElement(tag);

        name.innerHTML = _name;
        lastName.innerHTML = _lastName;
        date.innerHTML = _date;

        tr.append(name, lastName, date);

        return tr;

    }

}

class Form {

    constructor(target) {

        this.target = document.querySelector(target)

        this.button = '';
        this.table = '';

        this.formCreation();

        this.crateTable();
    };

    elementCreation(tag, cName) {
        let element = document.createElement(tag);
        element.className = cName;

        return element;
    };

    formCreation() {
        let form = this.elementCreation('div', 'form');

        let inputName = this.elementCreation('input', 'name');
        let inputLastName = this.elementCreation('input', 'last-name');
        let inputBirth = this.elementCreation('input', 'birth');

        let button = this.elementCreation('button', 'btn');
        button.innerText = 'Salva';

        this.button = button;

        inputName.type = 'text';
        inputLastName.type = 'text';
        inputBirth.type = 'date';

        inputName.required = true;
        inputLastName.required = true;
        inputBirth.required = true;

        form.append(inputName, inputLastName, inputBirth, button);

        this.target.append(form);

        button.addEventListener('click', () => this.createUser(inputName, inputLastName, inputBirth));
    };

    createUser(name, lastName, birth) {
        let user = new User(name.value, lastName.value, birth.value);

        name.value = '';
        lastName.value = '';
        birth.value = '';

        this.table.append(user.printUser());
    }

    crateTable() {
        let table = this.elementCreation('table', 'table');
        this.table = table;

        table.append(User.insertRow('th','Nome','Cognome','Data di nascita'));

        this.target.append(table);

    }

}

let form = new Form('#container-form');