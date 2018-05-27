package com.example.java.refactoring.calcdistance;

public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ","  + y + ")";
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public double distanceFrom(Point q) {
		return Math.sqrt(
				Math.pow(q.x - x, 2) 
				+ Math.pow(q.y - y,  2));
	}
}
