package Solutions.LeastNumberofUniqueIntegersafterKRemovals;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 2024/2/15
 *
 * @author Daniel Atlas
 */
public class LeastNumberofUniqueIntegersafterKRemovals {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int cur : arr){
            count.put(cur, count.getOrDefault(cur, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(count.values());
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur<=k){
                k -= cur;
            }
            else{
                pq.add(cur);
                break;
            }
        }
        return pq.size();
    }
}
