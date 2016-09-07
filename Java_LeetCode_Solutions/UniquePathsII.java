public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int i = 0;
        int j = 0;
        int[][] paths=new int[m][n];
        while(i < m && obstacleGrid[i][0] != 1) {
            paths[i][0] = 1;
            i++;
        }
        while(i < m) {
            paths[i][0] = 0;
            i++;
        }
        while(j < n && obstacleGrid[0][j] != 1) {
            paths[0][j] = 1;
            j++;
        }
        while(j < n) {
            paths[0][j] = 0;
            j++;
        }
        
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j]=paths[i-1][j]+paths[i][j-1];
                }
            }
        }
        
        if(paths[m-1][n-1]<=0){
            return 0;
        }
        return paths[m-1][n-1];
    }
}