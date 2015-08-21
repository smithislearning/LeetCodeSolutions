import java.util.Arrays;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //If both of the arrays are empty, throw an exception.
    	try {
            if(nums1.length == 0 && nums2.length == 0) {
                throw new Exception("Please give me at least one non-empty array.~~");
            }
        } catch(Exception e) {
                System.out.println(e);
        }
        double midVal = 0.0;
        int midIndex = 0;
        //If one of the arrays is empty, return the median of that non empty one.
        if(nums1.length == 0 && nums2.length != 0) {
            midIndex = (nums2.length - 1) / 2;
            midVal = (double) nums2[midIndex];
            if(nums2.length % 2 == 0) {
                midVal = ((double) (nums2[midIndex] + nums2[midIndex + 1])) / 2.0;
            }
            return midVal;
        } else if(nums2.length == 0 && nums1.length != 0) {
            midIndex = (nums1.length - 1) / 2;
            midVal = (double) nums1[midIndex];
            if(nums1.length % 2 == 0) {
                midVal = ((double) (nums1[midIndex] + nums1[midIndex + 1])) / 2.0;
            }
            return midVal;
        }
        int mid1 = (nums1.length - 1) / 2;	//mid1 is midle index of nums1
        int mid2 = (nums2.length - 1) / 2;	//mid2 is midle index of nums2
        int mida = mid1;
        int midb = mid2;
        int[] a = nums1;
        int[] b = nums2;
        //To make sure mida is a smaller one and a is the array with a smaller median.
        if(nums1[mid1] > nums2[mid2]) {
            a = nums2;
            b = nums1;
            mida = mid2;
            midb = mid1;
        }
        //bLoBound is the index of the first element in array b greater than a[mida].
        int bLoBound = loBound(a[mida], b, midb);
        if(b[bLoBound] < a[mida]) {
        	bLoBound++;
        }
        //aHiBound is the index of the first elemtn in array b smaller than b[midb].
        int aHiBound = hiBound(b[midb], a, mida);
        if(a[aHiBound] > b[midb]) {
        	aHiBound--;
        }
        //subA is an array of elements between a[mida] and b[midb] in array a.
        int[] subA = Arrays.copyOfRange(a, mida, aHiBound + 1);
        //subB is an array of element between a[mida] and b[midb] in array b.
        int[] subB = Arrays.copyOfRange(b, bLoBound, midb + 1);
        int left = mida + bLoBound;
        //resultant is the array of all element between a[mida] and b[midb] (including both of them).
        int[] resultant = midMerge(subA, subB);
//        System.out.println(Arrays.toString(resultant));
        int rLength = a.length + b.length;
        midIndex = rLength / 2 - left - 1;
        midVal = (double) resultant[midIndex];
        int tmp = 0;
        if(aHiBound < a.length - 1 && midb < b.length - 1) {
        	tmp = a[aHiBound + 1];
        	if(b[midb + 1] >= tmp) {
        		tmp = b[midb + 1];
        	}
        } else if(aHiBound == a.length - 1 && midb < b.length - 1) {
        	tmp = b[midb + 1];
        } else if(aHiBound < a.length - 1 && midb == b.length - 1) {
        	tmp = a[aHiBound + 1];
        }
        if(rLength % 2 == 0) {
        	if(midIndex == resultant.length - 1) {
        		midVal = ((double)(resultant[midIndex] + tmp)) / 2.0;
        	} else {
        		midVal = ((double) (resultant[midIndex] + resultant[midIndex + 1])) / 2.0;
        	}
        }
        return midVal;
    }
    //loBound returns the index of the first element greater than lowRef in inputArray.
    private int loBound(int lowRef, int[] inputArray, int bRef) {
        int tmpLo = search(lowRef, inputArray, 0, bRef);
        if(inputArray[tmpLo] < lowRef) {
            tmpLo++;
        } else if(inputArray[tmpLo] == lowRef && tmpLo > 0) {
        	tmpLo--;
        }
        return tmpLo;
    }
    //hiBound returns the index of the first element smaller than hiRef in inputArray.
    private int hiBound(int hiRef, int[] inputArray, int bRef) {
        int tmpHi = search(hiRef, inputArray, bRef, inputArray.length - 1);
        if(inputArray[tmpHi] > hiRef) {
            tmpHi--;
        } else if(inputArray[tmpHi] == hiRef && tmpHi < inputArray.length - 1) {
        	tmpHi++;
        }
        return tmpHi;
    }
    //midMerge returns the sorted array of all elements in inputLo and inputHi.
    private int[] midMerge(int[] inputLo, int[] inputHi) {
    	//result is the sorted array of all elements in inputLo and inputHi to be returned.
        int[] result = new int[inputLo.length + inputHi.length];
        //if there is no overlapping, just return a sorted array of all elements from both arrays.
        if(inputLo[inputLo.length - 1] <= inputHi[0]) {
        	for(int i = 0; i < inputLo.length; i++) {
        		result[i] = inputLo[i];
        	}
        	for(int j = inputLo.length; j < result.length; j++) {
        		result[j] = inputHi[j - inputLo.length];
        	}
        	return  result;
        }
    	//loLeft is the index of the first element in inputLo greater than inpuHi[0].
    	//hiRigh is the index of the first element in inputHi smaller than the last element of inputLo.
        int loLeft = loBound(inputHi[0], inputLo, inputLo.length - 1);
    	int hiRigh = hiBound(inputLo[inputLo.length - 1], inputHi, 0);
        //tmp is a sorted array of all element in both inputLo and inputHi between inputLo[loLeft]
        //and inputHi[hiRigh] (include both of them).
        int[] tmp = new int[inputLo.length - loLeft + hiRigh + 1];
        for(int i = 0; i < inputLo.length - loLeft; i++) {
        	tmp[i] = inputLo[i + loLeft];
        }
        for(int j = inputLo.length - loLeft; j < inputLo.length - loLeft + hiRigh + 1; j++) {
            tmp[j] = inputHi[j - inputLo.length + loLeft];
        }
        Arrays.sort(tmp);
        if(loLeft > 0) {
        	for(int x = 0; x < loLeft; x++) {
        		result[x] = inputLo[x];
        	}
        }
        for(int y = loLeft; y < tmp.length + loLeft; y++) {
            result[y] = tmp[y - loLeft];
        }
        if(inputHi.length - hiRigh - 1 > 0) {
        	for(int z = loLeft + tmp.length; z < inputHi.length; z++) {
        		System.out.println(z);
        		result[z] = inputHi[z - loLeft - tmp.length + hiRigh + 1];
        	}
        }
        return result;
    }
    //search returns the index of element which is closest to input in array passIn.
    private int search(int input, int[] passIn, int startIndex, int endIndex) {
        int midI = (startIndex + endIndex) / 2;
        int tmp = passIn[midI];
        if(midI == startIndex) {
            return midI;
        } else if(tmp < input) {
           	midI = search(input, passIn, midI + 1, endIndex);
        } else if(tmp >= input) {
            midI = search(input, passIn, startIndex, midI);
        }
        return midI;
    }
}