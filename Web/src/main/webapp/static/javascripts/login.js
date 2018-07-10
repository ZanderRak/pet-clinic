(function() {

    function id(id) {
        return document.getElementById(id);
    }

    var loginEmail = id('login-email');
    var loginPassword = id('login-password');
    var loginHint = id('login-hint');

//***************************************************
//******************VALIDATION***********************



//*************************************************
// ****************LOGIN REQUEST*******************
    function login() {
        var buttons = id('registration-buttons');
        var user = id('user');
        buttons.classList.toggle('hidden');
        user.classList.toggle('shown');
        user.childNodes[1].innerHTML = "John Smith";
    }

//login request !!!! MUST BE ADDED RESPONSE STATUS
    var submitLoginButton = id('submit-login-button');
    submitLoginButton.addEventListener('click', function sendLoginRequest() {

        var xhr2 = new XMLHttpRequest();
        xhr2.open("POST", "http://localhost:8080/pet-clinic/rest/log-in", true);
        xhr2.setRequestHeader("Content-Type", "application/json");
        xhr2.onreadystatechange = function () {
            if (xhr2.readyState === 4) {
                popUpLoginForm.classList.toggle('hidden');
                alert(xhr2.status);
                login();
            }
        };
        var loginData = {
            "login": loginEmail.value,
            "password": loginPassword.value
        };

        if (!loginEmail.value || !loginPassword.value) {
            loginHint.innerHTML = "Please, fill fields above";
            return;
        }

        xhr2.send(JSON.stringify(loginData));
    });

//***********SHOW/HIDE LOGIN POPUP FORM***********
//*********************************************
//pop-ups (not forms, wrappers)
//var popUpRegistrationForm = id('pop-up-registration-section');
    var popUpLoginForm = id('pop-up-login-section');

//close buttons
//var closeRegistrationButton = id('close-registration-button');
    var closeLoginButton = id('close-login-button');

//signup/login buttons
//var signUpButton = id('sign-up-button');
    var logInButton = id('log-in-button');

//functions
//function showRegistrationForm() {
//    popUpRegistrationForm.classList.toggle('shown');
//}
    function showLoginForm() {
        popUpLoginForm.classList.toggle('shown');
    }

//**********hide registration form**********
//closeRegistrationButton.addEventListener("click", showRegistrationForm);

//*********show registration form********************
//signUpButton.addEventListener('click', showRegistrationForm);

//***********hide login form***********
    closeLoginButton.addEventListener("click", showLoginForm);

//*********show login form********************
    logInButton.addEventListener("click", showLoginForm);


}());