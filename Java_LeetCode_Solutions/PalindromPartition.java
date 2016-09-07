import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class PalindromPartition {
	public static void main(String[] args) {
		List<List<String>> result = partition(args[0]);
		System.out.println(result);
	}
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(s == null || s.length() == 0) {
			return result;
		}
		List<String> content = new ArrayList<String>();
		if(s.length() == 1) {
			content.add(s);
			result.add(content);
			return result;
		}
		for(int i = 0; i < s.length(); i++) {
			content.add(s.substring(i, i + 1));
		}
		result.add(content);
		
		for(int length = 2; length < s.length() + 1; length++) {
			int init = 0;
			while(init + length < s.length() + 1) {
				StringBuilder strBd = new StringBuilder(s.substring(init, init + length));
				String str = strBd.toString();
				System.out.println(str);
				
				if(str.equals(strBd.reverse().toString())) {
					int size = result.size();
					System.out.println(str);
					for(int i = 0; i < size; i++) {
						content = new ArrayList<String>();
						content.addAll(result.get(i));
						System.out.println(content);
						int posLength = 0;
						int pos = 0;
						int endPos = 0;
						for(String x : content) {
							if(posLength < init + length) {
								if(posLength < init) {
									pos++;
								}
								posLength += x.length();
								endPos++;
							} else {
								break;
							}
						}
						StringBuilder tmpStrBd = new StringBuilder();
						for(int j = pos; j < endPos; j++) {
							tmpStrBd.append(content.get(j));
						}
						if(str.equals(tmpStrBd.toString())) {
							for(int j = pos; j < endPos; j++) {
								content.remove(pos);
							}
							content.add(pos, str);
							System.out.println(content);
							System.out.println("");
							if(!result.contains(content)) {
								result.add(content);
							}
							if(str.length() == s.length()) {
								break;
							}
						}
					}
				}
				init ++;
			}
		}
		return result;
	}
}