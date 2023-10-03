package Solutions.NumberofGoodPairs;

import java.util.HashMap;

/**
 * @author SpectraDomain
 */
public class NumberofGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> cur = new HashMap<>();
        for(int k : nums){
            cur.put(k, cur.getOrDefault(k, 0)+1);
        }
        int result = 0;
        for(int k : cur.keySet()){
            if(cur.get(k)>=2){
                result += cur.get(k) * (cur.get(k)-1) / 2;
            }
        }
        return result;
    }
}
