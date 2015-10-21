public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        HashMap<Integer, Integer>  rstMap = new HashMap<Integer, Integer>();
        Arrays.sort(strs);
        for(String str : strs) {
            char[] crnt = str.toCharArray();
            Arrays.sort(crnt);
            int hshCd = Arrays.hashCode(crnt);
            if(rstMap.containsKey(hshCd)) {
                rst.get(rstMap.get(hshCd)).add(str);
            } else {
                ArrayList<String> cntnt = new ArrayList<String>();
                cntnt.add(str);
                rst.add(cntnt);
                rstMap.put(hshCd, rst.size() - 1);
            }
        }
        return rst;
    }
}