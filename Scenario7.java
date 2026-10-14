package com.sep.exceptions;

import java.util.Scanner;
class InvalidAgeException1 extends Exception{
	
}
class SeatsNotAvailableException extends Exception{
	
}
class Trainbooking{
	String passengerName;
	int age;
	String trainName;
	int requestedSeats;
	int availableSeats = 10;
	
	void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the passenger name: ");
		passengerName = sc.next();
		System.out.println("Enter the passenger age: ");
		age = sc.nextInt();
		System.out.println("Enter the name of the train: ");
		trainName = sc.next();
		System.out.println("Enter the number of seats you want to book: ");
		requestedSeats = sc.nextInt();
	}
	
	void validateAge() throws InvalidAgeException1{
	    if(age < 5) {
	      InvalidAgeException1 ia = new InvalidAgeException1();
	      throw ia;
	    }
	}
	void checkSeats() throws SeatsNotAvailableException {
		if(requestedSeats > availableSeats) {
			SeatsNotAvailableException sa = new SeatsNotAvailableException();
			throw sa;
		}
	}
}
class TrainTicket{
	Trainbooking tb = new Trainbooking();
    void controlBooking() {
    	tb.acceptInput();
    	try {
    		try {
    			tb.validateAge();
    		}catch(InvalidAgeException1 ia) {
    			System.out.println("Booking failed: Passenger age must be at least 5.");
    			throw ia;
    		}
        	try {
        		tb.checkSeats();
        	}catch(SeatsNotAvailableException sa) {
        		System.out.println("Booking failed: Requested seats are not available.");
        		throw sa;
        	}
        	if(tb.age >= 5 && tb.requestedSeats <= tb.availableSeats) {
        		System.out.println("Ticket booked Succesfully!");
        		System.out.println("Passenger: "+ tb.passengerName);
        		System.out.println("Train: "+ tb.trainName);
        		System.out.println("Seats booked: "+ tb.requestedSeats);
        	}
    	}catch(Exception e) {
    		System.out.println("Problem");
    	}
    
    }
	
}
public class Scenario7 {

	public static void main(String[] args) {
		TrainTicket tt = new TrainTicket();
		tt.controlBooking();
		
	}

}












