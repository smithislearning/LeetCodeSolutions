public class Solution {
    private final String[] REF = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	private int[] idxAry;
	private List<String> rst = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
	    if(digits.length() == 0 || digits.contains("0") || digits.contains("1")) {
	        return rst;
	    }
		idxAry = new int[digits.length()];
		for(int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			idxAry[i] = index - 2;
		}
		StringBuilder rstCnt = new StringBuilder();
		rstCnt = working(rstCnt, 0);
		return rst;
	}
	public StringBuilder working(StringBuilder sbIn, int index) {
		for(int i = 0; i < REF[idxAry[index]].length(); i++) {
			sbIn.delete(index, sbIn.length());
			sbIn.append(REF[idxAry[index]].charAt(i));
			if(index < idxAry.length - 1) {
				int fIndex = index + 1;
				sbIn.append(working(sbIn, fIndex));
			} else {
				rst.add(sbIn.toString());
				System.out.println(sbIn.toString());
			}
		}
		return sbIn;
	}
}