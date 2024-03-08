package Solutions.CountElementsWithMaximumFrequency;

import java.util.Arrays;

/**
 * 2024/3/7
 *
 * @author Daniel Atlas
 */
public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        int[] count = new int[100];
        for(int cur : nums){
            count[cur-1]++;
        }
        Arrays.sort(count);
        int output = 0;
        for(int i=count.length-1;i>=0;i--){
            if(count[i] != count[count.length-1]){
                break;
            }
            output += count[i];
        }
        return output;
    }
}
