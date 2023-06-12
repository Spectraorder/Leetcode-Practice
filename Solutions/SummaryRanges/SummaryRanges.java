package Solutions.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * 6/11/2023
 *
 * @author Daniel Atlas
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int start = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=i-start+nums[start]){
                output.add(i-start==1 ? String.valueOf(nums[start]) : nums[start] + "->" + nums[i-1]);
                start = i;
            }
            if(i==nums.length-1){
                output.add(i==start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[i]);
            }
        }
        if(output.isEmpty()&&nums.length>0){
            output.add(String.valueOf(nums[start]));
        }
        return output;
    }
}
