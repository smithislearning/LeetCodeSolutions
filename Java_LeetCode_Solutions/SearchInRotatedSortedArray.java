public class Solution {
    public int search(int[] nums, int target) {
        Stack<int[]> pivots = new Stack<int[]>();
        pivots.clear();
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                int[] tmp = {i - 1, nums[i - 1]};
                pivots.push(tmp);
            }
        }
        int[] a = {nums.length - 1, nums[nums.length - 1]};
        pivots.push(a);
        if(pivots.empty()) {
            if(Arrays.binarySearch(nums, target) < 0) {
                return -1;
            }
            return Arrays.binarySearch(nums, target);
        }
        int head = 0;
        int tail = nums.length - 1;
        while(!pivots.empty() && pivots.peek()[1] < target) {
            pivots.pop();
        }
        if(pivots.empty()) {
            return -1;
        }
        tail = pivots.peek() [0];
        System.out.println(tail);
        pivots.pop();
        if(!pivots.empty()) {
            head = pivots.peek()[0] + 1;
        }
        int[] wrk = Arrays.copyOfRange(nums, head, tail + 1);
        if(Arrays.binarySearch(wrk, target) < 0) {
            return -1;
        }
        return head + Arrays.binarySearch(wrk, target);
    }
}
        