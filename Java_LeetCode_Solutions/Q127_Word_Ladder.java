public class Solution {
    class Word {
        public String val;
        public int step;
        public Word(String val, int step) {
            this.val = val;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<Word> que = new LinkedList<Word> ();
        que.add(new Word(beginWord, 1));
        while(!que.isEmpty()) {
            Word wrk = que.remove();
            String str = wrk.val;
            if(str.equals(endWord)) {
                return wrk.step;
            }
            char[] charArry = str.toCharArray();
            for(int i = 0; i < charArry.length; i ++) {
                char tmp = charArry[i];
                for(char tmpChar = 'a'; tmpChar <= 'z'; tmpChar ++) {
                    charArry[i] = tmpChar;
                    String tmpStr = new String(charArry);
                    if(wordList.contains(tmpStr)) {
                        que.add(new Word(tmpStr, wrk.step + 1));
                        wordList.remove(tmpStr);
                    }
                }
                charArry[i] = tmp;
            }
        }
        return 0;
    }
}
