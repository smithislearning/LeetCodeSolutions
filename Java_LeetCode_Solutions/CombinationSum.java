public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> rstHsh = new HashSet<List<Integer>>(combSum(candidates, target));
        List<List<Integer>> fRst = new ArrayList<List<Integer>>(rstHsh);
        return fRst;
    }
    private List<List<Integer>> combSum(int[] input, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> cntnt = new ArrayList<Integer>();
        if(input.length == 0 || input[0] > target) {
            return rst;
        }
        if(input.length == 1) {
            if(input[0] != 0 && target % input[0] == 0) {
                int cnt = target / input[0];
                for(int i = 0; i < cnt; i++) {
                    cntnt.add(input[0]);
                }
                rst.add(cntnt);
            }
            return rst;
        }
        int[] wrk = Arrays.copyOfRange(input, 1, input.length);
        List<List<Integer>> tmpRst1 = combSum(wrk, target);
        if(!tmpRst1.isEmpty()) {
            rst.addAll(tmpRst1);
        }
        if(input[0] != 0 && target % input[0] == 0) {
            int cnt = target / input[0];
            for(int i = 0; i < cnt; i++) {
                cntnt.add(input[0]);
            }
            rst.add(cntnt);
        }
        int ref = target;
        int cnt = 0;
        while (ref > 0) {
            ref -= input[0];
            cnt++;
            if(ref == 0) {
                List<Integer> tmpCntnt = new ArrayList<Integer>();
                for(int i = 0; i < cnt; i++) {
                    tmpCntnt.add(input[0]);
                }
                rst.add(tmpCntnt);
            } else if(ref > 0) {
                List<List<Integer>> tmpRst2 = combSum(wrk, ref);
                if(!tmpRst2.isEmpty()) {
                    for(int j = 0; j < tmpRst2.size(); j++) {
                        for(int i = 0; i < cnt; i++) {
                            tmpRst2.get(j).add(0, input[0]);
                        }
                    }
                    rst.addAll(tmpRst2);
                }
            }
        }
        return rst;
    }
}