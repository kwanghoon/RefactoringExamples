package com.example.java.refactoring.invoice;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestAnotherInvoice {

	@Test
	void test() {
		ArrayList<Order> arrList = new ArrayList<Order>();
		arrList.add(new Order(4.5));
		arrList.add(new Order(1.3));
		arrList.add(new Order(9.7));
		
		ArrayList<String> logs = new ArrayList<String>();
		
		AnotherInvoice invoice = 
				new AnotherInvoice(
						"Hong gil dong", 
						new MyCollection(Collections.enumeration(arrList)), 
						new Printer() { 
							public void print(String msg) { 
								logs.add(msg);
							}
						});
		
		invoice.printOwing();
		
		ArrayList<String> expectedLogs = new ArrayList<String>();
		expectedLogs.add("*************************");
		expectedLogs.add("***** Customer Owes *****");
		expectedLogs.add("*************************");
		expectedLogs.add("name: Hong gil dong");
		expectedLogs.add("amount: 15.5");
		expectedLogs.add("count: 3");
		
		Assertions.assertIterableEquals(logs, expectedLogs);
	}

}
