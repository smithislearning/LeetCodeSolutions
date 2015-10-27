public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x.length() == 0) {
                return true;
        } else {
            StringBuilder rev = new StringBuilder(Integer.toString(x));
            rev.reverse();
            try {
                if(x - Integer.valueOf(rev.toString()) == 0) {
                    return true;
                } else {
                    return false;
                }
            } catch(Exception e) {
                System.out.println("woops...");
            }
        }
        return false;
    }
}