package com.sep.exceptions;

import java.util.Scanner;

class InvalidParcelWeightException extends Exception{
	public InvalidParcelWeightException(String message) {
		super(message);
	}
}
class ParcelWeightLimitException extends Exception{
	public ParcelWeightLimitException(String message) {
		super(message);
	}
}
class RailwayParcel{
	String senderName;
	String destination;
	double weight;
	double maxWeight = 50;
	
	
	void validateInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the sender: ");
		senderName = sc.nextLine();
		
		System.out.println("Enter the destination: ");
		destination = sc.nextLine();
		
		
		System.out.println("Enter the weight of the product: ");
		weight = sc.nextDouble();
		sc.nextLine();
		
	}
	
	void validateWeight() throws InvalidParcelWeightException{
		if(weight <=0) {
			throw new InvalidParcelWeightException("InvalidParcelWeightException: Parcel weight must be greater than zero.");
		}
	}
	
	void validateWeightLimit() throws ParcelWeightLimitException{
		if(weight > maxWeight) {
			throw new ParcelWeightLimitException("ParcelWeightLimitException: Parcel weight cannot exceed 50 kg.");
		}
	}
	
	void bookParcel() {
		System.out.println("Parcel booked successfully!");
		System.out.println("Sender: "+ senderName);
		System.out.println("Destination: "+ destination);
		System.out.println("Weight: "+ weight);
	}
}
class Parcel{
	void service() {
		RailwayParcel rw = new RailwayParcel();
		try {
			rw.validateInput();
			rw.validateWeight();
			rw.validateWeightLimit();
			rw.bookParcel();
		}catch(InvalidParcelWeightException | ParcelWeightLimitException ipe) {
			System.out.println(ipe.getMessage());
		}
	}
	
}
public class Scenario10 {

	public static void main(String[] args) {
		Parcel p = new Parcel();
		p.service();
	}

}
