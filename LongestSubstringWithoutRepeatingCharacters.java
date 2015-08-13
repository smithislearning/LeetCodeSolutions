import java.util.HashSet;
import java.lang.StringBuilder;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if(s.isEmpty()) {
            return maxLength;
        }
        HashSet<Character> inputHash = new HashSet<Character>();
        StringBuilder sub = new StringBuilder();
        boolean noRepeat = false;
        for(char m : s.toCharArray()) {
            noRepeat = inputHash.add(m);
            if(noRepeat == false) {
                if(sub.length() > maxLength) {
                    maxLength = sub.length();
                }
                sub.delete(0, sub.indexOf(String.valueOf(m)) + 1);
                sub.append(m);
            } else {
                sub.append(m);
            }
        }
        if(sub.length() > maxLength) {
            maxLength = sub.length();
        }
        return maxLength;
    }
}