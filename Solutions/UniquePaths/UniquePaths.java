package Solutions.UniquePaths;

import java.math.BigInteger;

/**
 * 2023/9/2
 *
 * @author Daniel Atlas
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 16, n = 16;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        int total = m + n - 2;
        return factorial(total, Math.min(m-1, n-1));
    }

    public static int factorial(int n, int k) {
        BigInteger top = BigInteger.ONE, down = BigInteger.ONE;
        for(int i=0;i<k;i++){
            top = top.multiply(BigInteger.valueOf(n-i));
            down = down.multiply(BigInteger.valueOf(i+1));
        }
        return top.divide(down).intValueExact();
    }
}
