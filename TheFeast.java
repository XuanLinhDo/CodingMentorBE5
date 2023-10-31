package DSA;

public class TheFeast {
	public static void main(String[] args) {
		int n = 12;
		int c = 2;
		// b is the number of chocolate bar received
		int b = n / c;
		int totalChocoBars = b;
		while (b >= 2) {
			// m is the number of wrappers
			int m = b;
			int freeChocoBars = m / 2;
			totalChocoBars += freeChocoBars;
			m = m % 2; // check the number of wrappers after exchange
			b = m + freeChocoBars;
		}
		System.out.println("The total chocolate bars: " + totalChocoBars);
	}
	// time complexity Ologn
	// space complexity O1
}
