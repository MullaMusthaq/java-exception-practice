package com.sep.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

class ATM{
	
	void acceptInput() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Withdraw amount: ");
			int p = sc.nextInt();
			System.out.println("Withdrawal amount: "+p);
			System.out.println("Processing withdrawal...");
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid amount. Please enter a valid number.");
		}
	}
}
public class ATMProcess {

	public static void main(String[] args) {
		ATM atm = new ATM();
	    atm.acceptInput();

	}

}
