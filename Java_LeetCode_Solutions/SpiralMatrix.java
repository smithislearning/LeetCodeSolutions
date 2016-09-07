public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return rst;
        }
        if(matrix.length == 1) {
            for(int x : matrix[0]) {
                rst.add(x);
            }
            return rst;
        }
        if(matrix[0].length == 1) {
            for(int[] x : matrix) {
                rst.add(x[0]);
            }
            return rst;
        }
        int upperBound = -1;
        int lowerBound = matrix.length;
        int leftBound = -1;
        int rightBound = matrix[0].length;
        int i = upperBound + 1;
        int j = leftBound + 1;
        while(true) {
            while(j < rightBound) {
                rst.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            upperBound++;
            if(i == lowerBound) {
                break;
            }
            while(i < lowerBound) {
                rst.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            rightBound--;
            if(j == leftBound) {
                break;
            }
            while(j > leftBound) {
                rst.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            lowerBound--;
            if(i == upperBound) {
                break;
            }
            while(i > upperBound) {
                rst.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            leftBound++;
            if(j == rightBound) {
                break;
            }
        }
        return rst;
    }
}