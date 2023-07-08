package Solutions.PutMarblesinBags;

import java.util.Arrays;

/**
 * 2023/7/7
 *
 * @author Daniel Atlas
 */
public class PutMarblesinBags {
    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        int[] split = new int[weights.length-1];
        for(int i=0;i<weights.length-1;i++){
            split[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(split);
        long min = 0, max = 0;
        for(int i=0;i<k-1;i++){
            min += split[i];
            max += split[split.length-i-1];
        }
        return max-min;
    }
}
