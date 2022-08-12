class Form {

    //al costruttore passo un array con tutti gli input da creare e il target dove inserire gli elementi DOM
    constructor(newInputs, target) {

        this.isUpdate = location.href.includes('/form.html?update');

        if (this.isUpdate) {
            let url = new URL(decodeURIComponent(location.href))
            this.id = url.searchParams.get('id')
        }

        this.form = document.createElement("form")
        this.form.className = "needs-validation"


        if (this.isUpdate) {
            this.callFetch(this.id)
                .then(user => {
                    this.createForm(newInputs, user);
                })

        } else {

            this.createForm(newInputs);
        }

        document.querySelector(target).append(this.form)
    }

    async callFetch(id = '') {
        const response = await fetch(userAPI + '/' + id)
        const data = await response.json();
        return data;
    }

    //ottenendo un oggetto come parametro prendo i suoi valori interni per parametrizzare i vari elementi
    //e ritorno il div che contiene i suddetti
    createInput(obj, user) {

        let div = document.createElement("div")
        div.className = `form-floating col-sm-${obj.col}`

        let input;

        if (obj.type == 'textarea') {
            input = document.createElement("textarea")
            input.style = obj.style;

        } else {
            input = document.createElement("input")
            input.type = obj.type

        }

        input.className = obj.classInput
        input.id = obj.id
        input.placeholder = obj.title
        input.required = obj.required

        let label = document.createElement("label")
        label.className = obj.classLabel
        label.innerHTML = obj.title
        label.htmlFor = obj.id


        //scrive all interno degli input
        if (this.isUpdate) {
            let value = user[obj.id]
            switch (obj.id) {
                case 'firstName':
                    input.value = (user.name.split(' '))[0].replaceAll('-', ' ')
                    break;
                case 'lastName':
                    input.value = (user.name.split(' '))[1].replaceAll('-', ' ')
                    break;
                default:
                    if (obj.id.includes("address")) {
                        user.address && (input.value = user.address[obj.id.split('-')[1]])
                        break;
                    }

                    if (obj.id.includes("company")) {
                        user.company && (input.value = user.company[obj.id.split('-')[1]])
                        break;
                    }

                    value && (input.value = value)
            }
        }

        div.append(input, label)
        return div;
    }

    //creo il contenitore per gli input e tramite l'array di oggetti chiamo il metodo per crearli
    //infine creo il bottone inserisco il tutto nel elemento form
    createForm(newInputs, user) {

        let div = document.createElement("div");
        div.className = "container mx-auto row g-3"

        for (let input of newInputs) {
            div.append(this.createInput(input, user))
        }

        let button = document.createElement('button')
        button.className = "col-12 btn btn-success btn-lg"
        this.isUpdate ? button.innerHTML = 'Aggiorna utente' : button.innerHTML = 'Salva utente'

        button.addEventListener("click", (e) => {
            e.preventDefault();

            this.form.className = 'was-validated'

            //seleziono tutti gli elementi che tramite bootstrap sono considerati validi 
            this.allInputs = this.form.querySelectorAll('.form-control:valid')

            //verifico l'univocita del username
            let username = Array.from(this.allInputs).find(node => node.id == 'username')
            let alredyUse = false

            if (this.allInputs.length == newInputs.length) {
                this.callFetch()
                    .then(users => {
                        users.forEach(element => {
                            if (element.id != this.id && element.username.toUpperCase() == username.value.toUpperCase()) {

                                alredyUse = true;

                                console.error('Username già in uso')
                            }
                        });
                    })

                    //verifico che gli elementi validi abbiano la stessa lunghezza degli input creati
                    //se questa condizione è vera creo l'utente
                    .then(() => {
                        if (!alredyUse) {
                            this.isUpdate ? this.updateUser() : this.saveUser();
                        } else {
                            username.value = '';

                            if (username.parentNode.querySelectorAll('.invalid-feedback').length == 0) {

                                let div = document.createElement('div')
                                div.className = 'invalid-feedback'
                                div.innerHTML = 'Username già in uso'
                                username.parentNode.append(div);
                            }
                        }
                    })
            }
        })

        div.append(button)

        this.form.append(div)
    }

    //creo l'oggetto utente scorrendo l'array di input validi e prendendone il contenuto 
    saveUser() {
        let data = {}

        for (let value of this.allInputs) {
            switch (value.id) {
                case 'firstName':
                    data.name = value.value.replaceAll(' ', '-')
                    break;
                case 'lastName':
                    data.name += ' ' + value.value.replaceAll(' ', '-')
                    break;
                case 'username':
                    data.username = value.value
                    break;
                case 'email':
                    data.email = value.value
                    break;
                case 'phone':
                    data.phone = value.value
                    break;

            }
        }

        //setto le opzioni per l'inserimento di un nuovo utente
        let options = {
            method: 'POST',
            body: JSON.stringify(data),
            headers: { "content-type": "application/json" }
        }

        //applico le opzioni al indirizzo corretto 
        fetch(userAPI, options)
            .then(res => res.json())
            .then(res => {
                Swal.fire({
                    position: 'top',
                    icon: 'success',
                    title: 'Utente creato',
                    text: `L'utente ${res.name.replaceAll('-', ' ')} è stato creato all'id ${res.id}`,
                    showConfirmButton: false,
                    timer: 2000
                }).then(() => {
                    location.href = 'index.html';
                })

            })
    }

    updateUser() {
        let data = {
            address: {},
            company: {}
        }

        for (let value of this.allInputs) {
            switch (value.id) {
                case 'firstName':
                    data.name = value.value.replaceAll(' ', '-')
                    break;
                case 'lastName':
                    data.name += ' ' + value.value.replaceAll(' ', '-')
                    break;
                case 'username':
                    data.username = value.value
                    break;
                case 'email':
                    data.email = value.value
                    break;
                case 'phone':
                    data.phone = value.value
                    break;
                default:
                    if (value.id.includes("address")) {
                        Object.assign(data.address, { [value.id.split('-')[1]]: value.value })
                        break;
                    }

                    if (value.id.includes("company")) {
                        Object.assign(data.company, { [value.id.split('-')[1]]: value.value })
                        break;
                    }

            }
        }

        //setto le opzioni per l'inserimento di un nuovo utente
        let options = {
            method: 'PUT',
            body: JSON.stringify(data),
            headers: { "content-type": "application/json" }
        }

        //applico le opzioni al indirizzo corretto 
        fetch(userAPI + '/' + this.id, options)
            .then(res => res.json())
            .then(res => {
                Swal.fire({
                    position: 'top',
                    icon: 'success',
                    title: 'Utente aggiornato',
                    text: `L'utente ${res.name.replaceAll('-', ' ')} con id ${res.id} è stato aggiornato `,
                    showConfirmButton: false,
                    timer: 2000
                }).then(() => {
                    let logged = sessionStorage.getItem('loggedUser')
                    data.id = this.id
                    logged && sessionStorage.setItem('loggedUser', JSON.stringify({ header: true, user: data }))

                }).then(() => {
                    location.href = 'index.html';
                })

            })
    }
}

