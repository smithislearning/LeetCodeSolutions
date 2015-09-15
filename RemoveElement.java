public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int indexA = 0;
		int indexB = nums.length - 1;
		while(indexA < indexB) {
			while(indexB > indexA && nums[indexB] == val) {
				indexB--;
			}
			if(nums[indexA] == val) {
				nums[indexA] = nums[indexB];
				nums[indexB] = val;
				indexA++;
				indexB--;
			} else {
				indexA++;
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == val) {
				return i;
			}
		}
		return nums.length;
	}
}