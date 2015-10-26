public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        boolean[] ref = {false, false};
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                ref[0] = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                ref[1] = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0, matrix[i].length, 0);
            }
        }
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                setColZero(matrix, j);
            }
        }
        if(ref[0] == true) {
            Arrays.fill(matrix[0], 0, matrix[0].length, 0);
        }
        if(ref[1] == true) {
            setColZero(matrix, 0);
        }
    }
    private void setColZero(int[][] wrkMtx, int input) {
        for(int i = 0; i < wrkMtx.length; i++) {
            wrkMtx[i][input] = 0;
        }
    }
}