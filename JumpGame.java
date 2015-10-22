public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        ArrayList<Boolean> bench = new ArrayList<Boolean>();
        for(int i = 0; i < nums.length; i++) {
            boolean val = false;
            bench.add(val);
        }
        bench.set(0, true);
        int pos = 0;
        while (bench.get(pos) == true) {
            int dest = pos + nums[pos];
            if(dest > pos) {
                if(dest >= nums.length) {
                    dest = nums.length - 1;
                }
                if(bench.get(dest) == false) {
                    for(int j = pos; j < dest + 1; j++) {
                        bench.set(j, true);
                    }
                }
            }
            if(bench.get(nums.length - 1) == true) {
                return true;
            }
            pos++;
        }
        return false;
    }
}