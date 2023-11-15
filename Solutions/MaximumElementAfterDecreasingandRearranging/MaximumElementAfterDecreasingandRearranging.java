package Solutions.MaximumElementAfterDecreasingandRearranging;

import java.util.Arrays;

/**
 * 2023/11/14
 *
 * @author Daniel Atlas
 */
public class MaximumElementAfterDecreasingandRearranging {
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,1};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]>1){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }
}
