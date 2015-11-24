public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        try {
            if(nums1.length < (m + n)) {
                throw new ArrayIndexOutOfBoundsException();
            }
        } catch(Exception e) {
            System.out.println(e);
            return;
        }
        if(m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n == 0) {
            return;
        }
        if(nums1[0] >= nums2[n - 1]) {
            for(int i = 0; i < m; i++) {
                nums1[m + n - 1 - i] = nums1[m - 1 - i];
            }
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if(nums1[m - 1] <= nums2[0]) {
            for(int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            return;
        }
        int p1 = 0;
        int p2 = 0;
        int j = 0;
        int[] tmp = new int[m];
        for(int i = 0; i < m; i++) {
            tmp[i] = nums1[i];
        }
        while(p1 < m && p2 < n) {
            if(tmp[p1] <= nums2[p2]) {
                nums1[j] = tmp[p1];
                p1++;
            } else {
                nums1[j] = nums2[p2];
                p2++;
            }
            j++;
        }
        if(p1 < m) {
            while(p1 < m) {
                nums1[j] = tmp[p1];
                j++;
                p1++;
            }
            return;
        }
        if(p2 < n) {
            while(p2 < n) {
                nums1[j] = nums2[p2];
                j++;
                p2++;
            }
            return;
        }
    }
}