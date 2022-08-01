class Todo {
    constructor(target) {

        this.target = document.querySelector(target);

        this.input = '';
        this.button = '';
        this.list = '';

        this.createBaseHTML()

    }

    createInput() {
        let input = this.createElementWithClass('input', 'form-control')
        input.type = 'text';

        this.input = input;
    }

    createButton() {
        let button = this.createElementWithClass('button', 'btn btn-primary');
        button.classList.add('btn', 'btn-primary');
        button.innerHTML = 'Save';

        button.addEventListener('click', () => this.addTodo())

        this.button = button;
    }

    addTodo() {
        let div = this.createElementWithClass('div', 'alert alert-success');
        div.innerHTML = this.input.value;

        this.list.append(div);

        div.addEventListener('click', () => {
            div.remove();
        })

        this.input.value = '';

    }

    createBaseHTML() {

        let formContainer = this.createElementWithClass('div', 'container');
        let listaContainer = this.createElementWithClass('div', 'container');
        let list = this.createElementWithClass('div', 'row');

        this.list = list;

        this.createInput();

        this.createButton();

        formContainer.append(this.input, this.button);
        listaContainer.append(list);

        this.target.append(formContainer, listaContainer);
    }

    createElementWithClass(tag, className) {
        let element = document.createElement(tag);
        element.className = className;
        return element;
    }
}

let todo = new Todo('#todo1');
let todo2 = new Todo('#todo2');