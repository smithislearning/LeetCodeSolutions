public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmpRst = new ArrayList<Integer>();
        int init = 0;
        int tail = init;
        int sum = candidates[init];
        tmpRst.add(candidates[init]);
        while(true) {
            while(target - sum >= candidates[tail]) {
                sum += candidates[tail];
                tmpRst.add(candidates[tail]);
            }
            if(sum >= target || tail >= candidates.length - 1) {
                if(candidates.length > 1) {
                    int[] wrk = Arrays.copyOfRange(candidates, 1, candidates.length);
                    rst = combinationSum(wrk, target);
                }
                if(sum == target) {
                    HashSet<List<Integer>> wrkset = new HashSet<List<Integer>>(rst);
                    wrkset.add(tmpRst);
                    rst = new ArrayList<List<Integer>>(wrkset);
                }
                break;
            } else {
                sum -= candidates[tail];
                tmpRst.remove(tmpRst.size() - 1);
                tail++;
            }
        }
        return rst;
    }
}