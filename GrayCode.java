public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        if(n < 1) {
            rst.add(0);
            return rst;
        }
        if(n < 2) {
            rst.add(0);
            rst.add(1);
            return rst;
        }
        rst = grayCode(n - 1);
        int size = rst.size() - 1;
        rst.add((int)Math.pow(2, n - 1) + rst.get(size));
        for(int i = 0; i < size; i++) {
            rst.add(rst.get(rst.size() - 1) - (rst.get(size - i) - rst.get(size - i - 1)));
        }
        return rst;
    }
}