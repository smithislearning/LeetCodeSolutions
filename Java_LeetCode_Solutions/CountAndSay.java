public class Solution {
    public String countAndSay(int n) {
        if(n == 0) {
            return "";
        }
        if(n == 1) {
            return "1";
        }
        String wrk = countAndSay(n - 1);
        String rst = "";
        int count = 1;
        while(!wrk.isEmpty()) {
            char ref = wrk.charAt(0);
            for(int i = 0; i < wrk.length(); i++) {
                if(wrk.charAt(i) != ref) {
                    count = i;
                    break;
                }
                if(i == wrk.length() - 1 && wrk.charAt(i) == ref) {
                    count = wrk.length();
                    break;
                }
            }
            rst += Integer.toString(count) + ref;
            if(count < wrk.length()) {
                wrk = wrk.substring(count);
            } else {
                wrk = "";
            }
        }
        return rst;
    }
}