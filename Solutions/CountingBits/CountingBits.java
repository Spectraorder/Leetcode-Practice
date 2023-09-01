package Solutions.CountingBits;

import java.util.Arrays;

/**
 * 2023/9/1
 *
 * @author Daniel Atlas
 */
public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int[] out = new int[n+1];
        for(int i=0;i<=n;i++){
            out[i] = Integer.bitCount(i);
        }
        return out;
    }
}
