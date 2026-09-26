package com.sep.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;
class Alert extends Exception{
	
}
class BankAccount{
	int availableBanlace = 25000;
	int amount;
	void withdraw() throws Exception{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the withdraw amount: ");
			amount = sc.nextInt();
			if(amount <= availableBanlace) {
		     availableBanlace = availableBanlace - amount;
		     System.out.println("Withdraw sucessfull");
		     System.out.println("Reamaining balance: "+availableBanlace);
			}else {
				Alert a = new Alert();
				throw a;
			}
	}
}
public class AmountWithdraw {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		try {
			ba.withdraw();
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter the valid input!!");
		}
		catch(Exception e) {
			System.out.println("Insufficient balance. Withdrawal cannot be completed.");
		}
	}

}
