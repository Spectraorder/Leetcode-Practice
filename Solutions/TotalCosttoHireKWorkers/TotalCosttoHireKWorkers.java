package Solutions.TotalCosttoHireKWorkers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2023/6/25
 *
 * @author Daniel Atlas
 */
public class TotalCosttoHireKWorkers {
    public static void main(String[] args) {
        int[] costs = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        int k = 11, candidates = 2;
        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
//        long total = 0;
//        int left = candidates, right = candidates;
//        while(k>0){
//            int minCost = Integer.MAX_VALUE;
//            int pos = Integer.MAX_VALUE;
//            for(int i=costs.length-1;i>=0;i--){
//                if(costs.length-i-1<left||i<right){
//                    pos = costs[i]<=minCost ? i : pos;
//                    minCost = Math.min(minCost, costs[i]);
//                }
//            }
//            System.out.println(Arrays.toString(costs));
//            total += costs[pos];
//            costs[pos] = Integer.MAX_VALUE;
//            left += costs.length-pos-1<left ? 1 : 0;
//            right += pos<right ? 1 : 0;
//            k--;
//        }
//        return total;
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }
        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;
        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            }
            else {
                answer += tailWorkers.poll();
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }
        return answer;
    }
}
