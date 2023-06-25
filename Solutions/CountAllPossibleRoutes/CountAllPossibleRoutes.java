package Solutions.CountAllPossibleRoutes;

import java.util.Arrays;

/**
 * 2023/6/24
 *
 * @author Daniel Atlas
 */
public class CountAllPossibleRoutes {
    public static void main(String[] args) {
        int[] locations = {1, 2, 3};
        int start = 0, finish = 2, fuel = 40;
        System.out.println(countRoutes(locations, start, finish, fuel));
    }

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
//        if(fuel<Math.abs(locations[start]-locations[finish])){
//            return 0;
//        }
//        return routeHelper(locations, finish, fuel, start);
        int n = locations.length;
        int dp[][] = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);

        int ans = 0;
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) %
                                1000000007;
                    }
                }
            }
        }

        return dp[start][fuel];
    }

    public static int routeHelper(int[] locations, int finish, int fuel, int pos){
        if(fuel>=0&&pos==finish){
            int total = 0;
            for(int i=0;i<locations.length;i++){
                total += i!=pos ? routeHelper(locations, finish, fuel-Math.abs(locations[i]-locations[pos]), i) : 0;
            }
            return 1 + total;
        }
        if(fuel<0){
            return 0;
        }
        int total = 0;
        for(int i=0;i<locations.length;i++){
            total += i!=pos ? routeHelper(locations, finish, fuel-Math.abs(locations[i]-locations[pos]), i) : 0;
        }
        return total;
    }
}
