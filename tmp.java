public class tmp {
	public static void main(String[] args) {
		String input = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"; 
		String output = longestPalindrome(input);
		System.out.println(output);
	}
    public static String longestPalindrome(String s) {
    	    try {
    	    	    if(s == null || s.length() == 0) {
    	    	    	    throw new Exception("Please give me a String of something!");
    	    	    }
    	    } catch(Exception e) {
    	    	    System.out.println(e);
    	    }
    	    if(s.length() == 1) {
    	    	    return s;
    	    }
    	    System.out.println(s);
    	    StringBuilder revs = new StringBuilder(s);
    	    revs.reverse();
    	    String reverseS = revs.toString();
    	    if(s.equals(reverseS)) {
    	    	    return s;
    	    }
    	    String sub = null;
    	    int subLength = 0;
    	    for(int i = 0; i < s.length(); i++) {
    	    	    char tmp = s.charAt(i);
    	    	    if(i + reverseS.indexOf(tmp) + 1 == s.length()) {
    	    	    	    continue;
    	    	    } else {
    	    	    	    for(int m = s.lastIndexOf(tmp) + 1; m > i; m--) {
    	    	    	    	    String subA = s.substring(i, m);
   	    	    	    	    if(subA.length() <= subLength || subA.length() == 1) {
    	    	    	    	    	    break;
    	    	    	    	    } else {
    	    	    	    	    	    String subB = reverseS.substring(reverseS.length() - m, reverseS.length() - i);
    	    	    	    	    	    if(subA.equals(subB)) {
    	    	    	    	    	    	    System.out.println(subA);
    	    	    	    	    	    	    if(subA.length() > subLength) {
    	    	    	    	    	    	    	    sub = subA;
    	    	    	    	    	    	    	    subLength = subA.length();
    	    	    	    	    	    	    }
    	    	    	    	    	    	    break;
    	    	    	    	    	    }
    	    	    	    	    }
    	    	    	    }
    	    	    }
    	    }
    	    return sub;
    }
}