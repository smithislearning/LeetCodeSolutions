import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int[] wrkArys = nums;
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if(wrkArys.length < 4) {
			return  rst;
		}
		Arrays.sort(wrkArys);
		for(int i = 0; i < wrkArys.length - 3; i++) {
			if(i > 0 && wrkArys[i] == wrkArys[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < wrkArys.length - 2; j++) {
				if(j > i + 1 && wrkArys[j] == wrkArys[j - 1]) {
					continue;
				}
				int k = j + 1;
				int l = wrkArys.length - 1;
				while(k < l) {
					if(k > j + 1 && wrkArys[k] == wrkArys[k - 1]) {
						k++;
						continue;
					} else if(l < wrkArys.length - 2 && wrkArys[l] == wrkArys[l + 1]) {
						l--;
						continue;
					} else {
						int tmp = wrkArys[i] + wrkArys[j] + wrkArys[k] + wrkArys[l];
						if(tmp < target) {
							k++;
							continue;
						} else if(tmp == target) {
							List<Integer> rstCntnt = new ArrayList<Integer>();
							rstCntnt.add(wrkArys[i]);
							rstCntnt.add(wrkArys[j]);
							rstCntnt.add(wrkArys[k]);
							rstCntnt.add(wrkArys[l]);
							rst.add(rstCntnt);
							k++;
							l--;
							continue;
						} else if(tmp > target) {
							l--;
							continue;
						}
					}
				}
			}
		}
		return rst;
	}
}