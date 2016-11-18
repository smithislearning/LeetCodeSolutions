public class TicTacToe {
    private char[][] board;
    

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = (player == 1) ? 'X' : 'O';
        boolean v = true, h = true;
        for(int i = 0; i < board.length; i ++) {
            if(board[i][col] != board[row][col]) {
                v = false;
            }
        }
        for(int j = 0; j < board[row].length; j ++) {
            if(board[row][j] != board[row][col]) {
                h = false;
            }
        }
        if(v || h) {
            return player;
        }
        if(row == col) {
            boolean d = true;
            for(int i = 0; i < board.length; i ++) {
                if(board[i][i] != board[row][col]) {
                    d = false;;
                }
            }
            if(d) {
                return player;
            }
        }
        if(row + col == board.length - 1) {
            boolean ad = true;
            for(int i = 0; i < board.length; i ++) {
                if(board[i][board.length - 1 - i] != board[row][col]) {
                    ad = false;
                }
            }
            if(ad) {
                return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