//chiamo il form per la creazione dell utente
function createUserForm() {

    //creo un array con gli input desiderati 
    let newInput = [
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'firstName',
            title: 'Nome',
            required: true,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'lastName',
            title: 'Cognome',
            required: true,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'username',
            title: 'Username',
            required: true,
            col: 4
        },
        {
            type: 'email',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'email',
            title: 'Email',
            required: true,
            col: 6
        },
        {
            type: 'tel',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'phone',
            title: 'Telefono',
            required: true,
            col: 6
        }
    ]

    //creo un elemento con classe form con input e target personalizzati
    let form = new Form(newInput, '#target-form')
}

function updateUserForm() {

    //creo un array con gli input desiderati 
    let newInput = [
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'firstName',
            title: 'Nome*',
            required: true,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'lastName',
            title: 'Cognome*',
            required: true,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'username',
            title: 'Username*',
            required: true,
            col: 4
        },
        {
            type: 'email',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'email',
            title: 'Email*',
            required: true,
            col: 6
        },
        {
            type: 'tel',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'phone',
            title: 'Telefono*',
            required: true,
            col: 6
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'address-street',
            title: 'Indirizzo',
            required: false,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'address-suite',
            title: 'N° civico',
            required: false,
            col: 2
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'address-city',
            title: 'Città',
            required: false,
            col: 4
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'address-zipcode',
            title: 'CAP',
            required: false,
            col: 2
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'company-name',
            title: 'Società',
            required: false,
            col: 6
        },
        {
            type: 'text',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'company-bs',
            title: 'Titolo di studio',
            required: false,
            col: 6
        },
        {
            type: 'textarea',
            style: 'height: 100px',
            classInput: 'form-control',
            classLabel: 'form-label',
            id: 'company-catchPhrase',
            title: 'Slogan',
            required: false,
            col: 12
        }
    ]

    //creo un elemento con classe form con input e target personalizzati
    let form = new Form(newInput, '#target-form')
}

