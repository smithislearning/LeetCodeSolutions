public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        		try {
			if(nums.length < 3) {
				throw new Exception("Insufficient number of elements.");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		int minDif = Integer.MAX_VALUE;
		int rst = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < nums.length - 1; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for(int k = j + 1; k < nums.length; k++) {
					int tmp = nums[i] + nums[j] + nums[k];
					int dif = Math.abs(tmp - target);
					if(dif > minDif && tmp < target) {
						continue;
					} else if(dif > minDif && tmp > target) {
						break;
					} else if(dif < minDif) {
						minDif = dif;
						rst = tmp;
					} else {
						continue;
					}
				}
			}
		}
		return rst;
	}
}