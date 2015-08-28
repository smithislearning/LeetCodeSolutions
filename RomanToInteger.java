
public class Solution {	
	public int romanToInt(String s) {
		if(s.length() == 0) {
			return 0;
		} else {
			int[] vals = new int[s.length()];
			for(int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case 'I':
					vals[i] = 1;
					break;
				case 'V':
					vals[i] = 5;
					break;
				case 'X':
					vals[i] = 10;
					break;
				case 'L':
					vals[i] = 50;
					break;
				case 'C':
					vals[i] = 100;
					break;
				case 'D':
					vals[i] = 500;
					break;
				case 'M':
					vals[i] = 1000;
					break;
				}
			}
			int finalVal = vals[0];
			if(vals.length == 1) {
				return finalVal;
			} else {
				for(int j = 1; j < vals.length; j++) {
					if(vals[j - 1] < vals[j]) {
						finalVal -= (2 * vals[j - 1]);
						finalVal += vals[j];
					} else {
						finalVal += vals[j];
					}
				}
				return finalVal;
			}
		}
	}
}