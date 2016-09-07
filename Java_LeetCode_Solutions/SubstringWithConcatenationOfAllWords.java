public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int totLen = words.length * len;
        List<Integer> rst = new ArrayList<Integer>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashMap<String, Integer> wrk = new HashMap<String, Integer>();
        for(String str : words) {
            if(dict.containsKey(str)) {
                dict.put(str, dict.get(str) + 1);
            } else {
                dict.put(str, 1);
            }
        }
        int index = 0;
        int count = 0;
        for(int i = 0; i < s.length() - totLen + 1; i++) {
            String wrkStr = s.substring(i, i + len);
            if(!dict.containsKey(wrkStr)) {
                continue;
            }
            wrk.clear();
            index = i;
            count = 0;
            while(index < s.length() - len + 1) {
                wrkStr = s.substring(index, index + len);
                if(!dict.containsKey(wrkStr)) {
                    break;
                }
                if(wrk.containsKey(wrkStr)) {
                    wrk.put(wrkStr, wrk.get(wrkStr) + 1);
                } else {
                    wrk.put(wrkStr, 1);
                }
                count++;
                if(wrk.get(wrkStr) > dict.get(wrkStr)) {
                    break;
                }
                if(count == words.length) {
                    rst.add(i);
                }
                index += len;
            }
        }
        return rst;
    }
}