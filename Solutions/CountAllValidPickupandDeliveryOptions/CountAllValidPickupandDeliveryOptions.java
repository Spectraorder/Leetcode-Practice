package Solutions.CountAllValidPickupandDeliveryOptions;

/**
 * 2023/9/9
 *
 * @author Daniel Atlas
 */
public class CountAllValidPickupandDeliveryOptions {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countOrders(n));
    }

    public static int countOrders(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            long k = (long) i * (i + (i - 1));
            dp[i] = (dp[i - 1] * k) % 1000000007;
        }
        return (int) dp[dp.length - 1];
    }
}
