package org.glebchanskiy.sources;

import java.util.List;

// Этот класс отображает json below

//{
//  "coord": {
//    "lon": -122.08,
//    "lat": 37.39
//  },
//  "weather": [
//    {
//      "id": 800,
//      "main": "Clear",
//      "description": "clear sky",
//      "icon": "01d"
//    }
//  ],
//  "base": "stations",
//  "main": {
//    "temp": 282.55,
//    "feels_like": 281.86,
//    "temp_min": 280.37,
//    "temp_max": 284.26,
//    "pressure": 1023,
//    "humidity": 100
//  },
//  "visibility": 10000,
//  "wind": {
//    "speed": 1.5,
//    "deg": 350
//  },
//  "clouds": {
//    "all": 1
//  },
//  "dt": 1560350645,
//  "sys": {
//    "type": 1,
//    "id": 5122,
//    "message": 0.0139,
//    "country": "US",
//    "sunrise": 1560343627,
//    "sunset": 1560396563
//  },
//  "timezone": -25200,
//  "id": 420006353,
//  "name": "Mountain View",
//  "cod": 200
//  }

public class Weather {

	private List<WeatherData> weather;
	private Main main;
	private int visibility;
	private Wind wind;

	public List<WeatherData> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherData> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "Сейчас " + this.weather.get(0).getDescription() + "\n" +
				"Температура  " + this.main.getTemp() + "°C, ощущается как " + this.main.getFeels_like() + "°C\n" +
				"Влажность " + this.main.getHumidity() + "%\n" +
				"Давление " + this.main.getPressure() + " мм рт.ст.\n" +
				"Ветер " + sideOfTheWorldByDegree(this.wind.getDeg()) + ", " + this.wind.getSpeed() + " м/с \n" +
				"Видимость " + visibility + " м.";
	}

	private static String sideOfTheWorldByDegree(Long degree) {
		if (degree >= 337.5 && degree < 22.5)
			return "северный";
		else if (degree >= 22.5 && degree < 67.5)
			return "северо-восточный";
		else if (degree >= 67.5 && degree < 112.5)
			return "восточный";
		else if (degree >= 112.5 && degree < 157.5)
			return "юго-восточный";
		else if (degree >= 157.5 && degree < 202.5)
			return "южный";
		else if (degree >= 202.5 && degree < 247.5)
			return "юго-западный";
		else if (degree >= 247.5 && degree < 295.5)
			return "западный";
		else if (degree >= 292.5 && degree < 337.5)
			return "северо-западный";
		else
			return "северный";
	}
}

class Main {
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private double pressure;
	private double humidity;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Main{" +
				"temp=" + temp +
				", feels_like=" + feels_like +
				", temp_min=" + temp_min +
				", temp_max=" + temp_max +
				", pressure=" + pressure +
				", humidity=" + humidity +
				'}';
	}
}

class WeatherData {
	private Long id;
	private String main;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "WeatherData{" +
				"id=" + id +
				", main='" + main + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}

class Wind {
	private Long deg;
	private double speed;

	public Long getDeg() {
		return deg;
	}

	public void setDeg(Long deg) {
		this.deg = deg;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Wind{" +
				"deg=" + deg +
				", speed=" + speed +
				'}';
	}
}