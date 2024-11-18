package com.example.temperature_converter.Utils;

public class Converters {

    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = 0.0;
        fahrenheit = (celsius * (9.0/5.0)) +32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32) * (5/9.0);
    }
}
