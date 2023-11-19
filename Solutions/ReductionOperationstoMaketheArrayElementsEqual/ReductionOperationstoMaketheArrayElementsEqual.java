package Solutions.ReductionOperationstoMaketheArrayElementsEqual;

import java.util.PriorityQueue;

/**
 * 2023/11/18
 *
 * @author Daniel Atlas
 */
public class ReductionOperationstoMaketheArrayElementsEqual {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        System.out.println(reductionOperations(nums));
    }

    public static int reductionOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int cur : nums){
            pq.add(cur);
        }
        int numOp = -1;
        int prev = -1;
        int total = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(numOp==-1){
                numOp++;
            }
            else{
                if(cur!=prev){
                    numOp++;
                }
                total += numOp;
            }
            prev = cur;
        }
        return total;
    }
}
