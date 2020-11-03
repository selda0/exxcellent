package de.exxcellent.challenge;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
	
	//resources path
    private static final String pathWeather = "src/main/resources/de/exxcellent/challenge/weather.csv";
    private static final String pathFootball = "src/main/resources/de/exxcellent/challenge/football.csv";

    
    public static void main(String... args) {
    	
    	
    	String outputWeather = Reader.getMinSpreadTempDay(pathWeather);
    	String outputFootball = Reader.getMinSpreadFootballTeam(pathFootball);
    	
    	System.out.println("Day with smallest temperature spread: " + outputWeather);
    	System.out.println("Team with smallest goal spread: " + outputFootball);
    	
    	
  	}
    
    
  
    
    
    
    
  
    
    
    
    
    
    
}

