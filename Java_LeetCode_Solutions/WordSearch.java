public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(chkEst(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean chkEst(char[][] board, String word, int i, int j, int cNum) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if(board[i][j] == word.charAt(cNum)) {
            char tmp = word.charAt(cNum);
            if(cNum == word.length() - 1) {
                return true;
            }
            board[i][j] = '#';
            if(chkEst(board, word, i + 1, j, cNum + 1) || chkEst(board, word, i - 1, j, cNum + 1) || chkEst(board, word, i, j + 1, cNum + 1) || chkEst(board, word, i, j - 1, cNum + 1)) {
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
}