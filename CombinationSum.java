public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmpRst = new ArrayList<Integer>();
        if(candidates.length == 0 || target < 0) {
            return rst;
        }
        int init = 0;
        int tail = init;
        int sum = candidates[init];
        tmpRst.add(0, candidates[init]);
        while(candidates.length > 0) {
            while(target - sum >= candidates[tail]) {
                sum += candidates[tail];
                tmpRst.add(candidates[tail]);
            }
            System.out.println(tail);
            System.out.println(sum);
            System.out.println(tmpRst);
            if(sum >= target || tmpRst.size() < 1 || tail >= candidates.length - 1) {
                int[] wrk = Arrays.copyOfRange(candidates, 1, candidates.length);
                rst = combinationSum(wrk, target);
                if(sum == target) {
                    rst.add(tmpRst);
                }
            } else {
                sum -= candidates[tail];
                tmpRst.remove(tmpRst.size() - 1);
                tail++;
            }
        }
        return rst;
    }
}