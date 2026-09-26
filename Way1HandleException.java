package com.sep.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

class Way1{
	void alpha1() {
		System.out.println("Connection Established....");
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Numerator");
			int a= sc.nextInt();
			System.out.println("Enter the Denominator");
			int b = sc.nextInt();
			int c = a/b;
			System.out.println(c);
		}
		catch(ArithmeticException e) {
			System.out.println("Give Non Zero denominator");
		}
		System.out.println("Connection Terminated....");
	}
}
public class Way1HandleException {

	public static void main(String[] args) {
		Way1 w1 = new Way1();
		w1.alpha1();

	}

}
