public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
			return nums.length;
		}
		if(nums.length == 2) {
			if(nums[0] == nums[1]) {
				return 1;
			} else {
				return nums.length;
			}
		}
		int pt1 = 1;
		int pt2 = 2;
		int wrk = nums[0];
		while(pt2 < nums.length && pt1 < pt2) {
			if(nums[pt2] == wrk) {
				pt2++;
			} else if(nums[pt1] > wrk) {
				wrk = nums[pt1];
				pt1++;
				pt2++;
			} else if(nums[pt1] <= wrk && nums[pt1] < nums[pt2]) {
				nums[pt1] = nums[pt2];
				nums[pt2] = wrk;
				wrk = nums[pt1];
				pt1++;
				pt2++;
			}
				
		}
		int rst = 0;
		while(rst < nums.length - 1 && nums[rst] < nums[rst + 1]) {
			rst++;
		}
		rst++;
		return rst;
	}
}