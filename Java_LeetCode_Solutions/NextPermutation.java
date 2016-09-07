public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return;
        }
        int head = -1;
        int tail = -1;
        int tmp = -1;
        for(int i = nums.length - 2; i > -1; i--) {
            if(nums[i] < nums[i + 1]) {
                head = i;
                break;
            }
        }
        if(head != -1) {
            for(int i = nums.length - 1; i > head; i--) {
                if(nums[i] > nums[head]) {
                    tail = i;
                    break;
                }
            }
            tmp = nums[tail];
            nums[tail] = nums[head];
            nums[head] = tmp;
            head++;
        } else {
            head = 0;
        }
        tail = nums.length - 1;
        while(head < tail) {
            tmp = nums[tail];
            nums[tail] = nums[head];
            nums[head] = tmp;
            head++;
            tail--;
        }
    }
}