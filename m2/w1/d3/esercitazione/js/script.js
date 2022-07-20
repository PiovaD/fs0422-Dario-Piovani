//funzione rotazione 
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function () {
        movment(90, button)
    })
});

document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('mouseover',  function () {
        movment(45, button)
    })
})

document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('mouseout',  function () {
        movment(-45, button)
    })
})


function movment(set, button) {
    console.log(set)

    let rotazione = button.getAttribute('data-rotate')

    let container = document.querySelector('#container');

    let angle = parseInt(container.getAttribute('data-angle'));

    console.log(angle);

    switch (rotazione) {

        case 'l':
            angle -= set;
            break;

        case 'r':
            angle += set;
            break;
    }

    rotate(angle);
    container.setAttribute('data-angle', angle);

}

function rotate(angle) {

    let container = document.querySelector('#container');

    container.style.transform = `rotateY(${angle}deg)`;

}
