import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
	public static void main(String[] args) {
		int input = 6;
		System.out.println(generateParenthesis(input));
	}
	public static List<String> generateParenthesis(int n) {
		List<String> rst = new ArrayList<String>();
		String wrk = "";
		if(n == 0) {
			return rst;
		}
		if(n == 1) {
			wrk = "()";
			rst.add(wrk);
		}
		if(n >=	2) {
			for(int i = 1; i < n / 2 + 1; i++) {
				int j = n - i;
				for(int a = 0; a < generateParenthesis(i).size(); a++) {
					for(int b = 0; b < generateParenthesis(j).size(); b++) {
						wrk += generateParenthesis(i).get(a) + generateParenthesis(j).get(b);
						rst.add(wrk);
						StringBuilder tmp = new StringBuilder(wrk);
						tmp.reverse();
						for(int z = 0; z < wrk.length(); z++) {
							if(wrk.charAt(z) == tmp.toString().charAt(z)) {

								for(int x = 0; x < tmp.length(); x++) {
									if(tmp.charAt(x) == '(') {
										tmp.setCharAt(x, ')');
									} else {
										tmp.setCharAt(x, '(');
									}
								}
								rst.add(tmp.toString());
								break;
							}
						}
						wrk = "";
					}
				}
			}
			for(int c = 0; c < generateParenthesis(n - 1).size(); c++) {
				wrk += "(" + generateParenthesis(n - 1).get(c) + ")";
				if(rst.contains(wrk)) {
					wrk = "";
					continue;
				} else {
					rst.add(wrk);
					wrk = "";
				}
			}
		}
		return rst;
	}
}