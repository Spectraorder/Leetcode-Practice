package Solutions.HIndex;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 2023/6/19
 *
 * @author Daniel Atlas
 */
public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=citations.length-i){
                return citations.length-i;
            }
        }
        return 0;
    }
}
