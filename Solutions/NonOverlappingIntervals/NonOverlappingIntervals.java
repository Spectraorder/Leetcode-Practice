package Solutions.NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2023/7/19
 *
 * @author Daniel Atlas
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int x = interval[0];
            int y = interval[1];
            if(x>=k){
                k = y;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
