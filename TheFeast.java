package DSA;

public class TheFeast {
	public static void main(String[] args) {
		int n = 12;
		int c = 2;
		// b is the number of chocolate bar received
		int b = n / c;
		// m is the number of wrappers
		int m = b;
		int totalChocoBars = b;
		while (m >= 2) {
			int freeChocoBars = m / 2;
			totalChocoBars += freeChocoBars;
			m = m % 2; // check the number of wrappers after exchange
			m += freeChocoBars;
		}
		System.out.println("The total chocolate bars: " + totalChocoBars);
	}
	// time complexity Ologn
	// space complexity O1
}
