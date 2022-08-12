class Table {
    constructor(target, users) {

        this.table = document.createElement("table");

        this.table.className = "container table table-sm.tablepadding text-primary table-hover text-center align-middle"

        this.createThead()
        this.createTbody(users)

        document.querySelector(target).append(this.table)
    }

    createThead() {

        let thead = document.createElement("thead");

        let tr = document.createElement("tr")
        tr.className = "table-primary "

        let titles = ["#", "Username", "Name", "Email", "Options"]

        for (let title of titles) {

            let th = document.createElement("th")
            th.innerHTML = title
            th.setAttribute("scope", "col")

            tr.append(th)
        }

        thead.append(tr)

        this.table.append(thead)

    }

    createTbody(users) {
        let tbody = document.createElement("tbody");

        let array = ['username', 'name', 'email']

        for (let user of users) {
            let tr = document.createElement("tr");

            let th = document.createElement("th");
            th.setAttribute("scope", "row");
            th.innerHTML = user.id;
            th.className = "text-primary"

            tr.append(th)

            for (let data of array) {

                let td = document.createElement("td")
                td.innerHTML = user[data].replaceAll('-', ' ')
                tr.append(td)

            }

            let td = document.createElement("td")

            let btnUpdate = document.createElement("button")
            btnUpdate.className = "btn btn-outline-primary me-1"
            btnUpdate.innerHTML = "Modifica"
            btnUpdate.addEventListener('click', () => {
                location.href = 'form.html?update' + encodeURIComponent('&id=' + user.id);
            })

            let btnDelete = document.createElement("button")
            btnDelete.className = "btn btn-danger"
            btnDelete.innerHTML = "Elimina"
            btnDelete.addEventListener('click', () => {
                Table.deleteUser(user.id, tr)
            })

            td.append(btnUpdate);

            user.id != 1 && td.append(btnDelete);

            tr.append(td)

            tbody.append(tr)
        }

        this.table.append(tbody)

    }

    static deleteUser(id, tr) {

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {

            if (result.isConfirmed) {

                let options = {
                    method: 'DELETE',
                    headers: { "content-type": "application/json" }
                }

                //applico le opzioni al indirizzo corretto 
                fetch(userAPI + '/' + id, options)
                    .then(res => res.json())
                    .then(res => {

                        if (res != 'Not found') {
                            Swal.fire({
                                position: 'top',
                                icon: 'success',
                                title: 'Utente eliminato',
                                text: `L'utente ${res.name.replaceAll('-', ' ')} è stato eliminato`,
                                showConfirmButton: false,
                                timer: 2000
                            }).then(() => {
                                if (tr) {
                                    tr.remove()
                                } else {
                                    
                                    sessionStorage.removeItem('loggedUser')
                                    location.href = 'index.html'
                                }
                            })
                        } else {
                            Swal.fire({
                                position: 'top',
                                icon: 'error',
                                title: 'Utente non trovato',
                                text: `L'utente con id: ${id} non è stato trovato`,
                                showConfirmButton: false,
                                timer: 2000
                            })
                        }

                    })
            }
        })
    }
};

