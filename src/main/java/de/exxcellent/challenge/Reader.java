package de.exxcellent.challenge;

import java.io.FileReader;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;

public class Reader {
	
	//method for reading csv file and putting values in an arraylist of arraylist
	protected static ArrayList<ArrayList <String>> readCSVFile (String path) {
		//dec ArrayList of ArrayList
    	ArrayList<ArrayList<String>> arrArrVal = new ArrayList<ArrayList<String>>( );
			    	
	            try {
	            	//CSV reader
					@SuppressWarnings("resource")
					CSVReader reader = new CSVReader(new FileReader(path));
		            String[] line;
		            //check if line is empty
					while ((line = reader.readNext()) != null) {
						
						//add each column value to ArrayList
						ArrayList<String> arrVal = new ArrayList<String>( );
						
					    for (String colValue : line) {
					    	arrVal.add(colValue);
					    }
					    
					    //add ArrayList of column values to ArrayList 
					    arrArrVal.add(arrVal);
					}
				} catch (Exception e) {
					System.out.println("Error occured while getting and pushing CSV file values in ArrayList. ⁄n" + e.getMessage());
				}
		
		return arrArrVal;
	}
	
	// method for getting the day with smallest temperature spread
  public static String getMinSpreadTempDay (String path) {
		  	
	  		//ArrayList of ArrayList with values of csv file
	  		ArrayList<ArrayList <String>> arrDays = readCSVFile(path);
	    	
	    	//dec & init, init with first row values
	    	//index of needed information
	    	double maxTemp = 0;
	    	double minTemp = 0;
	    	double daySpread;
	        int indexDay = arrDays.get(0).indexOf("Day");
	        int indexMaxTemp = arrDays.get(0).indexOf("MxT");
	        int indexMinTemp = arrDays.get(0).indexOf("MnT");
	        String minSpreadDay = arrDays.get(1).get(indexDay);
	        double minSpread = Double.parseDouble(arrDays.get(1).get(indexMaxTemp))-Double.parseDouble(arrDays.get(1).get(indexMinTemp));

	        //loop for checking smallest temperature spread, excluding first row
	        for (ArrayList<String> dayVal : arrDays.subList(1, arrDays.size())) {
	        	
	        	//get max and min temperature and difference
	    		maxTemp = Double.parseDouble(dayVal.get(indexMaxTemp));
	    		minTemp = Double.parseDouble(dayVal.get(indexMinTemp));
	            daySpread = maxTemp-minTemp;
	            
	            //if spread of actual date is smaller than minimum spread before, replace and get day
	            if (daySpread < minSpread) {
	            	minSpread = daySpread;
	            	minSpreadDay = dayVal.get(indexDay);
	            }
	        	    
	        }
	        //return day
	        return minSpreadDay;
  }
		
  //method for getting the team with smallest distance between goals and allowed goals
    public static String getMinSpreadFootballTeam(String path) {
    	
  		//ArrayList of ArrayList with values of csv file
    	ArrayList<ArrayList <String>> arrTeams = readCSVFile(path);
    	
    	//dec & init, init with first row values
    	//index of needed information
    	int indexTeam = arrTeams.get(0).indexOf("Team");
    	String minSpreadTeam = arrTeams.get(0).get(indexTeam);
    	int indexGoals = arrTeams.get(0).indexOf("Goals");
    	int indexGoalsAllowed = arrTeams.get(0).indexOf("Goals Allowed");
    	
    	int minGoalsDiff;
      	int goals;
    	int goalsAllowed;
    	int goalsDiff;
    	
    	//init with first row values
    	//prevent negative values with math.abs    	
    	minGoalsDiff = Math.abs(Integer.parseInt(arrTeams.get(1).get(indexGoals)) - Integer.parseInt(arrTeams.get(1).get(indexGoalsAllowed)));

    	//loop for checking minimum spread difference, excluding first row
        for (ArrayList<String> teamVal : arrTeams.subList(1, arrTeams.size())) {
            
        	//check difference
        	goals = Integer.parseInt(teamVal.get(indexGoals));
        	goalsAllowed = Integer.parseInt(teamVal.get(indexGoalsAllowed));
        	goalsDiff = Math.abs(goals - goalsAllowed);
        	
        	// if difference of checked team is smaller, replace, get team name
        	if (goalsDiff < minGoalsDiff) {
        		minGoalsDiff = goalsDiff;
        		minSpreadTeam = teamVal.get(indexTeam);
        	}
        }
        //return team name     
        return minSpreadTeam;
    }
    
}
