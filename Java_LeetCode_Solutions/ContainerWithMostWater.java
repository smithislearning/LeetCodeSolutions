public class Solution {	
	public int maxArea(int[] height) {
	    if(height.length == 0) {
	        return 0;
	    } else {
	        int left = 0;
	        int right = height.length - 1;
	        int max = Math.min(height[left], height[right]) * (right - left);
	        while(left < right) {
	            int tmpval = Math.min(height[left], height[right]) * (right - left);
	            if(tmpval > max) {
	                max = tmpval;
	            }
	            if(height[left] < height[right]) {
	                left++;
	                continue;
	            } else {
	                right--;
	            }
	        }
	        return max;
	    }
	}
}