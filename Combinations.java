public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        if(n <= 0 || k < 0 || k > n) {
            return rst;
        }
        if(k == 0) {
            List<Integer> cntnt = new ArrayList<Integer>();
            rst.add(cntnt);
            return rst;
        }
        if(k == 1) {
            for(int i = 1; i < n + 1; i++) {
                List<Integer> cntnt = new ArrayList<Integer>();
                cntnt.add(i);
                rst.add(cntnt);
            }
            return rst;
        }
        if(k == n) {
            List<Integer> cntnt = new ArrayList<Integer>();
            for(int i = 1; i < n + 1; i++) {
                cntnt.add(i);
            }
            rst.add(cntnt);
            return rst;
        }
        for(int i = 1; i < n - k + 2; i++) {
            List<List<Integer>> tmp = combine(n - i, k - 1);            if(!tmp.isEmpty()) {
                for(int c = 0; c < tmp.size(); c++) {
                    for(int cc = 0; cc <tmp.get(c).size(); cc++) {
                        int tmpVal = tmp.get(c).get(cc);
                        tmpVal += i;
                        tmp.get(c).set(cc, tmpVal);
                    }
                    tmp.get(c).add(0, i);
                }
                rst.addAll(tmp);
            }
        }
        return rst;
    }
}