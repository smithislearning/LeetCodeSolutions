import java.util.Arrays;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid1 = nums1[(nums1.length - 1) / 2];
        int mid2 = nums2[(nums2.length - 1) / 2];
        int mida = mid1;
        int midb = mid2
        int[] a = nums1;
        int[] b = nums2;
        if(mid1 > mid2) {
            a = nums2;
            b = nums1;
            mida = mid2;
            midb = mid1;
        }
        int bLoBound = loBound(a[mida], b, midb);
        int aHiBound = hiBound(b[midb], a, mida);
        int left = mida + bLoBound;
        int[] subA = Array.copyOfRange(a, mida, aHibound + 1);
        int[] subB = Array.copyOfRange(b, bLogound, midb + 1);
        int[] resultant = midMerge(subA, subB);
        int rLength = a.length + b.length;
        int midIndex = rLength / 2 - left - 1;
        double midVal = (double) resultant[midIndex];
        if(rLength % 2 == 0) {
            midVal = (double) (resultant[midIndex] + resultant[midIndex + 1]) / 2;
        }
        return midVal;
    }
    private int loBound(int lowRef, int[] inputArray, int bRef) {
        int tmpLo = search(low, inputArray, 0, bRef);
        if(inputArray[tmpLo] <= low) {
            tmpLo++;
        }
        return tmpLo;
    }
    private int hiBound(int hiRef, int[] inputArray, int bRef) {
        int tmpHi = search(hi, inputArray, bRef, inputArray.length - 1);
        if(inputArray[tmpHi] > hi) {
            tmpHi--;
        }
        return tmpHi;
    }
    private int[] midMerge(int[] inputLo, int[] inputHi) {
        int loLeft = search(inputHi[0], inputLo);
        int hiRigh = search(inputLo[inputLo.length - 1], inputHi);
        if(inputLo[loLfeft] <= inputHi[0]) {
            loLeft++;
        }
        if(inputHi[hiRigh] <= inputLo[inputLo.length - 1]) {
            hiRigh++;
        }
        int[] tmp = new int[inputLo.length + inputHi.length - loLeft - hiRigh];
        for(int i = 0; i < loLeft; i++) {
            tmp[i] = inputLo[i];
        }
        for(int j = 0; j < hiRigh; j++) {
            tmp[loLeft + j] = inputHi[j];
        }
        Array.sort(tmp);
        int[] result = new int[inputLo.length + inputHi.length];
        for(int x = 0; x < loLeft; x++) {
            result[x] = inputLo[x];
        }
        for(int y = 0; y < tmp.length; y++) {
            result[loLeft + y] = tmp[y];
        }
        for(int z = 0; z < result.length; z++) {
            result[loLeft + tmp.length + z] = inputHi[z];
        }
        return result;
    }
    private int search(int input, int[] passIn, int startIndex, int endIndex) {
        int midI = (startIndex + endIndex) / 2;
        int tmp = input[midI];
        if(midI == startIndex) {
            return tmp;
        } else if(tmp <= input) {
            tmp = search(input, passIn, midIndex, endIndex);
        } else if(tmp > input) {
            tmp = search(input, passIn, startIndex, midIndex);
        }
        return tmp;
    }
        
}