public class Solution {
    public String longestPalindrome(String s) {
    	    try {
    	    	    if(s == null || s.length() == 0) {
    	    	    	    throw new Exception("Please give me a String of something!");
    	    	    }
    	    } catch(Exception e) {
    	    	    System.out.println(e);
    	    }
    	    if(s.length() == 1) {
    	    	    return s;
    	    }
    	    StringBuilder ori = new StringBuilder(s);
    	    StirngBuilder rori = new StringBuilder(s);
    	    rori.reverse();
    	    