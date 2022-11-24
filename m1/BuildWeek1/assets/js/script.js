window.addEventListener("scroll", reveal);
reveal();

/*scroll*/

function reveal() {
    let reveals = document.querySelectorAll(".reveal");
    for (let i = 0; i < reveals.length; i++) {
        let windowHeight = window.innerHeight;
        let elementTop = reveals[i].getBoundingClientRect().top;
        let elementVisible = 30;
        if (elementTop < windowHeight - elementVisible) {
            reveals[i].classList.add("active");
        } else {
            reveals[i].classList.remove("active");
        }
    }
}

//nav menu 
window.addEventListener("scroll", hoverMenu);
hoverMenu();

function hoverMenu() {
    let navItems = document.querySelectorAll(".nav-item");
    let navMenu = document.querySelectorAll(".item");
    let isFirstLoop = true;

    for (let i = 0; i < navItems.length; i++) {
        let windowHeight = window.innerHeight;
        let elementTop = navItems[i].getBoundingClientRect().top;
        let elementVisible = 800;

        if (elementTop < windowHeight - elementVisible) {
            navMenu[i].classList.remove("nav-active");
            if (isFirstLoop && i == navItems.length - 1) {
                navMenu[i].classList.add("nav-active");
                isFirstLoop = false;
            }
        } else {
            if (isFirstLoop && i > 0) {
                navMenu[i - 1].classList.add("nav-active");
                isFirstLoop = false;
            }
            navMenu[i].classList.remove("nav-active");
        }
    }
}


//slider
document.querySelector('.right').addEventListener('click', function () {

    let images = document.querySelector('#images');
    let left = parseInt(images.getAttribute('data-left'));
    let allSlides = images.querySelectorAll('.slide-img');
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = images.clientWidth;

    let dotContainer = document.querySelector(".dot-container")
    let dot = document.querySelectorAll(".dot");
    let iter = dotContainer.getAttribute('data-iter');

    const IMGSTYLE = window.getComputedStyle(allSlides[0], null);
    const PADDINGSTRING = IMGSTYLE.getPropertyValue("padding-right");
    const PADDING = parseInt(PADDINGSTRING.replace(/[^0-9.]/g, ""))

    if (left < (allSlides.length * (firstSlideWidth - PADDING)) - sliderWidth) {

        left += parseInt(firstSlideWidth);

        if ((left / firstSlideWidth) * firstSlideWidth >=
            (allSlides.length * (firstSlideWidth - PADDING) / dot.length) * iter) {
            iter++;
        }

        setActive(iter - 1);

    } else {
        left = 0;
        iter = 1;
        setActive(iter - 1);

    }
    images.style.transform = "translate(-" + left + "px ,0)"
    images.setAttribute('data-left', left)

    dotContainer.setAttribute('data-iter', iter)

});

/*
*  sistema le dimensioni degli elementi nello slider 
*  e nel caso fosse stato effettuato uno spostamento lo mantine
*/

let oldWidth = window.innerWidth;

window.onresize = function () { //permette il funzionamento dei dot dopo il resize della pagina
    if (oldWidth != window.innerWidth) {
        location.reload(false);
    }
};

