public class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[i].length; j ++) {
                if(grid[i][j] == '1') {
                    numOfIslands ++;
                    process(i, j, grid);
                }
            }
        }
        return numOfIslands;
    }
    private void process(int i, int j, char[][] grid) {
        if(grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '\0';
        if(i > 0) {
            process(i - 1, j, grid);
        }
        if(i < grid.length - 1) {
            process(i + 1, j, grid);
        }
        if(j > 0) {
            process(i, j - 1, grid);
        }
        if(j < grid[i].length - 1) {
            process(i, j + 1, grid);
        }
    }
}
