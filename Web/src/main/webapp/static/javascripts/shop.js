(function() {
//**********DESCRIPTION OF THE PRODUCT*********

    var productsGrid = document.getElementsByClassName('products-grid')[0];
    var productDescriptions = document.getElementsByClassName('hidden-description');

    function showProductDescription(descriptionNode) {
        descriptionNode.classList.add('shown-description');
    }

    function hideProductDescription() {
        for (i = 0; i < productDescriptions.length; i++) {
            productDescriptions[i].classList.remove('shown-description');
        }
    }

//*******Event listener to show and hide description of the product*******
    productsGrid.addEventListener('mouseover',
        function productDescriptionEvent(event) {

            var target = event.target;
            if (productsGrid.querySelectorAll('shown-description')) {
                hideProductDescription();
            }
            while (target !== this) {    //bubbling
                if (target.tagName === 'LI') {
                    showProductDescription(target.lastElementChild);
                }
                target = target.parentNode;
            }
        });

}());