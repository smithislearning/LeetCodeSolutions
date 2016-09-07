public class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        int y = 1;
        while(x / y >= y) {
            y++;
        }
        y--;
        return y;
    }
}