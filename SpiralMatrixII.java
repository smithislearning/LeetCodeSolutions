public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int rec = 1;
        int cntnt = 1;
        int i = 0;
        int j = 0;
        while(n - rec > 0) {
            while(j < n - rec) {
                rst[i][j] = cntnt;
                cntnt++;
                j++;
            }
            while(i < n - rec) {
                rst[i][j] = cntnt;
                cntnt++;
                i++;
            }
            while(j > rec - 1) {
                rst[i][j] = cntnt;
                cntnt++;
                j--;
            }
            while(i > rec - 1) {
                rst[i][j] = cntnt;
                cntnt++;
                i--;
            }
            i++;
            j++;
            rec++;
        }
        if(n % 2 == 1) {
            int pos = (n - 1) / 2;
            rst[pos][pos] = cntnt;
        }
        return rst;
    }
}