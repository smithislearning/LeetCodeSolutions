public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0 || board.length * board[0].length % 9 != 0) {
            return false;
        }
        HashMap<Character, int[]> wrkHash = new HashMap<Character, int[]>();
        int hrztl = 0;
        int vrtcl = 0;
        while(hrztl < board.length) {
            for(int j = 0; j < board[0].length; j++) {
                int hIdx = hrztl;
                int vIdx = j;
                int[] tmp = {hIdx, vIdx};
                int[] tmpRst = wrkHash.put(board[hIdx][vIdx], tmp);
                if(board[hIdx][vIdx] != '.' && tmpRst != null) {
                    return false;
                }
            }
            wrkHash.clear();
            hrztl++;
        }
        hrztl = 0;
        while(vrtcl < board[0].length) {
            for(int i = 0; i < board.length; i++) {
                int hIdx = i;
                int vIdx = vrtcl;
                int[] tmp = {hIdx, vIdx};
                int[] tmpRst = wrkHash.put(board[hIdx][vIdx], tmp);
                if(board[hIdx][vIdx] != '.' && tmpRst != null) {
                    return false;
                }
            }
            wrkHash.clear();
            vrtcl++;
        }
        vrtcl = 0;
        while(hrztl < board.length) {
            while(vrtcl < board[0].length) {
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        int hIdx = hrztl + i;
                        int vIdx = vrtcl + j;
                        int[] tmp = {hIdx, vIdx};
                        int[] tmpRst = wrkHash.put(board[hIdx][vIdx], tmp);
                        if(board[hIdx][vIdx] != '.' && tmpRst != null) {
                            return false;
                        }
                    }
                }
                wrkHash.clear();
                vrtcl += 3;
            }
            vrtcl = 0;
            wrkHash.clear();
            hrztl += 3;
        }
        return true;
    }
}