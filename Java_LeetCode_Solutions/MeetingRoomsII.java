/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;
public class Solution {
    private static ArrayList<Interval> sorted = new ArrayList<Interval>();
    public int minMeetingRooms(Interval[] intervals) {
        sorted.clear();
        for(Interval a: intervals){
            int eIndex = sorted.size() - 1;
            if(eIndex <= 0) {
            	eIndex = 0;
            }
            sort(a, 0, eIndex);
        }
        int finalSum = sumUp();;
        return finalSum;
    }
    private static void sort(Interval inPut, int startIndex, int endIndex) {
    	int midIndex = startIndex + (endIndex - startIndex) / 2;
        if(sorted.size() == 0) {
            sorted.add(inPut);
        } else if(startIndex == endIndex) {
        	if(inPut.end <= sorted.get(midIndex).start) {
        	    sorted.add(midIndex, inPut);
        	} else if(inPut.start >= sorted.get(midIndex).end) {
        	    if(midIndex == sorted.size() - 1) {
        	        sorted.add(inPut);
        	        } else {
        	            sorted.add(midIndex + 1, inPut);
        	            }
        	} else if(inPut.start < sorted.get(midIndex).start) {
        	    sorted.add(midIndex, inPut);
        	} else if(inPut.start > sorted.get(midIndex).start) {
        	    if(midIndex == sorted.size() - 1) {
        	        sorted.add(inPut);
        	        } else {
        	            sorted.add(midIndex + 1, inPut);
        	            }
        	} else if(inPut.start == sorted.get(midIndex).start) {
        	    if(inPut.end < sorted.get(midIndex).end) {
        	        sorted.add(midIndex, inPut);
        	    } else if(midIndex == sorted.size() - 1) {
        	        sorted.add(inPut);
        	        } else {
        	            sorted.add(midIndex + 1, inPut);
        	            }
        	}
        } else if(inPut.start <= sorted.get(midIndex).start) {
            sort(inPut, startIndex, midIndex);
        } else if(midIndex == sorted.size() - 1) {
            sort(inPut, midIndex, midIndex);
        } else {
            sort(inPut, midIndex + 1, endIndex);
        }
    }
    
    private static int sumUp() {
        ArrayList<Interval> sortSum = new ArrayList<Interval>();
        if(sorted.size() == 0) {
            return 0;
        }
        if(sorted.size() == 1) {
            return 1;
        }
        int bench = sorted.get(0).start;
        for(Interval x : sorted) {
            if(x.start == bench) {
                sortSum.add(x);
            } else {
                break;
            }
        }
        for(Interval y : sorted) {
            boolean check = false;
            for(Interval z : sortSum) {
                if(y.start == bench) {
                    check = true;
                    continue;
                } else if(y.start >= z.end) {
                    sortSum.set(sortSum.indexOf(z), y);
                    check = true;
                    break;
                }
            }
            if(check == false) {
                sortSum.add(y);
            }
        }
        int sum = sortSum.size();
        return sum;
    }
}