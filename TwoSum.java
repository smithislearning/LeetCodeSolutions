import java.util.Arrays;
public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] origin = new int[nums.length];
        for(int x = 0; x < origin.length; x++){
            origin[x] = nums[x];
        }
        Arrays.sort(nums);
        for(int y : origin){
            System.out.print(y + ", ");
        }
        System.out.println(" ");
        for(int z : nums) {
            System.out.print(z + ", ");
        }
        System.out.println(" ");
        int[] result = {0,0};
        int a = 0;
        int b = 0;
        int tmpB = 0;
        for(int i = nums.length - 1; i > -1; i--) {
            if(nums[i] <= target){
                tmpB = Arrays.binarySearch(nums, target - nums[i]);
                System.out.println(tmpB);
                System.out.println(nums[i]);
                System.out.println(origin[0]);
                if(tmpB >= 0) {
                    a = Arrays.binarySearch(origin, nums[i]);
                    int tmpC = Arrays.binarySearch(origin, 0, a, nums[tmpB]);
                    if(tmpC >= 0) {
                        b = tmpC;
                    } else {
                        b = Arrays.binarySearch(origin, a + 1, origin.length, nums[tmpB]);
                    }
                    a++;
                    b++;
                    break;
                } else {
                    continue;
                }
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