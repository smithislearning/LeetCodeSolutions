public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board.length % 3 != 0 || board[0].length %3 != 0) {
            return;
        }
        HashMap<int[], ArrayList> crtMap = new HashMap<int[], ArrayList>();
        crtMap = constructMap(board);
        while(!crtMap.isEmpty()) {
            for(int[] tmpPos : crtMap.keySet()) {
                if(crtMap.get(tmpPos).size() == 1) {
                    board[tmpPos[0]][tmpPos[1]] = (char) crtMap.get(tmpPos).get(0);
                    crtMap.remove(tmpPos);
                    crtMap = deleteUnavailable(crtMap, board);
                }
            }
        }
    }
    private HashMap constructMap(char[][] input) {
        HashMap<int[], ArrayList> rstMap = new HashMap<int[], ArrayList>();
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                if(input[i][j] == '.') {
                    int[] tmp = {i, j};
                    ArrayList<Character> available = new ArrayList<Character>();
                    for(int val = 1; val < 10; val++) {
                        available.add((char)(val + 48));
                    }
                    rstMap.put(tmp, available);
                }
            }
        }
        rstMap = deleteUnavailable(rstMap, input);
        return rstMap;
    }
    private HashMap<int[], ArrayList> deleteUnavailable(HashMap<int[], ArrayList> wrkMap, char[][] crtBrd) {
        for(int[] wrkPos : wrkMap.keySet()) {
            ArrayList<Character> crtList = wrkMap.get(wrkPos);
            if(crtList.size() == 0) {
                wrkMap.remove(wrkPos);
            } else {
                for(int i = 0; i < crtBrd.length; i++) {
                    char tmp = crtBrd[i][wrkPos[1]];
                    if(crtList.contains(tmp)) {
                        crtList.remove(crtList.indexOf(tmp));
                    }
                }
                for(int j = 0; j < crtBrd[0].length; j++) {
                    char tmp = crtBrd[wrkPos[0]][j];
                    if(crtList.contains(tmp)) {
                        crtList.remove(crtList.indexOf(tmp));
                    }
                }
                int hrztl = wrkPos[0] / 3;
                int vrtcl = wrkPos[1] / 3;
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        char tmp = crtBrd[hrztl + i][vrtcl + j];
                        if(crtList.contains(tmp)) {
                            crtList.remove(crtList.indexOf(tmp));
                        }
                    }
                }
                if(crtList.size() == 0) {
                    wrkMap.remove(wrkPos);
                }
            }
        }
        return wrkMap;
    }
}