(function () {

    let wrapper = document.querySelector('#images');
    let img = wrapper.querySelectorAll('.slide-img');;
    let sWidth = wrapper.clientWidth;
    let left = (wrapper.getAttribute('data-left'));
    let oldWidth = parseInt(img[0].clientWidth);


    let dotContainer = document.querySelector(".dot-container")
    let iter = dotContainer.getAttribute('data-iter');

    const IMGSTYLE = window.getComputedStyle(img[0], null);
    const PADDINGSTRING = IMGSTYLE.getPropertyValue("padding-right");
    const PADDING = parseInt(PADDINGSTRING.replace(/[^0-9.]/g, ""))

    resetDot();

    // imposto una larghezza base
    for (let i = 0; i < img.length; i++) {
        img[i].style.width = "max-content";
    }

    let imgWidth = img[0].clientWidth;

    // imposto la larghezza per il fit
    if (parseInt(sWidth / (imgWidth - PADDING)) <= 2) {

        insertDot(Math.round(img.length / 2));

        setWidth(2, img, sWidth, PADDING)

    } else if (parseInt(sWidth / (imgWidth - PADDING)) <= 3) {

        insertDot(Math.round(img.length / 3));

        setWidth(3, img, sWidth, PADDING)

    } else {

        insertDot(Math.round(img.length / 4));

        setWidth(4, img, sWidth, PADDING)
    }


    //modifico lo spostamento
    if (left != 0) {
        const RATIO = Math.round(left / oldWidth)
        left = (parseInt(img[0].style.width) * RATIO) + (PADDING * RATIO);

        iter = Math.ceil((left / sWidth) + 0.1) - 1;
        setActive(iter);

        wrapper.style.transform = "translate(-" + left + "px ,0)"
        wrapper.setAttribute('data-left', left)
    } else {
        setActive(0);
    }

    dotContainer.setAttribute('data-iter', iter)
})();

//setta le larghezze agli elementi dello slider
function setWidth(numImg, img, sWidth, PADDING) {

    for (let i = 0; i < img.length; i++) {
        img[i].style.width = parseInt(sWidth / numImg) - PADDING + "px";
    }
}

//inserisco i punti
function insertDot(n) {
    for (let i = 0; i < n; i++) {
        var divElement = document.createElement("div");
        divElement.classList.add("dot");
        divElement.dataset.gravity = i + 1;

        document.querySelector(".dot-container").appendChild(divElement);
    }
}

//rimuovo tutti i punti
function resetDot() {
    let allDot = document.querySelectorAll(".dot");
    for (let i = 0; i < allDot.length; i++) {
        allDot[i].remove();
    }
}


function setActive(n) {
    let allDot = document.querySelectorAll(".dot");
    for (let i = 0; i < allDot.length; i++) {
        allDot[i].classList.remove("active-dot")
    }

    allDot[n].classList.add("active-dot");
}

//!!!!!!in caso di resize della finestra i dot smettono di funzionare!!!!!!!!

//modifica lo spostamento cliccando sui dot
document.querySelectorAll('.dot').forEach(function (dot) {
    dot.addEventListener('click',

        function () {

            let wrapper = document.querySelector('#images');
            let left = parseInt(wrapper.getAttribute('data-left'));
            let sWidth = wrapper.clientWidth;

            let img = wrapper.querySelectorAll('.slide-img');;
            let imgWidth = img[0].clientWidth;

            let dotContainer = document.querySelector(".dot-container")
            let iter = dotContainer.getAttribute('data-iter');
            let allDot = document.querySelectorAll(".dot");

            let gravity = this.getAttribute('data-gravity');

            const IMGSTYLE = window.getComputedStyle(img[0], null);
            const PADDINGSTRING = IMGSTYLE.getPropertyValue("padding-right");
            const PADDING = parseInt(PADDINGSTRING.replace(/[^0-9.]/g, ""))

            if (gravity == 1) {
                left = 0;
                iter = 1;
                setActive(iter - 1);

            } else if (gravity == allDot.length) {

                while (left < (img.length * (imgWidth - PADDING)) - sWidth) {

                    left += parseInt(imgWidth);

                    if ((left / imgWidth) * imgWidth >=
                        (img.length * (imgWidth - PADDING) / allDot.length) * iter) {
                        iter++;
                    }

                    setActive(iter - 1);
                }

            } else {

                console.log((img.length / allDot.length) * (gravity - 1));

                left = 0;
                iter = 1;

                wrapper.style.transform = "translate(-" + left + "px ,0)"

                for (i = 0; i < (img.length / allDot.length) * (gravity - 1); i++) {

                    left += parseInt(imgWidth);

                    if ((left / imgWidth) * imgWidth >=
                        (img.length * (imgWidth - PADDING) / allDot.length) * iter) {
                        iter++;
                    }

                    setActive(iter - 1);
                }

            }

            wrapper.style.transform = "translate(-" + left + "px ,0)"
            wrapper.setAttribute('data-left', left)

            dotContainer.setAttribute('data-iter', iter)

        });
});



