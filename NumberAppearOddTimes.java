package DSA;

import java.util.Arrays;

public class NumberAppearOddTimes {
	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 4, 5, 6, 1, 2, 3, 4, 5, 100, 400, 15, 15, 15, 15, 15, 15, 15, 15 };

		// O(n^2)
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > array[i]) {
					int temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					swapped = true;
				}
			}
		} while (swapped);

		int currentNumber = array[0];
		int count = 1;
// O(n)
		for (int i = 1; i < array.length; i++) {
			if (array[i] == currentNumber) {
				count++;
			} else {
				if (count % 2 != 0) {
					System.out
							.println("Number appears odd times: " + currentNumber + "- Frequency: " + count + " time.");
				}
				currentNumber = array[i];
				count = 1;
			}
		}

		if (count % 2 != 0) {
			System.out.println("Number appears odd times: " + currentNumber + "-  Frequency: " + count + " time.");
		}
	}
}