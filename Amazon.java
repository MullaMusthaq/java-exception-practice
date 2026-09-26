package com.sep.exceptions;

import java.util.Scanner;

class FailedCustom1 extends Exception{

}

class Netplay {
	int actualOrderAmount = 699;
	int customerAmount;
	int deleveryFee = 1;
	int totalAmount =0;
	public void acceptIntput() {
		System.out.println("Enter the Payable amount: ");
		Scanner sc = new Scanner(System.in);
		customerAmount = sc.nextInt();
	}
	public void processAmount() throws FailedCustom1{
		totalAmount = actualOrderAmount + deleveryFee;
		if(customerAmount<=totalAmount) {
		   System.out.println("Payment successful.");
		   System.out.println("Order confirmed.");
		}else {
			FailedCustom1 f1 = new FailedCustom1();
			throw f1;
		}
		
	}
	
}
class payment{
	void orderPayment() {
		Netplay n = new Netplay();
		try {
			n.acceptIntput();
			n.processAmount();
		}
		catch(Exception e) {
			System.out.println("Insufficient payment. Please pay the full order amount.");
		}finally {
			System.out.println("Payment process completed.");
		}
	}
}
public class Amazon {

	public static void main(String[] args) {
		payment p = new payment();
		p.orderPayment();

	}

}
