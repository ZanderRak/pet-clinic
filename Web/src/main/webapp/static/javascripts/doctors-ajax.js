
(function() {

    var doctorsList = document.getElementsByClassName('doctors-list')[0];
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/pet-clinic/rest/employee', true);
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {

            var data = JSON.parse(xhr.responseText);
            var doctorsArr = data.employees;
            var template = document.getElementById("template-list-item");
            var templateHtml = template.innerHTML;
            var listHtml = "";

            for (var i = 0; i < doctorsArr.length; i++) {
                listHtml += templateHtml.replace(/{{img}}/g, doctorsArr[i]['imgLink'])
                    .replace(/{{name}}/g, doctorsArr[i]['name'])
                    .replace(/{{spec}}/g, doctorsArr[i]['specialization'])
                    .replace(/{{descr}}/g, doctorsArr[i]['description']);
            }
            doctorsList.innerHTML = listHtml;
        }
    };
    xhr.send();
}());




