(function() {

//******SHOW AND HIDE SERVICES DESCRIPTIONS******

    var servicesWrap = document.getElementsByClassName('services')[0];
    servicesWrap.addEventListener('click', function () {

        var target = event.target;
        var description = target.nextElementSibling;

        if (target.tagName === "BUTTON") {
            target.classList.toggle('active-service');
            description.classList.toggle('shown');
        }
    });

}());