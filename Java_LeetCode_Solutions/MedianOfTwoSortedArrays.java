import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] input1 = {1, 2, 3};
		int[] input2 = {2, 3, 4, 5};
/**		for(int x : input1) {
			System.out.print(x + ", ");
		}
		System.out.println("");
		for(int x : input2) {
			System.out.print(x + ", ");
		}
		System.out.println("");
**/		double output = findMedianSortedArrays(input1, input2);
		System.out.println(output);
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		for(int x : nums1) {
			System.out.print(x + ", ");
		}
		System.out.println("");
		for(int x : nums2) {
			System.out.print(x + ", ");
		}
		System.out.println("");
		if(nums1.length == nums2.length) {
			int lenNum = nums1.length;
			if(lenNum == 0) {
				return 0.0;
			} else if(lenNum == 1) {
				return ((double)(nums1[0] + nums2[0]) / 2);
			} else if(lenNum == 2) {
				return (Math.max((double) nums1[0], (double) nums2[0]) +
					Math.min((double) nums1[1], (double) nums2[1])) / 2;
			} else {
				if(nums1[(nums1.length - 1) / 2] <= nums2[(nums2.length - 1) / 2]) {
					nums1 = Arrays.copyOfRange(nums1, (nums1.length - 1) / 2, nums1.length);
					nums2 = Arrays.copyOfRange(nums2, 0, (nums2.length - 1) / 2 + 1);
					return findMedianSortedArrays(nums1, nums2);
				} else {
					nums2 = Arrays.copyOfRange(nums2, (nums2.length - 1) / 2, nums2.length);
					nums1 = Arrays.copyOfRange(nums1, 0, (nums1.length - 1) / 2 + 1);
					return findMedianSortedArrays(nums1, nums2);
				}
			}
		} else {
			int[] shNum = nums1;
			int[] lgNum = nums2;
			if(nums1.length > nums2.length) {
				shNum = nums2;
				lgNum = nums1;
			}
			if(shNum.length == 0) {
				return getMedian(lgNum);
			} else if(shNum.length == 1 && lgNum.length % 2 == 0) {
				int[] wrkAry = {lgNum[(lgNum.length - 1) / 2], lgNum[(lgNum.length) / 2], 
				shNum[0]};
				Arrays.sort(wrkAry);
				return getMedian(wrkAry);
			} else if(shNum.length == 1 && lgNum.length % 2 != 0) {
				int[] wrkAry = {lgNum[(lgNum.length - 1) / 2 - 1],
					lgNum[(lgNum.length - 1) / 2], lgNum[(lgNum.length - 1) / 2 + 1], 
				shNum[0]};
				Arrays.sort(wrkAry);
				return getMedian(wrkAry);
			} else if(shNum.length == 2 && lgNum.length % 2 == 0) {
				int[] wrkAry = {lgNum[(lgNum.length - 1) / 2], 
					lgNum[(lgNum.length - 1) / 2 + 1], 
					(int) Math.max(shNum[0], lgNum[(lgNum.length - 1) / 2 - 1]), 
				(int) Math.min(shNum[1], lgNum[(lgNum.length - 1) / 2 + 1])};
				Arrays.sort(wrkAry);
				return getMedian(wrkAry);
			} else if(shNum.length == 2 && lgNum.length % 2 != 0) {
				int[] wrkAry = {lgNum[(lgNum.length - 1) / 2],
					(int) Math.max(shNum[0], lgNum[(lgNum.length - 1) / 2 - 1]), 
				(int) Math.min(shNum[1], lgNum[(lgNum.length - 1) / 2 + 1])};
				Arrays.sort(wrkAry);
				return getMedian(wrkAry);
			} else {
				if(shNum[(shNum.length - 1) / 2] <= lgNum[(lgNum.length - 1) / 2]) {
					shNum = Arrays.copyOfRange(shNum, (shNum.length - 1) / 2, shNum.length);
					lgNum = Arrays.copyOfRange(lgNum, 0, (lgNum.length - 1) / 2 + 1);
					return findMedianSortedArrays(shNum, lgNum);
				} else {
					lgNum = Arrays.copyOfRange(lgNum, (lgNum.length - 1) / 2, lgNum.length);
					shNum = Arrays.copyOfRange(shNum, 0, (shNum.length - 1) / 2 + 1);
					return findMedianSortedArrays(shNum, lgNum);
				}
			}
		}
	}
	public static double getMedian(int[] input) {
		if(input.length % 2 != 0) {
			return (double) input[(input.length - 1) /2];
		} else {
			return ((double) (input[(input.length - 1) / 2] + input[(input.length - 1) / 2 + 1])) / 2;
		}
	}
}