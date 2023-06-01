package Solutions.ShortestPathinBinaryMatrix;

/**
 * @author Daniel Atlas
 */
public class ShortestPathinBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0}};
        int[][] grid2 = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
        System.out.println(shortestPathBinaryMatrix(grid2));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int k = helperRecursion(grid, 0, 0, 1);
        return k==2147483647 ? -1 : k;
    }

    public static int helperRecursion(int[][] grid, int x, int y, int len){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]!=0){
            return 2147483647;
        }
        if(x==grid.length-1&&y==grid[0].length-1){
            return len;
        }
        int[][] cur = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            System.arraycopy(grid[i], 0, cur[i], 0, grid[0].length);
        }
        cur[x][y] = -1;
        int down = Math.min(helperRecursion(cur, x+1, y-1, len+1), Math.min(helperRecursion(cur, x+1, y, len+1), helperRecursion(cur, x+1, y+1, len+1)));
        int mid = Math.min(helperRecursion(cur, x, y-1, len+1), helperRecursion(cur, x, y+1, len+1));
        int top = Math.min(helperRecursion(cur, x-1, y-1, len+1), Math.min(helperRecursion(cur, x-1, y, len+1), helperRecursion(cur, x-1, y+1, len+1)));
        return Math.min(top, Math.min(down, mid));
    }
}
