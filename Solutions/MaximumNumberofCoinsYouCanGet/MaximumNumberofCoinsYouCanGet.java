package Solutions.MaximumNumberofCoinsYouCanGet;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 2023/11/23
 *
 * @author Daniel Atlas
 */
public class MaximumNumberofCoinsYouCanGet {
    public static void main(String[] args) {
        int[] piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }

    public static int maxCoins(int[] piles) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cur : piles){
            pq.add(cur);
        }
        int count = 0;
        int output = 0;
        while(count<piles.length/3){
            int cur = pq.poll();
            cur = pq.poll();
            output += cur;
            count++;
        }
        return output;
    }
}
