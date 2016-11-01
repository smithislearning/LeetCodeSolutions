public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];
        int zeroCnt = 0;
        int tmp = 1;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                tmp *= nums[i];
            } else {
                zeroCnt ++;
            }
        }
        if(zeroCnt > 1) {
            return rst;
        }
        if(zeroCnt == 1) {
            for(int i = 0; i < nums.length; i ++) {
                if(nums[i] != 0) {
                    rst[i] = 0;
                } else {
                    rst[i] = tmp;
                }
            }
            return rst;
        }
        for(int i = 0; i < nums.length; i ++) {
            rst[i] = tmp / nums[i];
        }
        return rst;
    }
}
