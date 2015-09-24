public class Solution {
    public int longestValidParentheses(String s) {
        Stack<int[]> wrkStk = new Stack<int[]>();
        int rst = 0;
        int crt = 0;
        while(crt < s.length()) {
            if(s.charAt(crt) == '(') {
                int[] tmp = {crt, 0};
                wrkStk.push(tmp);
                crt++;
                continue;
            }
            if(s.charAt(crt) == ')') {
                if(wrkStk.empty() || wrkStk.peek()[1] == 1) {
                    int[] tmp = {crt, 1};
                    wrkStk.push(tmp);
                } else {
                    wrkStk.pop();
                    int crtLen = 0;
                    if(wrkStk.empty()) {
                        crtLen = crt + 1;
                    } else {
                        crtLen = crt - wrkStk.peek()[0];
                    }
                    rst = Math.max(rst, crtLen);
                }
                crt++;
                continue;
            }
            System.out.println("Illegal character dected!!!");
            return -1;
        }
        return rst;
    }
}