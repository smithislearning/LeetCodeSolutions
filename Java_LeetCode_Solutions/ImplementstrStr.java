public class Solution {
    public int strStr(String haystack, String needle) {
       if(haystack.length() == 0 && needle.length() == 0) {
			return 0;
		}
		if(haystack.length() == 0 && needle.length() != 0) {
			return -1;
		}
		if(haystack.length() != 0 && needle.length() == 0) {
			return 0;
		}
		int len = needle.length();
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			String wrk = haystack.substring(i, i + len);
			if(wrk.equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}