"use strict";
class Todo {
    constructor(selector) {
        this.target = document.querySelector(selector);
        this.creaHtmlBase();
    }
    creaHtmlBase() {
        let input = document.createElement('input');
        let button = document.createElement('button');
        let list = document.createElement('div');
        button.addEventListener('click', () => this.creaHtmlTodo());
        input.classList.add('form-control');
        button.classList.add('btn', 'btn-primary');
        button.textContent = 'salva';
        this.input = input;
        this.button = button;
        this.list = list;
        if (this.target) {
            this.target.append(input, button, list);
        }
        else {
            throw new Error('Elemento non trovato');
        }
    }
    creaHtmlTodo() {
        let newTodo = document.createElement('div');
        newTodo.classList.add('alert', 'alert-success');
        newTodo.textContent = this.input.value;
        this.list.append(newTodo);
    }
}
new Todo('#todo');
//# sourceMappingURL=script.js.map