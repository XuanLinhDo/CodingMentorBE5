package DSA;

public class LongestSameString {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println("The longest common prefix is: " + Solution(strs));
	}

	public static String Solution(String[] strs) {
		String output = strs[0];
		for (int i = 1; i < strs.length; i++) {
			// .indexOf(output) is index of the substring from String 
			while (strs[i].indexOf(output) != 0) {
				//substring method to return a part of String
				output = output.substring(0, output.length() - 1);
			}
			if (output.isEmpty()) {
				return "null - no common prefix";
			}

		}
		return output;

	}

}
