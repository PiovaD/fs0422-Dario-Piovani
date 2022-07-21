// abbreviazione per query selector
let qs = (element) => document.querySelector(element);

// abbreviazione per query selector all
let qsA = (element) => document.querySelectorAll(element);

//toggle del menu di formattzione al inizio della pagina
qs('.dropbtn').addEventListener('click', () => qs('.myDropdown').classList.toggle('active'));

// menu di formattazione a inizio pagina
qsA('.formattazione').forEach(element => element.addEventListener('click', () => modifica(element, '#esercizio')));

//chiama la funzione per aggiungere elementi
qs('#create-list').addEventListener('click', add);

//prende l'invio come comando per aggiungere elementi
qs('#insert').addEventListener('keypress', (event) => event.keyCode === 13 && add());

//distrugge lintera lista
qs('#destroy-list').addEventListener('click', () => qs('#lista').innerHTML = '')

//rimuove elementi dalla lista
let remove = (li) => li.remove();

//attiva e disattiva i dropdown
let toggle = (div) => div.classList.toggle('active');

//modificatrore di stile
function modifica(element, container) {

    let modifier = element.getAttribute('data-style');

    typeof container != 'string' ? sect = container : sect = qs(container)

    switch (modifier) {
        case 'italic':
            sect.style.fontStyle != 'italic' ?
                sect.style.fontStyle = 'italic' :
                sect.style.fontStyle = ''
            break

        case 'bold':
            sect.style.fontWeight != 'bold' ?
                sect.style.fontWeight = 'bold' :
                sect.style.fontWeight = ''
            break

        case 'underline':
            decoration(modifier, sect)
            break

        case 'line-through':
            decoration(modifier, sect)
            break

        case 'reset':
            sect.style.fontStyle = ''
            sect.style.fontWeight = ''
            sect.style.textDecoration = ''
            break

        case 'delete':
            remove(container);
            break
    }

}

//gestisco text decoration uguali
function decoration(decoration, sect) {
    console.log(sect.style.textDecoration.search(decoration))
    if (sect.style.textDecoration == decoration) {
        sect.style.textDecoration = ''

    } else if (sect.style.textDecoration.search(decoration) > -1) {
        sect.style.textDecoration = sect.style.textDecoration.replace(decoration, '');

    } else {
        sect.style.textDecoration += ' ' + decoration

    }
}

//aggiunge elemento a lista
function add() {

    let toDoList = qs('#lista');
    let insert = qs('#insert');
    let impegno = insert.value;

    if (impegno) {

        let li = document.createElement('li');

        let div = document.createElement('div');
        let transform = ['underline', 'bold', 'line-through', 'reset', 'delete'];
        div.classList.add('myDropdown');

        for (let style of transform) {

            let p = document.createElement('p')

            p.setAttribute('data-style', style)

            switch (style) {
                case 'underline':
                    p.innerHTML = 'Sottolinea'
                    break
                case 'bold':
                    p.innerHTML = 'Grassetto'
                    break
                case 'line-through':
                    p.innerHTML = 'Barra'
                    break
                case 'reset':
                    p.innerHTML = 'Reset dello stile'
                    break
                case 'delete':
                    p.innerHTML = 'Cancella'
                    break
            }

            console.log(li);
            p.addEventListener('click', () => modifica(p, li));

            div.append(p)
        }

        li.addEventListener('click', () => toggle(div));
        li.innerHTML = '🔶 ' + String(impegno);
        li.append(div);
        toDoList.append(li);
    }

    insert.value = '';
}

