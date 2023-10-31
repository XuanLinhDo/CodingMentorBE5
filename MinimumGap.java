package DSA;

public class MinimumGap {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 2, 1, 7 };
		System.out.println("Minimun gap is " + findMinGap(arr));
	}

	public static int findMinGap(int[] arr) {
		int minGap = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					int currentGap = Math.abs(j - i);
					if (minGap == 0 || currentGap < minGap) {
						minGap = currentGap;
					}
				}
			}
		}
		if (minGap == 0) {
			return 0;
		}
		return minGap;
	}
	// time complexity On^2
	// space complexity On
}
