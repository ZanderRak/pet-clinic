
 function id(id){
    return document.getElementById(id);
}
//***********RESPONSIVE MENU***********
//*************************************
var clickMenu = document.getElementsByClassName("hamburger-menu")[0];

clickMenu.addEventListener("click", function openAndHideMenu () {

    var items = document.getElementsByClassName('item');

    if (this.classList.contains("to-close-menu")) {

        for (var i = 0; i < items.length; i++) {
            items[i].classList.remove('item-to-hide');
        }

        this.classList.remove("to-close-menu");

    } else {

        for (i = 0; i < items.length; i++) {
            items[i].classList.add('item-to-hide');
        }

        this.classList.add("to-close-menu");
    }
});
//***********STICKY HEADER***********
//*********************************************
/*
var bottomHeader = document.getElementsByClassName('bottom-header')[0];
var sticky = bottomHeader.offsetTop;

window.addEventListener("scroll", function stickHeader() {

    if (window.pageYOffset >= sticky) {
        bottomHeader.classList.add("sticky");
    } else {
        bottomHeader.classList.remove('sticky');
    }
});
*/

//***********UP BUTTON***********
//*********************************************
var upButton = id('up-button');

window.addEventListener("scroll", function hideAndShowUpButton() {
    if(upButton) {
        if (window.pageYOffset > 500) {
            upButton.classList.add("show-up-button");
        }
        else {
            upButton.classList.remove("show-up-button");
        }
    }
});