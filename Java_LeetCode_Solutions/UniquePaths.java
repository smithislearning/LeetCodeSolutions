public class Solution {
    public int uniquePaths(int m, int n) {
        int i,j;
        int[][] paths=new int[m][n];
        for(i=0; i<m; i++){
            paths[i][0]=1;
        }
        for(j=0; j<n; j++){
            paths[0][j]=1;
        }
        
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                paths[i][j]=paths[i-1][j]+paths[i][j-1];
            }
        }
        
        if(paths[m-1][n-1]<=0){
            return 0;
        }
        return paths[m-1][n-1];
    }
}