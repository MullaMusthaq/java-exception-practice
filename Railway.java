package com.sep.exceptions;

import java.util.Scanner;


class InvalidAgeException extends Exception{
	
}

class NoSeatsAvailableException extends Exception{
	
}

class RailwayBooking{
    String passengerName;
	int passengerAge;
	int seatsAvailabe = 5;
	int passengerSeatsReq;
	
	void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter passenger Name: ");
		passengerName = sc.next();
		System.out.println("Enter passenger age:");
		passengerAge = sc.nextInt();
		System.out.println("Enter the seats request:");
	    passengerSeatsReq = sc.nextInt();
	}
	
	
	void validateAge() throws InvalidAgeException{
		if(passengerAge < 18) {
			InvalidAgeException ia = new InvalidAgeException();
			throw ia;
		}
	}
	
	void validateSeat() throws NoSeatsAvailableException{
		if(passengerSeatsReq > seatsAvailabe){
			NoSeatsAvailableException na = new NoSeatsAvailableException();
			throw na;
		}
	}
	
	void bookTicket() {
		System.out.println("Passenger: " + passengerName);
		System.out.println("Age: " + passengerAge);
		System.out.println("Seats booked: "+ passengerSeatsReq);
		System.out.println("Ticket booking successful.");
		System.out.println("Remaining seats: " +(seatsAvailabe- passengerSeatsReq));
	}
}
  

class Rail{
	void check() {
		RailwayBooking rb = new RailwayBooking();
		try 
		{
			rb.acceptInput();
			try
			{
				rb.validateAge();
			}catch(InvalidAgeException e)
			{
				System.out.println("Invalid age. Passenger must be 18 or above.");
			}
			try 
			{
		          rb.validateSeat();
			}
			catch(NoSeatsAvailableException e)
			{
				System.out.println("No seats available. Please select fewer seats.");
			}	
			
			if(rb.passengerAge >= 18 && rb.passengerSeatsReq <= rb.seatsAvailabe){
				rb.bookTicket();
			}
			
			
	    }finally {
	    	System.out.println("Booking process completed.");
	    }
   }
}
public class Railway {

	public static void main(String[] args) {
		Rail r = new Rail();
		r.check();
	}

}
