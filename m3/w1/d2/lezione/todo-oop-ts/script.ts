class Todo {
    protected target!: HTMLElement | null;
    protected input!: HTMLInputElement
    protected button!: HTMLButtonElement
    protected list!: HTMLElement

    constructor(selector: string) {
        this.target = document.querySelector(selector);

        this.creaHtmlBase()

    }

    protected creaHtmlBase() {

        let input: HTMLInputElement = document.createElement('input');
        let button: HTMLButtonElement = document.createElement('button');

        let list: HTMLElement = document.createElement('div');

        button.addEventListener('click', () => this.creaHtmlTodo())

        input.classList.add('form-control')
        button.classList.add('btn', 'btn-primary')

        button.textContent = 'salva';

        this.input = input
        this.button = button
        this.list = list

        if (this.target) {
            this.target.append(input, button, list);
        } else {
            throw new Error('Elemento non trovato')
        }

    }

    public creaHtmlTodo() {
        let newTodo: HTMLElement = document.createElement('div')
        newTodo.classList.add('alert', 'alert-success')

        newTodo.textContent = this.input.value
        this.list.append(newTodo)
    }
}

new Todo('#todo')