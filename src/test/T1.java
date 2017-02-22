package test;

import java.util.Scanner;

/**
 * ACMµÚÈýÌâ http://acm.nyist.net/ ACM exercise subject 3
 * 
 * @author wangk
 */
public class T1 {

	private static final double INF = 0.0000001;

	public static void main(String[] args) {
		T1 main = new T1();
		main.calute();
	}

	public void calute() {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();

		for (int i = 0; i < count; i++) {
			int pointCount = scan.nextInt();
			MyPoint[] ps = new MyPoint[pointCount + 1];
			for (int j = 0; j < pointCount; j++) {
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				ps[j] = new MyPoint(x, y);
			}
			double number = 0.0d;
			double Gx = 0.0d;
			double Gy = 0.0d;

			for (int k = 1; k <= pointCount; ++k) {
				double temp = (ps[k % pointCount].x * ps[k - 1].y - ps[k
						% pointCount].y
						* ps[k - 1].x) / 2.0;
				number += temp;
				Gx += temp * (ps[k % pointCount].x + ps[k - 1].x) / 3.0;
				Gy += temp * (ps[k % pointCount].y + ps[k - 1].y) / 3.0;
			}
			if (number - 0 < INF) {
				System.out.println("0.000 0.000");
				continue;
			}

			System.out.print(String.format("%.3f %.3f\n", number, (Gx + Gy)
					/ number));
		}
		scan.close();
	}

	class MyPoint {
		public double x = 0;
		public double y = 0;

		MyPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

}
