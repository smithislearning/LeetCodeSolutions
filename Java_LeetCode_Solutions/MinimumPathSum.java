public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int rst = 0;
        int m = grid.length;                              
        int n = grid[0].length;
        if(m == 1) {
            for(int j = 0; j < n; j++) {
                rst += grid[0][j];
            }
            return rst;
        }
        if(n == 1) {
            for(int i = 0; i < m; i++) {
                rst += grid[i][0];
            }
            return rst;
        }
        int[][] ref = new int[m][n];
        ref[0][0] = grid[0][0];
        for(int j = 1; j < n; j++) {
            ref[0][j] = ref[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            ref[i][0] = ref[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(ref[i - 1][j] <= ref[i][j - 1]) {
                    ref[i][j]  = ref[i - 1][j] + grid[i][j];
                } else {
                    ref[i][j] = ref[i][j - 1] + grid[i][j];
                }
            }
        }
        return ref[m - 1][n - 1];
    }
}