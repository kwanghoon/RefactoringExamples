package com.example.java.refactoring.calcdistanceclass;

public class NamedPoint extends Point {
	private String name;
	
	public NamedPoint(String name, int x, int y) {
		super(x, y);
		this.name = name;
	}
	
	public String toString() {
		return name + super.toString();
	}
	
	public String getNam() {
		return name;
	}
}
