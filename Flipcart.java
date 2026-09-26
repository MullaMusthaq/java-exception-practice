package com.sep.exceptions;

import java.util.Scanner;

class InsufficientBalanceException extends Exception{
	
}

class BankAccount1{
	int bankBalance = 10000;
	int withdrawAmount;
	void withdraw() throws InsufficientBalanceException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the withdraw amount: ");
		withdrawAmount = sc.nextInt();
		if(withdrawAmount <= bankBalance) {
			System.out.println("Withdrawal successful.");
			System.out.println("Remaining balance: "+ (bankBalance-withdrawAmount));
		}else {
			InsufficientBalanceException ib = new InsufficientBalanceException();
			throw ib;
		}
	}
}
class OnlinePaymetn{
	void start1() {
		BankAccount1 b = new BankAccount1();
		try {
			b.withdraw();
		}
		catch(InsufficientBalanceException e) {
			System.out.println("Insufficient balance. Withdrawal cannot be processed.");
		}
			finally {
				System.out.println("ATM transaction completed.");
		}
			
		}
	}
public class Flipcart {

	public static void main(String[] args) {
		OnlinePaymetn op = new  OnlinePaymetn();
		op.start1();

	}

}
