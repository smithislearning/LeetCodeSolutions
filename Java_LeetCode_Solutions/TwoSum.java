import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> origin = new ArrayList<Integer>();
        for(int x = 0; x < nums.length; x++){
            origin.add(nums[x]);
        }
        Arrays.sort(nums);
        int[] result = {0,0};
        int a = 0;
        int b = 0;
        int tmpB = 0;
        for(int i = nums.length - 1; i > -1; i--) {
            tmpB = Arrays.binarySearch(nums, target - nums[i]);
            if(tmpB >= 0) {
                a = origin.lastIndexOf(nums[i]);
                b = origin.indexOf(nums[tmpB]);
                if(a == b) {
                    origin.remove(nums[i]);
                    b = origin.indexOf(nums[tmpB]) + 1;
                }
                a++;
                b++;
                break;
            } else {
                continue;
            }
        }
        try{
            if(tmpB < 0) {
                throw new Exception("Alert!!! No Match!!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if(a > b) {
            result[0] = b;
            result[1] = a;
        } else {
            result[0] = a;
            result[1] = b;
        }
        return result;
    }
}