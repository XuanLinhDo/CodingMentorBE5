package DSA;

import java.text.DecimalFormat;

public class SquareRoot {
	public static void main(String[] args) {
		int[] num = { 1, 2, 4, 1, 2, 4 };
		System.out.println("Summarise = " + sum(num));

//		double sqrt= Math.sqrt(sum(num));
//		DecimalFormat df = new DecimalFormat("#.##");
//		String rounded = df.format(sqrt);
//		System.out.println("Squareroot of sum = " + rounded);
		double rounded = Math.abs(sqrt(num));
		
		System.out.println(rounded);
	}

// O(1)
	public static double sum(int[] num) {
		double sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;

	}

	public static double sqrt(int[] num) {
		double a;
		double sqrt = sum(num)/2;
		do {
			a = sqrt;
			sqrt = (a + (sum(num) / a)) / 2;
		} while ((a - sqrt) != 0);
		return sqrt;
	}

}
