package DSA;

public class SortExample {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 0, 0, 1, 2, 2, 1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j< arr.length; j++) {
				int tmp = 0;
				// using tmp/temporary variable is used to swap two elements if arr[i] > arr[j]
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.println(arr[i]);
		}
	}

}
