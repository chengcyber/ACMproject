import acm.program.*;
import java.util.*;
import java.io.*;



public class FlightPlanner extends ConsoleProgram {

	public void run() {
		
		println("This Program help you to make a flight plan.");
		println("Let's plan a round-trip route!");
		
		loadFlight();
		// list all cities name
		listAllCity();
		
		while(true) {
			String cityInput = readLine("Please enter the next city: ");
			
			// route city finish
			if(cities.contains(cityInput)) break;
			
			// check city name correct
			if(flights.containsKey(cityInput)) {
				
				cities.add(cityInput);
				listArrivalOf(cityInput);
				
				
			} else {
				println("Invaild city name.Please check out.");
			}
			
		}
		
		showPlan();
	}
	
	/* show the final route-trip */
	private void showPlan() {
		println("The route is ");
		for(String s : cities) {
			println(s + " -> ");
		}
	}
	
	/* list all the city name */
	private void listAllCity() {
		
		for(String cityName : flights.keySet()) {
			println(cityName);
		}
	}
	
	/* load flight.txt store to hash map flights */
	private void loadFlight() {
		try {
			BufferedReader rd = new BufferedReader(
					new FileReader("flights.txt"));
			while(true) {
				String line = rd.readLine();
				if ( line == null ) break;
				readData(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	/* read Data from text file line. */
	private void readData(String line) {
		// get cityFrom , cityTo.
		int cityFromEnd = line.indexOf(" -> ");
		int cityToStart = cityFromEnd + 4;
		String cityFrom = line.substring(0, cityFromEnd);
		String cityTo = line.substring(cityToStart);
		
		// add to hash map flights
		
		
		if (!temp.contains(cityFrom)) {
			flights.put(cityFrom, new ArrayList<String>());
			temp.add(cityFrom);
		}
		flights.get(cityFrom).add(cityTo);
		
	}
	
	
	/* list the avaiable city of the cityFrom */
	private void listArrivalOf(String city) {
		ArrayList<String> cityTo = flights.get(city);
//		println("" + cityTo.isEmpty());
		println("From " + city + " you can fly directly to :");
		for(int i = 0; i < cityTo.size(); i++ ) {
			println(cityTo.get(i) + " ");
		}
	}
	
	/* private instance variables */
	private HashMap<String, ArrayList<String>> flights = new HashMap<String, ArrayList<String>>(); 
	private ArrayList<String> cities = new ArrayList<String>(); // cities in route.
	private ArrayList<String> temp = new ArrayList<String>();   // temp to compare whether add to hashmap flights
//	private String lastCity;
}



