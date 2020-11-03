package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {
    
    @Test 
    void testFootballOutput() {
    	String pathFootball = "src/main/resources/de/exxcellent/challenge/football.csv";
    	String result = Reader.getMinSpreadFootballTeam(pathFootball);
    	String expected = "Aston_Villa";
    	assertEquals(expected, result);
    }
    
    
    @Test 
    void testWeatherOutput() {
    	String pathWeather = "src/main/resources/de/exxcellent/challenge/weather.csv";
    	String result = Reader.getMinSpreadTempDay(pathWeather);
    	String expected = "14";
    	assertEquals(expected, result);
    }
    
    @Test
    void testReadCSVFile() {
    	final String pathWeather = "src/main/resources/de/exxcellent/challenge/weather.csv";
    	assertDoesNotThrow(new Executable() {
			public void execute() throws Throwable {
				Reader.readCSVFile(pathWeather);
			}
		});
    }


}