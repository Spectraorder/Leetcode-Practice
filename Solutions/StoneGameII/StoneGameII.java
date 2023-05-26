package Solutions.StoneGameII;

/**
 * @author Daniel Atlas
 */
public class StoneGameII {
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }

    public static int stoneGameII(int[] piles) {
        return helper(piles, 0, 0, 1);
    }

    public static int helper(int[] piles, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        int res = p == 1 ? 1000000 : -1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + helper(piles, 1, i + x, Math.max(m, x)));
            }
            else {
                res = Math.min(res, helper(piles, 0, i + x, Math.max(m, x)));
            }
        }
        return res;
    }
}
