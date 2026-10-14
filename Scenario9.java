package com.sep.exceptions;

import java.util.Scanner;

class InvalidPatientAgeException extends Exception{
	public InvalidPatientAgeException(String message) {
		super(message);
	}
}
class NoAppointmentSlotsException extends Exception{
	public NoAppointmentSlotsException(String message) {
		super(message);
	}
}

class Patient{
	String patientName;
	int patientAge;
	String doctorName;
	int availableSlots = 5;
	int bookedSlots;
	
	
	void acceptInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the Patient: ");
		patientName = sc.nextLine();
		
		
		System.out.println("Enter the age of the patient: ");
		patientAge = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Name of the Doctor: ");
		doctorName = sc.nextLine();
	 
		
		System.out.println("How many slots you want to book: ");
		bookedSlots = sc.nextInt();
	}
	
	void validateAge() throws InvalidPatientAgeException{
		if(patientAge < 1) {
			InvalidPatientAgeException ipa = new InvalidPatientAgeException("InvalidPatientAgeException: Patient age must be at least 1.");
			throw ipa;
		}
	}
	
	
	void checkAppintmentSlots() throws NoAppointmentSlotsException{
		
		if(bookedSlots<=0) {
			throw new NoAppointmentSlotsException("You must book at least one slot.");
		}
		if(availableSlots == 0) {
			throw new NoAppointmentSlotsException("No appointment slots are available.");
		}
		if(bookedSlots>availableSlots) {
			throw new NoAppointmentSlotsException("Requested slots exceed available slots.");
		}
	}
	void displayAppointmentStatus() {
		availableSlots=availableSlots-bookedSlots;
		System.out.println("Appointment booked Succesfully!!");
		System.out.println("Patient: "+ patientName);
		System.out.println("Doctor: "+ doctorName);
		System.out.println("Booked slots: "+ bookedSlots);
	    System.out.println("Remaining slots: "+ availableSlots);
	}
}
class HospitalAppointment{
	void Appointment() {
		Patient p = new Patient();
		try {
			p.acceptInput();
			p.validateAge();
			p.checkAppintmentSlots();
	        p.displayAppointmentStatus();
		}catch(InvalidPatientAgeException | NoAppointmentSlotsException ine) {
			  System.out.println("Booking Failed: "+ ine.getMessage());
		}
	}
}
public class Scenario9 {

	public static void main(String[] args) {
		HospitalAppointment ha = new HospitalAppointment();
		ha.Appointment();

	}

}
