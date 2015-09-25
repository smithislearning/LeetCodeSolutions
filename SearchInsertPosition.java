public class Solution {
    public int searchInsert(int[] nums, int target) {
        int rst = Arrays.binarySearch(nums, target);
        if(rst < 0) {
            rst += 1;
            rst = - rst;
            return rst;
        }
        return rst;
    }
}