package Solutions.CountNicePairsinanArray;

import java.util.HashMap;

/**
 * 2023/11/20
 *
 * @author Daniel Atlas
 */
public class CountNicePairsinanArray {
    public static void main(String[] args) {
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num - reverse(num), count.getOrDefault(num - reverse(num), 0) + 1);
        }
        int output = 0;
        for(int cur : count.keySet()){
            output = (int) (((count.get(cur) * (count.get(cur)-1) * 0.5) + output) % (1e9+7));
        }
        return output;
    }
    public static int reverse(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
