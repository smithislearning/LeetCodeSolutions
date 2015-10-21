public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        List<HashSet<Character>> benchList = new ArrayList<HashSet<Character>>();
        if(strs.length == 0) {
            return rst;
        }
        Arrays.sort(strs);
        List<String> initCntnt = new ArrayList<String>();
        HashSet<Character> initBench = new HashSet<Character>();
        for(int i = 0; i < strs[0].length(); i++) {
            initBench.add(strs[0].charAt(i));
        }
        benchList.add(initBench);
        initCntnt.add(strs[0]);
        rst.add(initCntnt);
        if(strs.length == 1) {
            return rst;
        }
        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            boolean testRst = false;
            for(int b = 0; b < benchList.size(); b++) {
                for(int s = 0; s < str.length(); s++) {
                    testRst = benchList.get(b).add(str.charAt(s));
                    if(testRst == true) {
                        benchList.get(b).remove(str.charAt(s));
                        break;
                    }
                }
                if(testRst == false) {
                    rst.get(b).add(str);
                    break;
                }
                if(testRst == true) {
                    continue;
                }
            }
            if(testRst == true) {
                HashSet<Character> newBench = new HashSet<Character>();
                for(int t = 0; t < str.length(); t++) {
                    newBench.add(str.charAt(t));
                }
                benchList.add(newBench);
                List<String> newCntnt = new ArrayList<String>();
                newCntnt.add(str);
                rst.add(newCntnt);
            }
        }
        return rst;
    }
}