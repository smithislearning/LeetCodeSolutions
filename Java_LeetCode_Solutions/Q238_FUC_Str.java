public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> cCnt = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(cCnt.containsKey(c)) {
                cCnt.put(c, cCnt.get(c) + 1);
            } else {
                cCnt.put(c, 1);
            }
        }
        for(int i = 0; i < s.length(); i ++) {
            if(cCnt.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
