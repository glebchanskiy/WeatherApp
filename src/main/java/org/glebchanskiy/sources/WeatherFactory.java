package org.glebchanskiy.sources;

import org.glebchanskiy.exceptions.GetWeatherDataException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class WeatherFactory {

    private static final String APIkey = "0000000000000000000000000";

    private WeatherFactory() {}

    public static Weather getWeather(Coordinates coordinates) throws GetWeatherDataException {
        Weather weather = null;

        try {
            String url = buildURL(coordinates);
            weather = getWeatherData(url);
        } catch (ResourceAccessException e) {
            throw new GetWeatherDataException();
        }

        return weather;
    }

    private static String buildURL(Coordinates coord) {

        double lat = coord.getLatitude();
        double lon = coord.getLongitude();

        String lang = "ru";

        Part part = Part.alerts;
        Units units = Units.metric;

        String URL_base = "https://api.openweathermap.org/data/2.5/weather?";
        String URL_cord = "lat=" + lat + "&lon=" + lon;
        String URL_exclude = "exclude=" + part.name();
        String URL_APIkey = "appid=" + APIkey;
        String URL_lang = "lang=" + lang;
        String URL_units = "units=" + units.name();

        char sep = '&'; // разделитель атрибутов

        return URL_base +
                URL_cord +
                sep + URL_exclude +
                sep + URL_units +
                sep + URL_lang +
                sep + URL_APIkey;
    }

    private static Weather getWeatherData(String apiURL) throws ResourceAccessException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiURL, Weather.class);
    }

}

enum Part {
    current, minutely, hourly, daily, alerts
}

enum Units {
    standard, metric, imperial
}