public class Solution {
	public String convert(String s, int numRows) {
		try {
			if(s.length() == 0) {
				throw new Exception("Not an empty one bro!");
			}
			if(numRows == 0) {
				throw new Exception("0 rows, seriously?");
			}
			if(s.length() < numRows) {
				throw new Exception("Too many rows!!!");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		if(s.length() <= 2 || numRows == 1) {
			return s;
		}
		StringBuilder tmp = new StringBuilder();
		if(numRows == 2) {
			int i = 0;
			while(2 * i < s.length()) {
				tmp.append(s.charAt(2 * i));
				i++;
			}
			int j = 0;
			while(2 * j + 1 < s.length()) {
				tmp.append(s.charAt(2 * j + 1));
				j++;
			}
			return tmp.toString();
		} else {
			for(int a = 0; a < numRows; a++) {
				int tmpIndex = a;
				int bench = 2 * a;
				while(tmpIndex < s.length()) {
					tmp.append(s.charAt(tmpIndex));
					if(a > 0 && a < numRows - 1) {
						bench = 2 * (numRows - 1) - bench;
					} else {
						bench = 2 * (numRows - 1);
					}
					tmpIndex += bench;
				}
			}
		}
		return tmp.toString();
	}
}