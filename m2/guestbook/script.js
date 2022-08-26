const POSTAPI = "http://localhost:3000/post";
const newPostContainer = document.querySelector("#new-comment");
const postConatiner = document.querySelector("#past-comment");

class Guestbook {
    constructor(postTarget, getTarget, data) {

        this.createForm(postTarget);

        for (let comment of data) {
            this.commentStamp(getTarget, comment);
        }
    };

    createForm(postTarget) {
        let form = document.createElement("form");

        let inputText = document.createElement('input');
        inputText.type = "text";
        inputText.placeholder = "Nome";
        inputText.required = true;

        let textarea = document.createElement('textarea');
        textarea.placeholder = "Inserire testo"
        textarea.setAttribute('rows', 5)
        textarea.required = true;

        let btn = this.createDOM('button', 'Pubblica');

        btn.addEventListener("click", (e) => {
            e.preventDefault();

            if (textarea.value && inputText.value) {

                this.save(inputText.value, textarea.value)
            }

            if(!inputText.value && inputText.nextElementSibling.className != 'error') {
                inputText.parentNode.insertBefore(this.invalid(),inputText.nextSibling)
            }else if(inputText.value && inputText.nextElementSibling.className == 'error'){
                inputText.nextElementSibling.remove();
            }

            if(!textarea.value && textarea.nextElementSibling.className != 'error') {
                textarea.parentNode.insertBefore(this.invalid(),textarea.nextSibling)
            }else if(textarea.value && textarea.nextElementSibling.className == 'error'){
                textarea.nextElementSibling.remove();
            }
            
        })

        form.append(inputText, textarea, btn);

        postTarget.append(form);

    };

    invalid() {
        let p = document.createElement('p');
        p.className = 'error';
        p.innerHTML = "Riempire il campo"
        return p;
    }

    save(name, text) {

        let post = {
            name: name,
            data: new Date().toLocaleString(),
            comment: text
        }

        let options = {
            method: 'POST',
            headers: {'Content-Type' : 'application/json'},
            body: JSON.stringify(post)
        }

        fetch(POSTAPI, options)
        .then(res => location.reload())
    };

    commentStamp(getTarget, comment) {

        let article = document.createElement("article");

        article.append(this.createDOM('h5', comment.name), this.createDOM('p', comment.comment), this.createDOM('p', comment.data));

        getTarget.prepend(article);
    };

    createDOM(tag, text = '') {
        let elem = document.createElement(tag);

        elem.innerText = text;

        return elem;
    };
};

fetch(POSTAPI)
    .then(res => res.json())
    .then(data => {
        let guestbook = new Guestbook(newPostContainer, postConatiner, data);
    })
