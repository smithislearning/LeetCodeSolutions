public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k < 1) {
            return new int[0];
        }
        if(k == 1) {
            return nums;
        }
        int idx = 0;
        int max = Integer.MIN_VALUE;
        int maxId = -1;
        ArrayList<Integer> localMaxes = new ArrayList<Integer>();
        while(idx < k) {
            if(nums[idx] > max) {
                max = nums[idx];
                maxId = idx;
            }
            idx ++;
        }
        localMaxes.add(max);
        while(idx < nums.length) {
            if(nums[idx] > max) {
                max = nums[idx];
                maxId = idx;
            } else if(idx >= maxId + k) {
                max = Integer.MIN_VALUE;
                int bench = maxId;
                for(int i = bench + 1; i <= bench + k; i ++) {
                    if(nums[i] > max) {
                        max = nums[i];
                        maxId = i;
                    }
                }
            }
            localMaxes.add(max);
            idx ++;
        }
        int[] rst = new int[localMaxes.size()];
        for(int i = 0; i < localMaxes.size(); i ++) {
            rst[i] = localMaxes.get(i);
        }
        return rst;
    }
}
