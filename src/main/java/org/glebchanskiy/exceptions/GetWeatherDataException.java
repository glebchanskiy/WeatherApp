package org.glebchanskiy.exceptions;

public class GetWeatherDataException extends Exception {
	
	public GetWeatherDataException() {
		super();
	}
	
	public GetWeatherDataException(String message) {
		super(message);
	}
}
