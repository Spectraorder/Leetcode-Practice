package Solutions.GroupthePeopleGiventheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2023/9/10
 *
 * @author Daniel Atlas
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> output = new ArrayList<>();
        HashMap<Integer, List<Integer>> cur = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> kGroup = cur.getOrDefault(groupSizes[i], new ArrayList<>());
            kGroup.add(i);
            if(kGroup.size()==groupSizes[i]){
                output.add(kGroup);
                cur.remove(groupSizes[i]);
            }
            else{
                cur.put(groupSizes[i], kGroup);
            }
        }
        return output;
    }
}
