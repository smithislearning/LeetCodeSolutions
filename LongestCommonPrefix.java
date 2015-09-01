public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int str = 0; str < strs.length; str++) {
            if(strs[str].length() < prefix.length()) {
                prefix.delete(strs[str].length(), prefix.length());
            }
            for(int chr = 0; chr < prefix.length(); chr++) {
                if(strs[str].charAt(chr) != prefix.charAt(chr)) {
                    prefix.delete(chr, prefix.length());
                }
            }
        }
        return prefix.toString();
    }
}