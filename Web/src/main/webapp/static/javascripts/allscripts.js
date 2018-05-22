//************hamburger menu****************************
//*********************************************
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


//***********REGISTRATION/LOGIN FORM***********
//*********************************************
var registrationForm = document.getElementById('pop-up-registration-form');
var loginForm = document.getElementById('pop-up-login-form');
var closeRegistrationButton = document.getElementById('close-registration-button');
var closeLoginButton = document.getElementById('close-login-button');
var signUpButton = document.getElementById('sign-up-button');
var logInButton = document.getElementById('log-in-button');

//functions
function showRegistrationForm() {
    registrationForm.classList.toggle('shown');
}

function showLoginForm() {
    loginForm.classList.toggle('shown');
}


//**********hide registration form**********
closeRegistrationButton.addEventListener("click", showRegistrationForm);

//*********show registration form********************
signUpButton.addEventListener('click', showRegistrationForm);

//***********hide login form***********
closeLoginButton.addEventListener("click", showLoginForm);

//*********show login form********************
logInButton.addEventListener("click", showLoginForm);



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
var upButton = document.getElementById('up-button');

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


//upButton.addEventListener("click", function toScrollUp() {
//
//});