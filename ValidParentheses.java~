public class ValidParentheses {
	public static void main(String[] args) {
		String input = "(()))(";
		System.out.println(isValid(input));
	}
	public static boolean isValid(String s) {
		System.out.println(s);

		char[] left = {'(', '[', '{'};
		char[] right = {')', ']', '}'};
		for(int i = 0; i < left.length; i++) {
			char l = left[i];
			char r = right[i];
			if(s.indexOf(r) < s.indexOf(l)) {
				return false;
			}
		}
		return true;
	}
}