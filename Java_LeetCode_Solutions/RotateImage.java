public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        if(matrix.length != matrix[0].length) {
            System.out.println("Not square matrix!!");
            return;
        }
        int tmp = Integer.MIN_VALUE;
        int mid = 0;
        while(mid < matrix.length) {
            for(int x = 1; x < mid + 1; x++) {
                tmp = matrix[mid - x][mid];
                matrix[mid - x][mid] = matrix[mid][mid - x];
                matrix[mid][mid - x] = tmp;
            }
            mid++;
        }
        int pre = 0;
        int after = matrix.length - 1;
        while(after > pre) {
            for(int i = 0; i < matrix[0].length; i++) {
                tmp = matrix[i][pre];
                matrix[i][pre] = matrix[i][after];
                matrix[i][after] = tmp;
            }
            pre++;
            after--;
        }
    }
}