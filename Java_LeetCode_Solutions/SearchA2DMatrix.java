public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] interval = new int[matrix.length];
        if(matrix.length == 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i++) {
            interval[i] = matrix[i][0];
        }
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int tgtRow = Arrays.binarySearch(interval, target);
        if(tgtRow >= 0 && Arrays.binarySearch(matrix[tgtRow], target) >= 0) {
            return true;
        }
        int searchRow = -tgtRow - 2;
        if(Arrays.binarySearch(matrix[searchRow], target) >= 0) {
            return true;
        }
        return false;
    }
}