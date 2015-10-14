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
            if(sum == target) {
                HashSet<List<Integer>> wrkSet = new HashSet<List<Integer>>(rst);
                wrkSet.add(tmpRst);
                List<List<Integer>> tmp1 = new ArrayList<List<Integer>>(wrkSet);
                rst.addAll(tmp1);
            }
            System.out.println(rst);
            if(sum > target || tail == candidates.length - 1) {
                System.out.println(rst);
                if(candidates.length > 1) {
                    int[] wrk = Arrays.copyOfRange(candidates, 1, candidates.length);
                    System.out.println("before");
                    System.out.println(rst);
                    List<List<Integer>> tmp = combinationSum(wrk,target);
                    rst.addAll(tmp);

                }
                break;
            }
            sum -= candidates[tail];
            tmpRst.remove(tmpRst.size() - 1);
            tail++;
       }
       return rst;
    }
}