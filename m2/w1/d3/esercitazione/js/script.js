//funzione rotazione 
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function () {

        let rotazione = button.getAttribute('data-rotate')

        let container = document.querySelector('#container');

        let angle = parseInt(container.getAttribute('data-angle'));

        console.log(angle);

        switch (rotazione) {

            case 'l':
                angle -= 90;
                break;

            case 'r':
                angle += 90;
                break;
        }

        rotate(angle);
        container.setAttribute('data-angle', angle);

    });

});

function rotate(angle) {

    let container = document.querySelector('#container');

    container.style.transform = `rotateY(${angle}deg)`;

}

//funzione hov
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('mouseover', function () {

    });

});