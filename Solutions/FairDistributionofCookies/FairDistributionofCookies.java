package Solutions.FairDistributionofCookies;

/**
 * 2023/7/1
 *
 * @author Daniel Atlas
 */
public class FairDistributionofCookies {
    public static void main(String[] args) {
        int[] cookies = {6,1,3,2,2,4,1,2};
        int k = 3;
        System.out.println(distributeCookies(cookies, k));
    }

    public static int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
        if (cookies.length - i < zeroCount) {
            return Integer.MAX_VALUE;
        }

        if (i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : distribute) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < k; ++j) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];
            answer = Math.min(answer, dfs(i + 1, distribute, cookies, k, zeroCount));
            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1 : 0;
        }
        return answer;
    }

    public static int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        return dfs(0, distribute, cookies, k, k);
    }
}
