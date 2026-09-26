package com.sep.exceptions;

import java.util.Scanner;
class InvalidAgeException extends Exception{
	
}
class NoDriverAvailableException extends Exception{
	
}
class Rapido{
	String passengerName;
    int age;
    String pickUpLocation;
    String dropLocation;
    int availableDriverCount = 5;
    int rideDistanceKm;
    
    void acceptInput() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the Name of the passenger: ");
    	passengerName = sc.next();
    	System.out.println("Enter the age of passenger: ");
    	age = sc.nextInt();
    	System.out.println("Enter the pickup location: ");
    	pickUpLocation = sc.next();
    	System.out.println("Enter the drop location: ");
    	dropLocation = sc.next();
    	System.out.println("Enter the ride distance: ");
    	rideDistanceKm = sc.nextInt();
    }
    
    void validateAge() throws InvalidAgeException{
    	if(age < 18) {
    		InvalidAgeException ia = new InvalidAgeException();
    		throw ia;
    	}
    }
    void validateDriver() throws NoDriverAvailableException{
    	if(rideDistanceKm > 0 && rideDistanceKm < 100) {
    		System.out.println("available drivers: "+ availableDriverCount);
    	}else if(rideDistanceKm >=100) {
    		availableDriverCount =0;
    		System.out.println("Available Drivers: "+availableDriverCount);
    		NoDriverAvailableException nd = new NoDriverAvailableException();
    		throw nd;
    	}
    }
}
class MiniCab{
	Rapido r = new Rapido();
	void Journey() {
		
		try {
			r.acceptInput();
			try {
				r.validateAge();
			}catch(InvalidAgeException a) {
				System.out.println("Passenger age must be 18 or above. Ride cannot be booked!!");
			}
			
			try {
				r.validateDriver();
			}catch(NoDriverAvailableException b) {
				System.out.println("No driver available. please try again later!!");
			}
			if(r.age>=18 && r.availableDriverCount >0) {
	    		System.out.println("Passenger: "+ r.passengerName);
	    		System.out.println("age: "+ r.age);
	    		System.out.println("Pickup: "+r.pickUpLocation);
	    		System.out.println("Drop: "+r.dropLocation);
	    		System.out.println("Ride distance: "+ r.rideDistanceKm);
	    		System.out.println("Driver assigned successfully");
	    		System.out.println("Ride booked sucessfully");
	    	}
		}catch(Exception e) {
			System.out.println("Problem");
		}
	}
}
public class Scenario6CabBooking {

	public static void main(String[] args) {
     MiniCab mc = new MiniCab();
     mc.Journey();
	}

}
