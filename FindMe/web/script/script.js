/**
 * Created by apavliuchenkova on 07/11/2016.
 */
var arr;
var xmlhttp = new XMLHttpRequest();
var countriesCitiesUrl = "files/countriesCities.json";

xmlhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        arr = JSON.parse(this.responseText);
        setCountrySelect();
    }
}

xmlhttp.open("GET", countriesCitiesUrl, true);
xmlhttp.send();


$(document).ready(function() {
    $("#country").attr("onchange","setCitySelect(this.selectedIndex)");
    $("#country").load(setCountrySelect());
    $(function() {
        $( "#dateOfBirth" ).datepicker();
    });
    $(".submit").submit("validateRequiredFormElements();");
});

function setCountrySelect() {
    var i;
    var countryList = "<table>";

    countryList += "<option></option>";

    for(i = 0; i < arr.length; i++) {
        countryList += "<option value='"+arr[i].countryId+"'>" +
            arr[i].countryName +
            "</option>";
    }
    countryList += "</table>";
    document.getElementById("country").innerHTML = countryList;
}

function setCitySelect(countryId) {
    if(countryId!=0) {
        document.getElementById("city").disabled = false;
        var i;
        var cityArray = arr[countryId-1].cityList;
        var cityList = "<table>";

        cityList += "<option></option>";

        for(i = 0; i < cityArray.length; i++) {
            cityList += "<option value='"+cityArray[i].cityId+"'>" +
                cityArray[i].cityName +
                "</option>";
        }
        cityList += "</table>";
        document.getElementById("city").innerHTML = cityList;
    } else {
        document.getElementById("city").disabled = true;
        document.getElementById("city").innerHTML = "";
    }
};

function validateRequiredFormElements(){
    var x = document.getElementById("registerForm");
    var txt = "";
    var i;
    for (i=0;i<x.length;i++){
        if(!x.elements[i].value&&x.elements[i].required==true){
            alert(x.elements[i].name+" is empty");
            event.preventDefault();
        }
    }
};