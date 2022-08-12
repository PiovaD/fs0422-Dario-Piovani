const userAPI = 'https://62ebe240705264f263e2c5b2.mockapi.io/api/1/usersBW'
const homePostAPI = 'https://62ebe240705264f263e2c5b2.mockapi.io/api/1/homePost'

location.href.includes('/form.html?create') && createUserForm(userAPI);

location.href.includes('/form.html?update') && updateUserForm(userAPI);

location.href.includes('/form.html?userUpdate') && updateUserForm(userAPI);

let header = document.querySelector('#header-login');

let logged = JSON.parse(sessionStorage.getItem('loggedUser'))

if (logged && logged.header) {
    loggedHeader(header, logged.user)

} else {

    document.querySelector('#login').addEventListener('click', (e) => {
        e.preventDefault();

        let userLogin = document.querySelector('#username-login').value

        if (userLogin == 'Admin') {
            location.href = 'admin.html';
        } else {

            fetch(userAPI)
                .then(res => res.json())
                .then(res => {
                    let user = res.find(element => element.username.toLowerCase() == userLogin.toLowerCase())
                    if (user) {

                        let header = document.querySelector('#header-login');

                        loggedHeader(header, user)

                        let isLogged = {
                            header: true,
                            user: user
                        }

                        sessionStorage.setItem('loggedUser', JSON.stringify(isLogged));

                        location.href = 'index.html';

                    } else {

                        document.querySelector('#username-login').value = ''

                    }

                })
        }
    })
}

function loggedHeader(target, user) {

    let btnProfile = createBtn(user.username, 'profilo');
    btnProfile.addEventListener('click', () => location.href = 'user.html?' + encodeURIComponent('&id=' + user.id))

    let btnLogout = createBtn('Logout', 'logout');
    btnLogout.addEventListener('click', () => {
        sessionStorage.removeItem('loggedUser')
        location.href = 'index.html';
    })

    target.innerHTML = ''
    target.append(btnProfile, btnLogout);

}

function createBtn(text, name) {
    let div = document.createElement('div')
    div.className = 'col-12 col-md-auto mb-2 mb-md-0'

    let btn = document.createElement('button');

    name == 'logout' ?
        btn.className = 'btn btn-primary w-100'
        :
        btn.className = 'btn btn-outline-primary w-100'


    btn.id = name
    btn.innerText = text

    div.append(btn)

    return div;
}