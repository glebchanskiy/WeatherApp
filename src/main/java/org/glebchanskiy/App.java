package org.glebchanskiy;

import org.glebchanskiy.exceptions.GetCoordinatesException;
import org.glebchanskiy.exceptions.GetWeatherDataException;
import org.glebchanskiy.sources.Coordinates;
import org.glebchanskiy.sources.Weather;
import org.glebchanskiy.sources.WeatherFactory;


public class App {

    public static void main(String[] args) {

        try {
            Coordinates coordinates = Coordinates.getCoordinates();
            Weather weather = WeatherFactory.getWeather(coordinates);
            System.out.println(weather);
        } catch (GetCoordinatesException e) {
            System.out.println("Невозможно получить GPS координаты.");
        } catch (GetWeatherDataException e) {
            System.out.println("Невозможно получить данные о погоде.");
        }
    }
}

