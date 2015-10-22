public class Solution {
    public String getPermutation(int n, int k) {
        String rst = "";
        int max = 1;
        
        int tmp = n;
        while(tmp > 0) {
            max *= tmp;
            tmp--;
        }
        if(k > max) {
            return "";
        }
        ArrayList<Integer> rstList = permute(n, k);
        for(int i = 0; i < n; i++) {
            rst += Integer.toString(rstList.get(i));
        }
        return rst;
    }
    private ArrayList<Integer> permute(int n, int k) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(n == 1) {
            rst.add(1);
            return rst;
        }
        if(k == 1) {
            for(int i = 0; i < n; i++) {
                rst.add(i + 1);
            }
            return rst;
        }
        int bound = 1;
        int tmp = n - 1;
        while(tmp > 0) {
            bound *= tmp;
            tmp--;
        }
        int lnd = (int)Math.ceil(((double)k)/((double)bound));
        int lIdx = k - (lnd - 1)*bound;
        rst.add(lnd);
        ArrayList<Integer> wrk = permute(n - 1, lIdx);
        for(int i = 0; i < wrk.size(); i++) {
            int tmpwrk = wrk.get(i);
            if(tmpwrk >= lnd) {
                wrk.set(i, ++tmpwrk);
            }
        }
        rst.addAll(wrk);
        return rst;
    }
}