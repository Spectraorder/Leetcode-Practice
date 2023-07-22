package Solutions.KnightProbabilityinChessboard;

/**
 * 2023/7/21
 *
 * @author Daniel Atlas
 */
public class KnightProbabilityinChessboard {
    public static int[][] moves = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    public static void main(String[] args) {
        int n = 3, k = 2, row = 0, col = 0;
        System.out.println(knightProbability(n, k, row, col));
    }

    //    public static double knightProbability(int n, int k, int row, int column) {
//        int[] outcome = dfs(n, k, row, column, 0, 0);
//        return (double) outcome[0] / Math.pow(8, k);
//    }
//
//    public static int[] dfs(int n, int steps, int posx, int posy, int inside, int outside){
//        if(posx<0||posx>=n||posy<0||posy>=n){
//            return new int[]{inside, outside+1};
//        }
//        if(steps==0){
//            return new int[]{inside+1, outside};
//        }
//        int[] temp = new int[2];
//        for(int[] cur : moves){
//            int[] now = dfs(n, steps-1, posx+cur[0], posy+cur[1], inside, outside);
//            temp[0] += now[0];
//            temp[1] += now[1];
//        }
//        return temp;
//    }
    public static double knightProbability(int n, int k, int row, int column) {
        // Define possible directions for the knight's moves
        int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        // Initialize the dynamic programming table
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;

        // Iterate over the number of moves
        for (int moves = 1; moves <= k; moves++) {
            // Iterate over the cells on the chessboard
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Iterate over possible directions
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];
                        // Check if the previous cell is within the chessboard
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            // Add the previous probability divided by 8
                            dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }

        // Calculate total probability by summing probabilities for all cells
        double totalProbability = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += dp[k][i][j];
            }
        }
        return totalProbability;
    }
}
