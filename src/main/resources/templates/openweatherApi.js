var api = 'https://api.openweathermap.org/data/2.5/weather?q=';
var apiKey = '&APPID=001b0f58045147663b1ea518d34d88b4';
var units = '&units=metric';

var input;

function setup() {
    createCanvas(400, 200);

    var button = select('#submit');
    button.mousePressed(weatherAsk);

    input = select('#city');
}

function weatherAsk() {
    var url = api + input.value() + apiKey + units;
    loadJSON(url, gotData);
}

function gotData(data) {
    var weather = data;
    draw(weather);

}

function draw(weather) {
    if (weather) {
        var temp = weather.main.temp;
        var minTemp = weather.main.temp_min;
        var maxTemp = weather.main.temp_max;
        var humidity = weather.main.pressure;
        document.writeln("Temp:" + temp + " deg;\n Humidity: " + humidity + "%; Min-Temp: " + minTemp + " degrees, Max-Temp: " + maxTemp + " deg;");

    }


}