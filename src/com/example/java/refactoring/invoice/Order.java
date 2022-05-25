package com.example.java.refactoring.invoice;

public class Order {
	private double _amount;
	
	public Order(double _amount) {
		super();
		this._amount = _amount;
	}

	public double getAmount() {
		return _amount;
	}
}
