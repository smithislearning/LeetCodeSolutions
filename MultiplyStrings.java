import java.math.BigInteger;
public class Solution {
    public String multiply(String num1, String num2) {
        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);
        BigInteger bigRst = bigNum1.multiply(bigNum2);
        return bigRst.toString();
    }
}