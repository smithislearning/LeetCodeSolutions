import java.math.BigInteger;
public class Solution {
    public String addBinary(String a, String b) {
        BigInteger aBig = new BigInteger(a, 2);
        BigInteger bBig = new BigInteger(b, 2);
        BigInteger rst = aBig.add(bBig);
        return rst.toString(2);
    }
}