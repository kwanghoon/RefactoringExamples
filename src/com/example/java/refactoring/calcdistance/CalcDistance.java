// 프로그램 6.5
package com.example.java.refactoring.calcdistance;

import java.util.Scanner;

public class CalcDistance {

	public static void main(String[] args) {
		int x, y;
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 점의 좌표 x와 y를 입력하세요.");
		x = scan.nextInt();
		y = scan.nextInt();
		Point p = new Point(x, y);
		System.out.println("두 번째 점의 좌표 x와 y를 입력하세요.");
		x = scan.nextInt();
		y = scan.nextInt();
		Point q = new Point(x,y);
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), q.toString(),
				p.distanceFrom(q));
	}

}
