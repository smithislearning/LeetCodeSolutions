public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board.length % 3 != 0 || board[0].length %3 != 0) {
            return;
        }
        HashMap<int[], HashSet> wrkMap = new Hashmap<int[], HashSet>();
        wrkMap = constructMap(board);
        while(!wrkMap.isEmpty()) {
            
            for()
        }
    }
    private HashMap constructMap(char[][] input) {
        HashMap<int[], HashSet> rstMap = new Hashmap<int[], HashSet>();
        for(int i = 0; i < board.length) {
            for(int j = 0; j < board[0].length) {
                if(input[i][j] == '.') {
                    int[] tmp = {i, j};
                    HashSet<Character> available = new HashSet<Character>();
                    for(int val = 0; val < 9; val++) {
                        available.add(val);
                    }
                    available = deleteUnavailable(board, tmp, board.length, board[0].length, available);
                    rstMap.put(tmp, available);
                }
            }
        }
        rstMap = deleteUnavailable()
        return rstMap;
    }
    private HashSet deleteUnavailabe(char[][] crtBrd, int[] crtPos, int hLen, int vLen, HashSet crtSet) {
        int hRg = crtPos[0] / 3;
        int vRg = crtPos[1] / 3;
        for(int h = 0; h < hLen; h++) {
            if(crtBrd[h][crtPos[1]] != '.') {
                crtSet.remove(crtBrd[h][crtPos[1]]);
            }
        }
        for(int v = 0; v < vLen; v++) {
            if(crtBrd[crtPos[0]][v] != '.') {
                crtSet.remove(crtBrd[crtPos[0]][v]);
            }
        }
        for(int h = 0; h < 3; h++) {
            for(int v = 0; v < 3; v++) {
                int hIdx = hRg + h;
                int vIdx = vRg = v;
                if(crtBrd[hIdx][vIdx] != '.') {
                    crtSet.remove(crtBrd[hIdx][vIdx]):
                }
            }
        }
        return crtSet;
    }
}