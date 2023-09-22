package Solutions.FindtheDuplicateNumber;

import java.util.HashSet;

/**
 * @author SpectraDomain
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> all = new HashSet<>();
        for(int k : nums){
            if(all.contains(k)){
                return k;
            }
            all.add(k);
        }
        return -1;
    }
}
