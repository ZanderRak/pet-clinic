(function() {

    function id(id) {
        return document.getElementById(id);
    }

    var firstName = id('firstName');
    var lastName = id('lastName');
    var birthday = id('birthday');
    var email = id('email');
    var phone = id('phone');
    var password = id('password');
    var repitedPassword = id('repitedPassword');
    var hint;

    var inputsArray = [firstName, lastName, birthday, email,
        phone, password, repitedPassword];
//***************************************************
//******************VALIDATION***********************
    function takeHint(field) {
        hint = field.nextElementSibling;
        return hint;
    }

    function hideHint(input) {
        hint = takeHint(input);
        input.classList.remove("invalid-input");
        hint.classList.remove("show-invalid-hint");
    }

    function validate(input, regExpr, message) {
        hint = takeHint(input);
        if (input.value.match(regExpr)) {
            return;
        } else if (!input.value) {
            input.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = "Please, fill the field above.";
        } else {
            input.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = message;
        }
    }

//*********FIRSTNAME VALIDATION*********
    firstName.addEventListener("blur", function () {

        var errorMessage = "The field must contains from 2 to 30 letters.";
        validate(this, /^[a-zA-Z]{2,30}$/i, errorMessage);
    });

//*********LASTNAME VALIDATION*********
    lastName.addEventListener("blur", function () {

        var errorMessage = "The field must contains from 2 to 30 letters.";
        validate(this, /^([a-zA-Z]{1,14}['`-]?[a-zA-Z]{1,15})$/i, errorMessage);
    });

//*********BIRTHDAY (NOT REQUIRED) VALIDATION*********
    birthday.addEventListener("blur", function () {
        var now = +new Date();
        var userDate = +new Date(birthday.value);
        hint = takeHint(this);

        if ((now - userDate) < 0) {
            this.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = "Are you from the future?";
        } else {
            this.classList.remove("invalid-input");
            hint.classList.remove("show-invalid-hint");
        }
    });

//*********EMAIL VALIDATION*********
    email.addEventListener("blur", function () {
        var errorMessage = "Invalid email";
        validate(this, /^(\w+\.?\w*)+\w+@[A-Za-z]+\.\w+$/i, errorMessage);
    });

//*********PHONE (NOT REQUIRED) VALIDATION*********
    phone.addEventListener("blur", function () {
        hint = takeHint(this);
        if (this.value.match(/^\+\d{10,12}$/i) || !this.value) {
            this.classList.remove("invalid-input");
            hint.classList.remove("show-invalid-hint");
        } else {
            this.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = "This field must contains + and from 10 to 12 digits.";
        }
    });

//*********PASSWORD VALIDATION*********
    password.addEventListener("blur", function () {
        var errorMessage = "Min 8 characters and at least 1 uppercase and 1 lowercase letters, 1 digit.";

        hint = takeHint(this);
        if (this.value.match(/.{8,30}/) &&
            this.value.match(/[A-Z]+/) &&
            this.value.match(/[a-z]+/) &&
            this.value.match(/\d+/)) {
            return;
        } else if (!this.value) {
            this.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = "Please, fill the field above.";
        } else {
            this.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = errorMessage;
        }
    });

//*********PASSWORD AGAIN VALIDATION*********
    repitedPassword.addEventListener("blur", function () {
        if (!this.value) {
            this.classList.add("invalid-input");
            hint.classList.add("show-invalid-hint");
            hint.innerHTML = "Please, fill the field above.";
        }
    });

//***************************************************
//*********HIDE HINT ON FOCUS IN EACH INPUT*********

    for (var i = 0; i < inputsArray.length; i++) {
        inputsArray[i].addEventListener("focus", function() {
            hideHint(this);
        });
    }
//*************************************************
//****************REGISTRATION REQUEST********************
    var submitRegistrationButton = id('submit-registration-button');
    var onsubmitHint = id('onsubmit-hint');

    //registration request
    submitRegistrationButton.addEventListener("click", function sendRegistrationRequest() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/pet-clinic/rest/sigh-up", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("Accept", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState !== 4) return;
            if (xhr.readyState === 4 && xhr.status === 201) {
                //var headers = toString(xhr.getResponseHeader("Location"));
                //console.log(headers);
                alert(xhr.status);
                showPopUp();
                setTimeout(hidePopUp, 3000);
                document.location.href = "index.html";
            }
        };
        var signUpData = {
            "firstName": firstName.value,
            "lastName": lastName.value,
            "birthday": birthday.value,
            "email": email.value,
            "phone": phone.value,
            "password": password.value,
            "repitedPassword": repitedPassword.value
        };
        //******check if passwords mach******
        if (password.value !== repitedPassword.value) {
            onsubmitHint.innerHTML = "Passwords do not much.";
            password.focus();
            return;
        }
        //*****check if all of required fields are filled*****
        for (var i = 0; i < inputsArray.length; i++) {
            inputsArray[i].focus();
        }
         if (document.getElementsByClassName('show-invalid-hint')[0]) {

            onsubmitHint.innerHTML = "Please, fill required fields.";
            // birthday.value = "";
            // hideHint(birthday);
            // phone.value = "";
            // hideHint(phone);
             return;
         }
        xhr.send(JSON.stringify(signUpData));
    });

//*************************************************
//****************SHOW POPUP MESSAGE********************
    var popUp = id('pop-up-section');
    var popUpMessage = id('message');
    var registrationForm = id('registration-form');
    var closePopUpButton = id('close-popup-button');

    function showPopUp() {
        registrationForm.classList.toggle('hidden');
        popUp.classList.toggle('hidden');
        popUpMessage.innerHTML = "<p>Success!!!</p>";
    }

    function hidePopUp() {
        popUp.classList.toggle('hidden');
    }

//*********hide popup on click button***********
    closePopUpButton.addEventListener("click", function hidePopUpByClick() {
        popUp.classList.toggle('hidden');
    });

}());