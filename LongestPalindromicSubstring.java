public class Solution {
	public String longestPalindrome(String s) {
	    		StringBuilder wrkStr = new StringBuilder(s);
		int i = 0;
		while(i <= wrkStr.length()) {
			wrkStr.insert(i, '#');
			i += 2;
		}
		int[] pCap = new int[wrkStr.length()];
		for(int j = 0; j < wrkStr.length(); j++) {
			for(int k = 0; ;k++) {
				if(j - k == 0 || j + k == wrkStr.length() - 1) {
					pCap[j] = k;
					break;
				} else if(wrkStr.charAt(j - k) != wrkStr.charAt(j + k)){
					pCap[j] = k - 1;
					break;
				}
			}
		}
		int max = 0;
		int maxIndex = 0;
		for(int m = 0; m < pCap.length; m++) {
			if(pCap[m] > max) {
				max = pCap[m];
				maxIndex = m;
			}
		}
		StringBuilder rstStr = new StringBuilder(wrkStr.substring(maxIndex - max, maxIndex + max + 1));
		for(int n = 0; n < rstStr.length(); n++) {
			if(rstStr.charAt(n) == '#') {
				rstStr.deleteCharAt(n);
			}
		}
		return rstStr.toString();
	}
}