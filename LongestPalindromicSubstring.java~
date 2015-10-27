public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String input = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
		System.out.println(input);
		String output = longestPalindrome(input);
		System.out.println(output);
	}
	

	public static String longestPalindrome(String s) {
		String maxSub = "";
		int maxLength = 0;
		if(s.length() == 0) {
			return "Please give me something I can work with";
		}
		if(s.length() == 1) {
			return s;
		}
		for(int i = 0; i < s.length(); i++) {
			if(s.lastIndexOf(s.charAt(i)) > i) {
				String tmpSub = s.substring(i, s.lastIndexOf(s.charAt(i)) + 1);
				String tmpStr = palindrome(tmpSub);
				if(tmpStr.length() > maxLength) {
					maxLength = tmpStr.length();
					maxSub = tmpStr;
				}
			}
		}
		return maxSub;
	}
	private static String palindrome(String strIn) {
		String tmp = strIn;
		StringBuilder rev = new StringBuilder(strIn);
		rev.reverse();
		if(rev.toString().equals(strIn)) {
			return strIn;
		} else {
			return "";
		}
	}
}