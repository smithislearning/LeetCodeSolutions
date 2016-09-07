public class Solution {
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		if(num <= 0) {
			return result.toString();
		} else {
			int[] unitList = {1000, 500, 100, 50, 10, 5, 1};
			char[] rmList = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
			int inPut = num;
			outer:
			for(int u = 0; u < unitList.length; u++) {
				int a = 0;
				if(inPut >= 900 && inPut < 1000) {
					u = 2;
					a = 0;
				} else if(inPut >= 90 && inPut < 100) {
					u = 4;
					a = 2;
				} else if(inPut == 9) {
					u = 6;
					a = 4;
				} else if(u > 0) {
					a = u - 1;
				} else {
					a = 0;
				}
				int tmp = inPut / unitList[u];
				if(tmp == 0) {
					continue;
				} else if(tmp == 1) {
					result.append(rmList[u]);
					inPut -= tmp * unitList[u];
					continue;
				} else if(tmp > 1) {
					if(u > 0) {
						for(int i = unitList.length - 1; i >= u; i--) {
							if(tmp * unitList[u] + unitList[i] >= unitList[a]) {
								result.append(rmList[i]);
								result.append(rmList[a]);
								inPut -= tmp * unitList[u];
								u = i;
								tmp = 0;
								break;
							}
						}
					}
					for(int i = 0; i < tmp; i++) {
						result.append(rmList[u]);
					}
					inPut -= tmp * unitList[u];
				}
			}
		}
		return result.toString();
	}
}