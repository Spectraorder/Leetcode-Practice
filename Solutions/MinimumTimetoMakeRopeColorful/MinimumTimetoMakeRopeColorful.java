package Solutions.MinimumTimetoMakeRopeColorful;

/**
 * 2023/12/27
 *
 * @author Daniel Atlas
 */
public class MinimumTimetoMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int[] neededTime = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int[] dp = new int[colors.length()];
        for(int i=1;i<colors.length();i++){
            int t = 1;
            while(neededTime[i-t]==-1){
                t++;
            }
            if(colors.charAt(i)==colors.charAt(i-t)){
                dp[i] = dp[i-1] + Math.min(neededTime[i], neededTime[i-t]);
                if(neededTime[i]<neededTime[i-t]){
                    neededTime[i] = -1;
                }
                else{
                    neededTime[i-t] = -1;
                }
            }
            else{
                dp[i] = dp[i-1];
            }
        }
        return dp[colors.length()-1];
    }
}
