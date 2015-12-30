public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<String>();
        if(s.length() > 12|| s.length() < 4) {
            return rst;
        }
        List<List<String>> wrk = new ArrayList<List<String>>();
        List<String> strList = new ArrayList<String>();
        dfs(s, 0, wrk, strList);
        for(List l : wrk) {
            StringBuilder rstStr = new StringBuilder();
            for(int i = 0; i < 3; i++) {
                rstStr.append(l.get(i));
                rstStr.append(".");
            }
            rstStr.append(l.get(3));
            rst.add(rstStr.toString());
        }
        return rst;
    }
    private void dfs(String s, int init, List<List<String>> wrk, List<String> strList) {
        if(strList.size() >= 4 && init < s.length()) {
            return;
        }
        if((strList.size() + s.length() - init + 1) < 4) {
            return;
        }
        if(strList.size() == 4 && init == s.length()) {
            List<String> tmp = new ArrayList<String>(strList);
            wrk.add(tmp);
            return;
        }
        for(int i = 1; i < 4; i++) {
            if(init + i > s.length()) {
                break;
            }
            String subStr = s.substring(init, init + i);
            if(i > 1 && s.charAt(init) == '0') {
                break;
            }
            if(Integer.valueOf(subStr) > 255) {
                break;
            }
            strList.add(subStr);
            dfs(s, init + i, wrk, strList);
            strList.remove(strList.size() - 1);
        }
    }
}