public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String input = "aabbb";
		System.out.println(input);
		String output = longestPalindrome(input);
		System.out.println(output);
	}
	
	private static int subLength = 0;
	private static String subStr = null;
	private static int i = 0;
	public static String longestPalindrome(String s) {
		System.out.println("@" + s);
		System.out.println("subLength = " + subLength);
		try {
			if(s.length() == 0) {
				throw new Exception("Please give me a string of comethind.");
			}
		} catch(Exception e) {
			System.out.println(e);
		}

		if(s.length() == 1 && i == 0) {
			return s;
		} else {
			String sub = s;
			System.out.println(i);
			if(s.lastIndexOf(s.charAt(i)) == i) {
				if(i >= s.length())
					return subStr;
				sub = s.substring(i + 1, s.length());
				subStr = longestPalindrome(sub);
			} else {
				sub = s.substring(i, s.lastIndexOf(s.charAt(i)) + 1);
				if(sub.length() <= subLength) {
					i++;
					sub = s.substring(i, s.lastIndexOf(s.charAt(i)) + 1);
					subStr = longestPalindrome(sub);
				} else {
					StringBuilder subRev = new StringBuilder(sub);
					subRev.reverse();
					if(!sub.equals(subRev.toString())) {
						sub = s.substring(0, sub.lastIndexOf(sub.charAt(0)) + 1);
						System.out.println(sub);
						subStr = longestPalindrome(sub);
					} else if(sub.equals(subRev.toString())){
						if(sub.length() > subLength) {
							subLength = sub.length();
							subStr = sub;
						}
						if(i >= s.length())
							return subStr;
						sub = s.substring(i + 1, s.length());
						subStr = longestPalindrome(sub);
					}
				}
			}
		}
		return subStr;
	}
}