public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if(nums.length < 3 || nums[0] > 0 || (nums[0] ==0 && nums[1] > 0) || (nums[0] == 0 && nums[1] == 0 && nums[2] > 0)) {
			System.out.println("No sub content satisfying requirements found.");
			return result;
		} else {
			if(nums[0] == 0 && nums[1] ==0 && nums[2] ==0) {
				List<Integer> rstCnt = new ArrayList<Integer>();
				for(int i = 0; i < 3; i++) {
					rstCnt.add(0);
				}
				result.add(rstCnt);
				return result;
			} else {
				int i = 0;
				while(i < nums.length && nums[i] <= 0) {
					if(i > 0 && nums[i] == nums[i - 1]) {
						i++;
						continue;
					}
					for(int j = i + 1; j < nums.length - 1; j++) {
					    if(j > i + 1 && nums[j] == nums[j - 1]) {
							continue;
						}
						for(int k = nums.length - 1; k > j; k--) {
							int tmp = -(nums[i] + nums[j]);
							if(tmp > nums[k]) {
								break;
							} else if(tmp == nums[k]) {
								List<Integer> rstCnt = new ArrayList<Integer>();
								rstCnt.add(nums[i]);
								rstCnt.add(nums[j]);
								rstCnt.add(nums[k]);
								result.add(rstCnt);
								break;
							} else {
								continue;
							}
						}
					}
					i++;
				}
				return result;
			}
		}
	}
}