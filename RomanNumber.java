package DSA;

public class RomanNumber {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(romanToInt(s));
	}

	public static int value(char romanChar) {
		switch (romanChar) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public static int romanToInt(String s) {
		int result = 0;
		int preValue = 0;
		for (int i = 0; i < s.length(); i++) {
			int s1 = value(s.charAt(i));
			if (s1 > preValue) {
	            result += s1 - (2 * preValue);
	        } else {
	            result += s1;
	        }
	        
			preValue = s1; // update preValue for the next iteration 
	    }
		return result;
	}
	// Time Complexity O(n)/linear time n is the length of string
}
