public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        int tmp = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j =i + 1; j < nums.length; j++) {
                if(nums[i] >= nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}