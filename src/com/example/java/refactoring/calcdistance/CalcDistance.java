// 프로그램 6.5
//
// 연습문제:  
//   1) 좌표 두 개를 입력받아 Point 객체를 만드는 코드 중복을 제거하기
//      중복된 코드를 메소드로 추출하고, 해당 코드를 메소드 호출로 대체.
//      (리팩토링 방법 Extract Method를 활용)
//
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
