public class Solution {
    public static String reverseWords(String s) {
        s = s.trim();
        if(s.isEmpty()) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int init = s.length() - 1;
        int end = s.length();
        while(init > -1 && end > init) {
            if((init == 0 || (s.charAt(init - 1) == ' ' && s.charAt(init) != ' ')) && (end == s.length() || (s.charAt(end) == ' ' && s.charAt(end - 1) != ' '))) {
            	result.append(" ");
            	result.append(s.substring(init, end));
            	end = init;
            	init --;
            }
            if(init > 0 && (s.charAt(init) == ' ' || s.charAt(init - 1) != ' ')){
            	init --;
            }
            if(end < s.length() && (s.charAt(end) != ' ' || s.charAt(end - 1) == ' ')) {
            	end --;
            }
        }
        return result.toString().trim();
    }
}