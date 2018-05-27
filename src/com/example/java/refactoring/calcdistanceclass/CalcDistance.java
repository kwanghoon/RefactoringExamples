// 프로그램 6.14
//
// 연습문제:  
//   1) CalcDistance 클래스의 readPoint와 readNamedPoint 메소드를
//      각각 Point 클래스와 NamedPoint 클래스로 이동시키시오.
//      (리팩토링 방법 Move를 활용)
//
//   2) 두 메소드 이름을 모두 read로 변경하시오.
//      (리팩토링 방법 Rename을 활용. 기존 이름을 참고하는 부분도 함께 변경되어야 함.)
//

package com.example.java.refactoring.calcdistanceclass;

import java.util.Scanner;

public class CalcDistance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Point p = readPoint(scan, "첫 번째 점의 좌표 x와 y를 입력하세요.");
		Point q = readPoint(scan, "두 번째 점의 좌표 x와 y를 입력하세요.");
		
		NamedPoint r = readNamedPoint(scan, "세 번째 점의 좌표 x와 y를 입력하세요.");
		NamedPoint s = readNamedPoint(scan, "네 번째 점의 좌표 x와 y를 입력하세요.");
		
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), q.toString(),
				p.distanceFrom(q));
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), r.toString(),
				p.distanceFrom(r));
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				r.toString(), q.toString(),
				r.distanceFrom(q));
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				r.toString(), s.toString(),
				r.distanceFrom(s));
	}

	private static Point readPoint(Scanner scan, String msg) {
		System.out.print(msg);

		int x = scan.nextInt();
		int y = scan.nextInt();
		Point q = new Point(x,y);
		return q;
	}
	
	private static NamedPoint readNamedPoint(Scanner scan, String msg) {
		System.out.print(msg);

		String name = scan.next();
		int x = scan.nextInt();
		int y = scan.nextInt();
		NamedPoint q = new NamedPoint(name,x,y);
		return q;
	}

}
