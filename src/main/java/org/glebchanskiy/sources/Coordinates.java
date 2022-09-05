package org.glebchanskiy.sources;

import org.glebchanskiy.exceptions.GetCoordinatesException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Coordinates {

	private double latitude;
	private double longitude;

	Coordinates() throws GetCoordinatesException {
		try {
			parseCoordinates();
		} catch (IOException e) {
			throw new GetCoordinatesException();
		}
	}

	private void parseCoordinates() throws IOException {
		Process process = (new ProcessBuilder("whereami")).start();

		try (
			 InputStream inputStream = process.getInputStream();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				) {

			/*
			 * консольная утилита whereami выводит на консоль строки в формате:
			 *
			 * Latitude: 53.927079
			 * Longitude: 27.565452
			 * Accuracy (m): 35.000000
			 * Timestamp: 23.06.22, 13:35:42 GMT+3
			 *
			 * мы получаем Latitude из второй части первой строки и
			 * Longitude из второй части второй строки
			 */

			latitude = Double.parseDouble(reader.readLine().split(" ")[1]);
			longitude = Double.parseDouble(reader.readLine().split(" ")[1]);

		}
		catch (NumberFormatException | IOException e) {
			throw new IOException();
		}

	}

	public static Coordinates getCoordinates() throws GetCoordinatesException {
		return (new Coordinates());
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "[latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
