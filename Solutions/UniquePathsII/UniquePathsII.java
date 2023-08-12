package Solutions.UniquePathsII;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
//            return 0;
//        }
//        return helperPath(obstacleGrid, 0, 0, 0);
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else {
                    if (c > 0) {
                        dp[c] += dp[c - 1];
                    }
                }
            }
        }

        return dp[cols - 1];
    }

    public static int helperPath(int[][] obstacleGrid, int posX, int posY, int paths){
        if(posX==obstacleGrid[0].length-1&&posY==obstacleGrid.length-1){
            return paths+1;
        }
        else if(posX>obstacleGrid[0].length-1||posY>obstacleGrid.length-1||obstacleGrid[posY][posX]==1){
            return paths;
        }
        int curPath = helperPath(obstacleGrid, posX+1, posY, paths);
        curPath += helperPath(obstacleGrid, posX, posY+1, paths);
        return curPath;
    }
}
