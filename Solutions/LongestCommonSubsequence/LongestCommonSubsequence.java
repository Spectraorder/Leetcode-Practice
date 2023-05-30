package Solutions.LongestCommonSubsequence;


/**
 * @author Daniel Atlas
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length()+1, n = text2.length()+1;
        int[][] grid = new int[m][n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    grid[i][j] = grid[i-1][j-1] + 1;
                }
                else{
                    grid[i][j] = Math.max(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
