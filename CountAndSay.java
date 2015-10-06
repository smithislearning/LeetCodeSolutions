public class Solution {
    public HashMap<Integer, String> numMap = new HashMap<Integer, String>();
    {
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");
        numMap.put(10, "ten");
        numMap.put(11, "eleven");
        numMap.put(12, "twelve");
        numMap.put(13, "thirteen");
        numMap.put(14, "fourteen");
        numMap.put(15, "fifteen");
        numMap.put(16, "sixteen");
        numMap.put(17, "seventeen");
        numMap.put(18, "eighteen");
        numMap.put(19, "nineteen");
        numMap.put(20, "twenty");
        numMap.put(30, "thirty");
        numMap.put(40, "forty");
        numMap.put(50, "fifty");
        numMap.put(60, "sixty");
        numMap.put(70, "seventy");
        numMap.put(80, "eighty");
        numMap.put(90, "ninety");
        numMap.put(100, "hundred");
        numMap.put(1000, "thousand");
    }
    public String countAndSay(int n) {
        String wrk = Integer.toString(n);
        if(wrk.length() <= 1) {
            return wrk;
        }
        String rst = "";
        while(!wrk.isEmpty()) {
            int count = 1;
            boolean multi = false;
            while(count < wrk.length() && wrk.charAt(count) == wrk.charAt(count - 1)) {
                count++;
            }
            char wrkChar = wrk.charAt(count - 1);
            if(count == wrk.length()) {
                wrk = "";
            } else {
                wrk = wrk.substring(count);
            }
            if(!rst.isEmpty()) {
                rst+= " ";
            }
            if(count/1000 >= 1) {
                multi = true;
                rst += Integer.toString(count/1000) + numMap.get(1000);
                if(count/1000 > 1) {
                    rst += "s";
                }
                count -= count/1000;
            }
            if(count/100 >= 1) {
                multi = true;
                rst += Integer.toString(count/100) + numMap.get(100);
                if(count/100 > 1) {
                    rst += "s";
                }
                count -= count/100;
            }
            if(count/10 >= 1) {
                multi = true;
                rst += numMap.get(count/10);
                count -= count/10;
            }
            if(count >= 1) {
                if(count > 1) {
                    multi = true;
                }
                rst += numMap.get(count);
                count -= count;
            }
            rst += " " + wrkChar;
            if(multi == true) {
                rst += "s";
            }
        }
        return rst;
    }
}