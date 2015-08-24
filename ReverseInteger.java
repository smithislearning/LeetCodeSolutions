public class Solution {	
	public int reverse(int x) {
		String inPut = Integer.toString(x);
		StringBuilder reverseIn = new StringBuilder(inPut);
		reverseIn.reverse();
		if(reverseIn.charAt(reverseIn.length() - 1) == '-') {
			reverseIn.deleteCharAt(reverseIn.length() - 1);
			reverseIn.insert(0, '-');
		}
		String outPut = reverseIn.toString();
		long tmp = Long.parseLong(outPut);
		if(tmp > (long)Integer.MAX_VALUE || tmp < (long)Integer.MIN_VALUE) {
			return 0;
		}
		return (int)tmp;
	}
}