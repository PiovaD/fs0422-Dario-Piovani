let qs = (element) => document.querySelector(element)

let qsA = (element) => document.querySelectorAll(element)

qs('.dropdown').addEventListener('click', () => qs('#myDropdown').classList.toggle('active'))


qsA('.formattazione').forEach(element => {
    element.addEventListener('click', () => {

        let modifier = element.getAttribute('data-style');
        let sect = qs('#esercizio')

        sect.style.textDecoration = ''
        sect.style.fontStyle = ''
        sect.style.fontWeight = ''

        switch (modifier) {
            case 'italic':
                sect.style.fontStyle = 'italic'
                break
            case 'bold':
                sect.style.fontWeight = 'bold'
                break
            case 'underline':
                sect.style.textDecoration = 'underline'
                break
        }

    })
})

qs('#create-list').addEventListener('click', () => {

    let toDoList = qs('#to-do')
    let insert = qs('#insert')
    let impegno = insert.value;

    let li = document.createElement('li')

    if (impegno) {
        li.addEventListener('click', () => li.remove())
        li.innerHTML = impegno
        toDoList.append(li)
    }

    insert.value = '';

})

