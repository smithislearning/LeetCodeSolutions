import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
	public static void main(String[] args) {
		String input = "23";
		System.out.println(input);
		List<String> output = letterCombinations(input);
		System.out.println(output);
	}
	private static final String[] REF = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	private static int[] idxAry;
	private static List<String> rst = new ArrayList<String>();
	public static List<String> letterCombinations(String digits) {
		idxAry = new int[digits.length()];
		for(int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			idxAry[i] = index - 2;
		}
		StringBuilder rstCnt = new StringBuilder();
		rstCnt = working(rstCnt, 0);
		return rst;
	}
	public static StringBuilder working(StringBuilder sbIn, int index) {
		for(int i = 0; i < REF[idxAry[index]].length(); i++) {
			System.out.println(i);
			sbIn.append(REF[idxAry[index]].charAt(i));
			if(index < idxAry.length - 1) {
				index++;
				sbIn.append(working(sbIn, index));
			} else {
				rst.add(sbIn.toString());
				sbIn.delete(0, sbIn.length());
			}
		}
		return sbIn;
	}
}