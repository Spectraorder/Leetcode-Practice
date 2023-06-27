package Solutions.FindKPairswithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2023/6/26
 *
 * @author Daniel Atlas
 */
public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        int[][] dp = new int[nums1.length][nums2.length];
//        for(int i=0;i<nums1.length;i++){
//            for(int j=0;j<nums2.length;j++){
//                dp[i][j] = nums1[i] + nums2[j];
//            }
//        }
//        int[] pointer = new int[dp.length];
//        int count = 0;
//        List<List<Integer>> output = new ArrayList<>();
//        while(count<k){
//            int min = Integer.MAX_VALUE;
//            int pos = -1;
//            List<Integer> cur = new ArrayList<>();
//            for(int i=0;i<pointer.length;i++){
//                if(pointer[i]<nums2.length){
//                    pos = min>dp[i][pointer[i]] ? i : pos;
//                    min = Math.min(min, dp[i][pointer[i]]);
//                }
//            }
//            if(pos==-1){
//                break;
//            }
//            cur.add(nums1[pos]);
//            cur.add(nums2[pointer[pos]]);
//            output.add(cur);
//            pointer[pos]++;
//            count++;
//        }
//        return output;
        List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Priority queue to store pairs with smallest sums, sorted by the sum

        // Push the initial pairs into the priority queue
        for (int x : nums1) {
            pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
        }

        // Pop the k smallest pairs from the priority queue
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            resV.add(currentPair); // Add the pair to the result list

            // If there are more elements in nums2, push the next pair into the priority queue
            if (pos + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--; // Decrement k
        }

        return resV; // Return the k smallest pairs
    }
}
