const displayUserData = document.querySelector('div#user-data')
const displayPost = document.querySelector('form#new-post')

const displayOldPost = document.querySelector('div#old-post')

class UserData {
    constructor(target) {
        this.user = JSON.parse(sessionStorage.getItem('loggedUser')).user

        this.createData(target, 'username', 'firstName', 'lastName', 'email', 'phone', 'address')
        this.createButton(target)

    }


    createButton(target) {

        let div = document.createElement('div')
        div.className = 'mt-4 row justify-content-around'

        let btnUpdate = document.createElement('button')
        btnUpdate.className = 'btn btn-primary col-5'
        btnUpdate.innerHTML = 'Modifica'

        btnUpdate.addEventListener('click', () => {
            location.href = 'form.html?update' + encodeURIComponent('&id=' + this.user.id);
        })

        let btnDelete = document.createElement('button')
        btnDelete.className = 'btn btn-danger col-5'
        btnDelete.innerHTML = 'Elimina'

        btnDelete.addEventListener('click', () => {
            Table.deleteUser(this.user.id)
        })

        div.append(btnUpdate, btnDelete)

        target.append(div)
    }

    createData(target, ...elem) {

        for (let dataName of elem) {

            let p = document.createElement('p');

            switch (dataName) {
                case 'username':
                    p.innerHTML = 'Username: ' + this.user.username;
                    break;
                case 'firstName':
                    p.innerHTML = 'Nome: ' + (this.user.name.split(' '))[0].replaceAll('-', ' ')
                    break;
                case 'lastName':
                    p.innerHTML = 'Cognome: ' + (this.user.name.split(' '))[1].replaceAll('-', ' ')
                    break;
                case 'email':
                    p.innerHTML = 'Email: ' + this.user.email
                    break;
                case 'phone':
                    p.innerHTML = 'Telefono: ' + this.user.phone
                    break;
                case 'address':
                    p.innerHTML = 'Indirizzo: ';
                    if (this.user.address) {
                        for (let elem in this.user.address) {
                            p.innerHTML += this.user.address[elem] + ' ';
                        }
                    }
                    break;

            }

            target.append(p)
        }
    }

}

class Post {
    constructor(targetNewPost, targetOldPost) {
        this.user = JSON.parse(sessionStorage.getItem('loggedUser')).user

        this.textArea = document.createElement('textarea');
        this.textArea.className = 'form-control';
        this.textArea.setAttribute('rows', 5);
        this.textArea.required = true;

        let btn = this.createBtn(targetOldPost)

        targetNewPost.append(this.textArea, btn)

        this.fillOldPost(targetOldPost)
    }

    createBtn(targetOldPost) {
        let btn = document.createElement('button');
        btn.className = "btn btn-primary container mt-2";
        btn.innerHTML = 'Pubblica';

        btn.addEventListener('click', (e) => {
            e.preventDefault();

            let postText = this.textArea.value;

            if (postText) {

                let options = {
                    method: 'POST',
                    body: JSON.stringify({username: this.user.username ,post: postText }),
                    headers: { "content-type": "application/json" }
                }

                fetch(homePostAPI, options)

                fetch(userAPI + '/' + this.user.id + '/userPost', options)
                    .then(res => res.json())
                    .then(res => this.insertPost(res, targetOldPost))

                this.textArea.value = '';
            }

        })

        return btn;
    }

    insertPost(post, targetOldPost) {
        let article = document.createElement('article')
        article.className = "position-relative bg-light bg-opacity-75 container border-bottom border-primary rounded p-4 mb-2"
        article.innerText = post.post;

        let btn = document.createElement('button')
        btn.className = 'btn-close position-absolute top-0 end-0 m-2'

        btn.addEventListener('click', () => this.deletePost(post, article))

        article.append(btn)

        targetOldPost.prepend(article);
    }

    fillOldPost(targetOldPost) {
        fetch(userAPI + '/' + this.user.id + '/userPost')
            .then(res => res.json())
            .then(res => {
                for (let i = 0; i < res.length; i++) {

                    this.insertPost(res[i], targetOldPost)

                }
            })
    }

    deletePost(post, article) {

        let options = {
            method: 'DELETE',
            headers: { "content-type": "application/json" }
        }

        fetch(homePostAPI + '/' + post.id, options)

        fetch(userAPI + '/' + this.user.id + '/userPost' + '/' + post.id, options)
            .then(() => article.remove());
    }
}

let data = new UserData(displayUserData);
let post = new Post(displayPost, displayOldPost)
