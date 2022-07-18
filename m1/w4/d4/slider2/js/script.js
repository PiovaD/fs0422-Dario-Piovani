/*let rigthArrow = document.querySelector('.control-right');

rigthArrow.addEventListener('click', moveLeft);

document.addEventListener('keyup', function(event){

    if(event.key == 'ArrowRight'){
        moveLeft();
    }

})*/

let sliders = document.querySelectorAll('.slider')

sliders.forEach(function(slider){
   let leftArrow = slider.querySelector('.control-left');
   let rightArrow = slider.querySelector('.control-right');

   rightArrow.addEventListener('click', function(){moveLeft(slider);});
})


function moveLeft (slider){
    let left =parseInt( slider.getAttribute('data-left'));

    let allSlides = slider.querySelectorAll('.slider .wrapper img');
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = slider.clientWidth;
    let space = Math.trunc(sliderWidth / firstSlideWidth) * firstSlideWidth; 
    
    let wrapper = slider.querySelector('.slider .wrapper');
   
    if(left < allSlides.length * firstSlideWidth  - space){

        left+=space;

    }else{

        left = 0;

    }

    wrapper.style.marginLeft = - left +'px';
    slider.setAttribute('data-left', left);

}