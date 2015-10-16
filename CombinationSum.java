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
<<<<<<< HEAD
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
=======
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
>>>>>>> 507cd96f22714a3e819b41fa0e899908c2b4dfe7
    }
}