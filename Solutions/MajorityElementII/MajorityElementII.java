package Solutions.MajorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author SpectraDomain
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> all = new HashMap<>();
        for(int cur : nums){
            all.put(cur, all.getOrDefault(cur, 0)+1);
        }
        List<Integer> output = new ArrayList<>();
        for(int k : all.keySet()){
            if(all.get(k)>nums.length/3){
                output.add(k);
            }
        }
        return output;
    }
}
