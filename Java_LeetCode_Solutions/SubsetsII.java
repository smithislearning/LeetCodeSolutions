public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> cntnt = new ArrayList<Integer>();
        cntnt.clear();
        rst.add(cntnt);
        if(nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        int i = 1;
        List<Integer> sCnt = new ArrayList<Integer>();
        sCnt.add(nums[0]);
        rst.add(sCnt);
        while(i < nums.length && nums[i - 1] == nums[i]) {
            List<Integer> crtCnt = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++) {
                crtCnt.add(nums[j]);
            }
            i++;
            rst.add(crtCnt);
        }
        if(i < nums.length) {
            int[] wrk = Arrays.copyOfRange(nums, i, nums.length);
            int bench = rst.size();
            List<List<Integer>> tmp = subsetsWithDup(wrk);
            tmp.remove(0);
            for(int m = 0; m < bench; m++) {
                for(int n = 0; n < tmp.size(); n++) {
                    List<Integer> newCnt = new ArrayList<Integer>();
                    newCnt.addAll(rst.get(m));
                    newCnt.addAll(tmp.get(n));
                    rst.add(newCnt);
                }
            }
        }
        return rst;
    }
}