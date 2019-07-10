$(function () {
    $("#selectCityName").change(function () {
        var cityName = this.value;
        // console.log(cityName)
        var url = "/report/cityName/"+cityName;
        window.location.href=url
    })
});