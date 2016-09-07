public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
		generate(rst, "", n, n);
		return rst;
	}
	
	private void generate(List<String> wrkLst, String wrkStr, int ket, int bra) {
		if(ket > bra) {
			return;
		} else if(ket == 0 && bra == 0) {
			wrkLst.add(wrkStr);
			return;
		}
		
		if(ket > 0) {
			generate(wrkLst, wrkStr + "(", ket - 1, bra);
		}
		
		if(bra > 0) {
			generate(wrkLst, wrkStr + ")", ket, bra - 1);
		}
	}
}