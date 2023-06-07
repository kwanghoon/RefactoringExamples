package com.example.java.refactoring.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Invoice {
	private MyCollection _orders;
	private String _name;
	
	private Printer _printer;
	
	public Invoice(String customer_name, MyCollection orders, Printer printer) {
		this._orders = orders;
		this._name = customer_name;
		
		this._printer = printer;
	}
	
	void printOwing() {
		Enumeration<Order> e = _orders.elements();
		double outstanding = 0.0;
		
		// print banner
		printBanner();
		
		// calculate outstanding
		outstanding = calcOutstanding(e, outstanding);
		
		// print details
		printDetails(outstanding);
	}

	private void printDetails(double outstanding) {
		_printer.print("name: " + _name);
		_printer.print("amount: " + outstanding);
	}

	private double calcOutstanding(Enumeration<Order> e, double outstanding) {
		while (e.hasMoreElements()) {
			Order each = e.nextElement();
			outstanding += each.getAmount();
		}
		return outstanding;
	}

	private void printBanner() {
		_printer.print("*************************");
		_printer.print("***** Customer Owes *****");
		_printer.print("*************************");
	}

	public static void main(String[] args) {
		ArrayList<Order> arrList = new ArrayList<Order>();
		arrList.add(new Order(4.5));
		arrList.add(new Order(1.3));
		arrList.add(new Order(9.7));
		
		Invoice invoice = 
				new Invoice(
						"Hong gil dong", 
						new MyCollection(Collections.enumeration(arrList)), 
						new Printer() { 
							public void print(String msg) { 
								System.out.println(msg);
							}
						});
		
		invoice.printOwing();
	}
}
