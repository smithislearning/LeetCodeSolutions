public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) {
            if(n >= 0) {
                return x;
            } else {
                System.out.println("negative inifinity!");
                return Double.MIN_VALUE;
            }
        }
        if(n == 0) {
            return 1.0d;
        }
        if(n == 1) {
            return x;
        }
        if(n == -1) {
            return 1/x;
        }
        int pow = Math.abs(n);
        double tmpRst = myPow(x, pow/2);
        double rst = 0;
        if(pow % 2 == 0) {
            rst = tmpRst * tmpRst;
        } else {
            rst = tmpRst * tmpRst * x;
        }
        if(n < 0) {
            return 1 / rst;
        }
        return rst;
    }
}