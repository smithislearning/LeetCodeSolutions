public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int start = s.lastIndexOf(' ');
        if(start == -1) {
            return s.length();
        }
        if(start == s.length() - 1) {
            return lengthOfLastWord(s.substring(0, s.length() - 1));
        }
        String wrk = s.substring(start + 1);
        return wrk.length();
    }
}