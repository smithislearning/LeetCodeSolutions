public class Solution {
    public int climbStairs(int n) {
        if(n < 1) {
            return 0;
        }
        if(n < 2) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] wrk = new int[n];
        wrk[0] = 1;
        wrk[1] = 2;
        for(int i = 2; i < n; i++) {
            wrk[i] = wrk[i - 1] + wrk[i - 2];
        }
        return wrk[n - 1];
    }
}