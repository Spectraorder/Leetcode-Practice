package Solutions.ConvertanArrayIntoa2DArrayWithConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 2024/1/1
 *
 * @author Daniel Atlas
 */
public class ConvertanArrayIntoa2DArrayWithConditions {
    public static void main(String[] args) {
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> output = new ArrayList<>();
        while(!count.isEmpty()){
            List<Integer> curList = new ArrayList<>();
            int[] allKeys = count.keySet().stream().mapToInt(Integer::intValue).toArray();
            for(int key : allKeys){
                curList.add(key);
                if(count.get(key)==1){
                    count.remove(key);
                }
                else{
                    count.put(key, count.get(key)-1);
                }
            }
            output.add(curList);
        }
        return output;
    }
}
