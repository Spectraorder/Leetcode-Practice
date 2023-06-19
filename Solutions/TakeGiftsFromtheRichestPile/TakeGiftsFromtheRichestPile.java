package Solutions.TakeGiftsFromtheRichestPile;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2023/6/18
 *
 * @author Daniel Atlas
 */
public class TakeGiftsFromtheRichestPile {
    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

    public static long pickGifts(int[] gifts, int k) {
        long total = 0;
        for(int i=0;i<k;i++){
            int max = Integer.MIN_VALUE;
            int pos = -1;
            for(int j=0;j<gifts.length;j++){
                if(gifts[j]>=max){
                    pos = j;
                    max = gifts[j];
                }
            }
            gifts[pos] = (int) Math.sqrt(max);
//            Arrays.sort(gifts);
//            gifts[gifts.length-1] = (int) Math.sqrt(gifts[gifts.length-1]);
        }
        for(int cur : gifts){
            total += cur;
        }
        return total;
    }
}
