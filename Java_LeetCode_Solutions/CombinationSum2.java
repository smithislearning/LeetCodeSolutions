public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> rstHsh = new HashSet<List<Integer>>(combSum2(candidates, target));
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>(rstHsh);
        return rst;
    }
    private List<List<Integer>> combSum2(int[] input, int ref) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(input.length <= 0) {
            return rst;
        }
        if(ref - input[input.length - 1] == 0) {
            List<Integer> cntnt = new ArrayList<Integer>();
            cntnt.add(input[input.length - 1]);
            rst.add(cntnt);
        }
        int[] wrk = Arrays.copyOfRange(input, 0, input.length - 1);
        List<List<Integer>> tmpRst1 = combSum2(wrk, ref);
        if(!tmpRst1.isEmpty()) {
            rst.addAll(tmpRst1);
        }
        if(ref - input[input.length - 1] <= 0) {
            return rst;
        }
        
        List<List<Integer>> tmpRst2 = combSum2(wrk, ref - input[input.length - 1]);
        if(!tmpRst2.isEmpty()) {
            for(int i = 0; i < tmpRst2.size(); i++) {
                tmpRst2.get(i).add(input[input.length - 1]);
            }
            rst.addAll(tmpRst2);
        }
        return rst;
    }
}