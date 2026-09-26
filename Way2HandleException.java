package com.sep.exceptions;

import java.util.Scanner;

class Demo{
	public void Beta() throws Exception{
	  System.out.println("Connection Establishment4");
	  try {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the Numerator");
		  int a = sc.nextInt();
		  System.out.println("Enter the Denominator");
		  int b = sc.nextInt();
		  int c = a/b;
		  System.out.println(c);
	  }
	  catch(Exception e) {
		  System.out.println("exception catch by beta");
		  throw e;
	  }
	  finally {
	  System.out.println("Connection Terminated4");
	  }
	}
}
public class Way2HandleException {

	public static void main(String[] args) {
	
	Demo d = new Demo();
	System.out.println("Connection Established1");
	try {
		d.Beta();
	}catch(Exception e) {
		System.out.println("Exception Catch by main");
	}
	System.out.println("Connection Terminated1");
	}

}
