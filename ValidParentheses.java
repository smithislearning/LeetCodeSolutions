public class Solution {
    public boolean isValid(String s) {
        Stack<Character> wrkStk = new Stack<Character>();
        HashMap<Character, Character> wrkMap = new HashMap<Character, Character>();
        wrkMap.put('(', ')');
        wrkMap.put('[', ']');
        wrkMap.put('{', '}');
        
        for(int i = 0; i < s.length(); i++) {
            if(wrkMap.keySet().contains(s.charAt(i))) {
                wrkStk.push(s.charAt(i));
            } else if(wrkMap.values().contains(s.charAt(i))) {
                if(!wrkStk.empty() && wrkMap.get(wrkStk.peek()) == s.charAt(i)) {
                    wrkStk.pop();
                } else {
                    return false;
                }
            }
        }
        return wrkStk.empty();
    }
}