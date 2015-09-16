public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(dividend == divisor) {
			return 1;
		}
		if(divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		long pDvnt = Math.abs((long) dividend);
		long pDvsr = Math.abs((long) divisor);
		int rst = 0;
		while(pDvnt >= pDvsr) {
			int sft = 0;
			while(pDvnt >= pDvsr<<sft) {
				sft++;
			}
			rst += 1<<(sft - 1);
			pDvnt -= (pDvsr<<(sft - 1));
		}
		if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return rst;
		} else {
			return -rst;
		}
	}
}