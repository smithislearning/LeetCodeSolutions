public class Solution {
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if(n > 1) {
            for(int i = 2; i < n + 1; i++) {
                for(int k = 0; k < i; k++) {
                    count[i] += count[k]*count[i - 1 - k];
                }
            }
        }
        return count[n];
    }
}