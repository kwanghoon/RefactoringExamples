Refactoring(리팩토링)
=============
리펙토링 이란 프로그램의수행 내용 바꾸지 않으면서도 복잡하게 얽힌 프로그램의 내부구조를 깔끔하게 정리하는것을 의미한다.
## Eclipse에서 제공하는 리펙토링 기능
-	이름변경(Rename) : 클래스, 메소드, 변수 등의 이름을 변경한다.
-	이동(Move) : 클래스, 메소드, 필드 등의 위치를 다른 클래스나 패키지로 이동시킨다.
-	메소드 시그니처 변경(Change Method Signature) : 리턴 타입, 인수 타입과 순서, 메소드 가시성 등 메소드 시그니처를 변경한다.
-	메소드 추출(Extract Method) : 선택한 문장이나 수식을 메소드로 추출한다.
-	지역변수 추출(Extract Local Variable) : 선택한 수식을 지역변수로 추출한다.
-	상수 추출(Extract Constant) : 상수 수식을 클래스 상수로 추출한다.
-	인라인 (Inline) : 메소드 호출 부분을 메소드 본체로 대치함으로써 메소드 호출을 제거한다.
-	매개변수 도출 (Introduce Parameter) : 선택한 수식을 매개변수로 도출한다.

### 메소드추출(Method extraction) 예제
+ Before Method Extraction CalcDistance Class
<pre><code> public class CalcDistance {
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
</code></pre>
+ After Method Extraction CalcDistance Class
<pre><code>public class CalcDistance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 점의 좌표 x와 y를 입력하세요.");
		Point p = readPoint(scan);
		System.out.println("두 번째 점의 좌표 x와 y를 입력하세요.");
		Point q = readPoint(scan);
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), q.toString(),
				p.distanceFrom(q));
	}
	private static Point readPoint(Scanner scan) {
		int x;
		int y;
		x = scan.nextInt();
		y = scan.nextInt();
		Point p = new Point(x, y);
		return p;
	}
}
</code></pre>
### 매개변수 도출(Introduce Parameter) 예제
+ Before Introduce Parameter CalcDistance Class
<pre><code>public class CalcDistance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 점의 좌표 x와 y를 입력하세요.");
		Point p = readPoint(scan);
		System.out.println("두 번째 점의 좌표 x와 y를 입력하세요.");
		Point q = readPoint(scan);
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), q.toString(),
				p.distanceFrom(q));
	}
	private static Point readPoint(Scanner scan) {
		int x;
		int y;
		x = scan.nextInt();
		y = scan.nextInt();
		Point p = new Point(x, y);
		return p;
	}
}
</code></pre>
+ After Introduce Parameter CalcDistance Class
<pre><code>public class CalcDistance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Point p = readPoint(scan, "첫 번째 점의 좌표 x와 y를 입력하세요.");
		Point q = readPoint(scan, "두 번째 점의 좌표 x와 y를 입력하세요.");
		System.out.printf("%s과(와) %s 사이의 거리 = %5.2f",
				p.toString(), q.toString(),
				p.distanceFrom(q));
	}
	private static Point readPoint(Scanner scan, String msg) {
		System.out.print(msg +" ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		Point p = new Point(x, y);
		return p;
	}
}
</code></pre>
