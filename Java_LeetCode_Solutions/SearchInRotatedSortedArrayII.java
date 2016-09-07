public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length < 1) {
            return false;
        }
        int piv = 0;
        while(piv < nums.length - 1 && nums[piv] <= nums[piv + 1]) {
            piv++;
        }
        if(piv == nums.length - 1) {
            if(Arrays.binarySearch(nums, target) >= 0) {
                return true;
            }
            return false;
        }
        int[] largePt = Arrays.copyOfRange(nums, 0, piv + 1);
        int[] smallPt = Arrays.copyOfRange(nums, piv + 1, nums.length);
        int smallSearch = Arrays.binarySearch(smallPt, target);
        if(smallSearch >= 0) {
            return true;
        }
        if(smallSearch == -1) {
            return false;
        }
        int largeSearch = Arrays.binarySearch(largePt, target);
        if(largeSearch >= 0) {
            return true;
        }
        return false;
    }
}