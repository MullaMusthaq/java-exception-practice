package com.sep.exceptions;

import java.util.Scanner;

class InvalidQuantityException extends Exception{
   public InvalidQuantityException(String message) {
	   super(message);
}
}
class OutOfStockException extends Exception{
	 public OutOfStockException(String message) {
		super(message);
	}
}
class Product{
	String productName;
	int quantity_req;
	int pricePerItem = 500;
	int availableStock=10;
	
	
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the product: ");
		productName = sc.nextLine();
		
		System.out.println("Enter the product quantity: ");
		quantity_req = sc.nextInt();
		
	}
	
	public void validateInput() throws InvalidQuantityException{
		if(quantity_req <=0 ) {
			InvalidQuantityException ie = new InvalidQuantityException("Invalid quantity");
			throw ie;
		}
	}
	public void validateStock() throws OutOfStockException{
		if(quantity_req > availableStock) {
			OutOfStockException oe = new OutOfStockException("Unavailable Stock!!!");
			throw oe;
		}
	}
	public void displayConfirm() {
		System.out.println("Product Name: "+ productName);
		System.out.println("Quantity requested: "+ quantity_req);
		System.out.println("Amount to be paid: "+ (pricePerItem*quantity_req));
		System.out.println("Order Confirmed!");
		System.out.println("Remaining Stock: "+ (availableStock=availableStock-quantity_req));
	}
}
class OrderController{
	public void orderStatus() {
		Product p = new Product();
		try {
			p.acceptInput();
			p.validateInput();
			p.validateStock();
			p.displayConfirm();
		}catch(InvalidQuantityException | OutOfStockException io) {
			System.out.println("Order Failed: "+ io.getMessage());
		}
	}
}
public class Scenario8 {

	public static void main(String[] args) {
		OrderController oc = new OrderController();
		oc.orderStatus();

	}

}
