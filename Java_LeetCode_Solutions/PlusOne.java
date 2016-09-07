import java.math.BigInteger;
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) {
            return digits;
        }
        StringBuilder input = new StringBuilder();
        for(int x : digits) {
            input.append(x);
        }
        BigInteger wrk = new BigInteger(input.toString());
        wrk = wrk.add(BigInteger.ONE);
        String rstStr = wrk.toString();
        int[] rst = new int[rstStr.length()];
        for(int i = 0; i < rst.length; i++) {
            rst[i] = Character.getNumericValue(rstStr.charAt(i));
        }
        return rst;
    }
}