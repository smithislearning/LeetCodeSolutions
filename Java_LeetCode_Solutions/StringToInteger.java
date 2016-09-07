import java.math.BigInteger;
public class Solution {
    public int myAtoi(String str) {
		try {
			if(str.length() == 0) {
				throw new Exception("I can't work with an empty one!");
			}
		} catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		int result = 0;
		StringBuilder tmpStr = new StringBuilder(str);
		for(int i = 0; i < tmpStr.length(); i++) {
			if(i == 0) {
				if(tmpStr.charAt(i) == ' ') {
					tmpStr.deleteCharAt(i);
					i--;
					continue;
				} else if(tmpStr.charAt(i) == '+') {
					if(((int)tmpStr.charAt(i + 1)) > 57 || ((int)tmpStr.charAt(i + 1)) < 48) {
						return 0;
					} else {
						tmpStr.deleteCharAt(i);
						i--;
						continue;
					}
				} else if(tmpStr.charAt(i) == '-') {
					continue;
				} else {
					try {
						if(((int)tmpStr.charAt(i)) > 57 || ((int)tmpStr.charAt(i)) < 48) {
							throw new Exception("At least the first one should be a number, right?");
						}
					} catch(Exception e) {
						System.out.println(e);
						return 0;
					}
				}
			} else if(((int)tmpStr.charAt(i)) > 57 || ((int)tmpStr.charAt(i)) < 48) {
				System.out.println(tmpStr.charAt(i));
				tmpStr.delete(i, tmpStr.length());
				break;
			}
		}
		if(tmpStr.length() == 0 || tmpStr.toString().equals("-")) {
			result =  0;
		} else {
			BigInteger tmpResult = new BigInteger(tmpStr.toString());
			BigInteger maxInt = new BigInteger(Integer.toString(Integer.MAX_VALUE));
			BigInteger minInt = new BigInteger(Integer.toString(Integer.MIN_VALUE));
			if(tmpResult.compareTo(maxInt) == 1) {
				return Integer.MAX_VALUE;
			} else if(tmpResult.compareTo(minInt) == -1) {
				return Integer.MIN_VALUE;
			} else {
				result = Integer.parseInt(tmpStr.toString());
			}
		}
		return result;
	}
}