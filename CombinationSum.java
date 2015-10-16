public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        List<Integer> tmpRst = new ArrayList<Integer>();
        if(candidates.length == 1) {
            int sum = 0;
            while(sum < target) {
                sum += candidates[0];
                tmpRst.add(candidates[0]);
            }
            if(sum == target) {
                rst.add(tmpRst);
            }
            return rst;
        }
        int[] tmpwrk = Arrays.copyOfRange(candidates, 0, candidates.length - 1);
        tmp = combinationSum(tmpwrk, target);
        if(!tmp.isEmpty()) {
            rst.addAll(tmp);
        }
        int trgt = target;
        int cnt = 0;
        while(trgt > candidates[candidates.length - 1]) {
            cnt++;
            trgt -= candidates[candidates.length - 1];
            tmp = combinationSum(tmpwrk, trgt);
            if(!tmp.isEmpty()) {
                tmpRst.clear();
                for(int i = 0; i < cnt; i++) {
                    tmpRst.add(candidates[candidates.length - 1]);
                }
                for(int i = 0; i < tmp.size(); i++) {
                    tmp.get(i).addAll(tmpRst);
                }
                rst.addAll(tmp);
            }
        }
        if(candidates.length > 1) {
            int[] tmpwrk2 = Arrays.copyOfRange(candidates, 1, candidates.length);
            tmp = combinationSum(tmpwrk2, target);
            if(!tmp.isEmpty()) {
                rst.addAll(tmp);
            }
        }
        HashSet<List<Integer>> rstHsh = new HashSet<List<Integer>>(rst);
        rst = new ArrayList<List<Integer>>(rstHsh);
        return rst;
    }
}