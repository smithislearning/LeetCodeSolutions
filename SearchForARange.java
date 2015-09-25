public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rst = {-1, -1};
        int tmpRst = Arrays.binarySearch(nums, target);
        if(tmpRst < 0) {
            return rst;
        }
        int left = tmpRst;
        int right = tmpRst;
        while(left > 0 && nums[left - 1] == target) {
            left--;
        }
        while(right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        rst[0] = left;
        rst[1] = right;
        return rst;
    }
}