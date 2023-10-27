package DSA;

public class Square {
	public static void main(String[] args) {
		int a = 3;
		int b = 9;

		System.out.println("Square integers in the range " + a + " to " + b + ":");
		for (int i = a; i <= b; i++) {
			if (isPerfectSquare(i)) {
				System.out.println(i);
			}
		}
	}

// O(1)
	public static boolean isPerfectSquare(int q) {
		int sqrt = (int) Math.sqrt(q);
		return sqrt * sqrt == q;
	}
}
