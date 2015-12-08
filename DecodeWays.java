public class Solution {
    public int numDecodings(String s) {
        int[] ref = new int[s.length() + 1];
        ref[0] = 1;
        if(ref.length == 1) {
            return 0;
        }
        if(isValid(s.substring(0, 1))) {
            ref[1] = 1;
        } else {
            ref[1] = 0;
        }
        if(ref.length == 2) {
            return ref[1];
        }
        for(int i = 2; i < ref.length; i++) {
            if(isValid(s.substring(i - 1, i))) {
                ref[i] += ref[i - 1];
            }
            if(isValid(s.substring(i - 2, i))) {
                ref[i] += ref[i - 2];
            }
        }
        return ref[s.length()];
    }
    private boolean isValid(String input) {
        if(input.charAt(0) == '0') {
            return false;
        }
        int wrk = Integer.parseInt(input);
        if(wrk > 26) {
            return false;
        }
        return true;
    }
}