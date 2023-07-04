package Solutions.SingleNumberII;

import java.util.HashMap;

/**
 * 2023/7/3
 *
 * @author Daniel Atlas
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> all = new HashMap<>();
        for(int cur : nums){
            all.put(cur, all.getOrDefault(cur, 0)+1);
        }
        for(int cur : all.keySet()){
            if(all.get(cur)==1){
                return cur;
            }
        }
        return -1;
    }
}
