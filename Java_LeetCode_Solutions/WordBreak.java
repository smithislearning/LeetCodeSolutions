public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] ref = new boolean[s.length() + 1];
        ref[0] = true;
        
		for(int i = 0; i < s.length() ; i++) {
		    if(!ref[i]) {
		        continue;
		    }
		    for(String wrk : wordDict) {
		        int len = wrk.length();
		        int end = i + len;
		        if(s.length() < end) {
		            continue;
		        }
		        if(ref[end]){
		            continue;
		        }
		        if(s.substring(i, end).equals(wrk)) {
		            ref[end] = true;
		        }
		    }
		}
		return ref[s.length()];
    }
}