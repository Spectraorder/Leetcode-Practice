package Solutions.CountUnguardedCellsintheGrid;

/**
 * @author Daniel Atlas
 */
public class CountUnguardedCellsintheGrid {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguarded(m, n, guards, walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for(int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        for(int[] guard : guards) {
            // col up
            for(int i=guard[0]-1;i>=0&&grid[i][guard[1]]!=2;i--){
                if(grid[i][guard[1]]==1) break;
                grid[i][guard[1]] = -1;
            }
            // col down
            for(int i=guard[0]+1;i<m&&grid[i][guard[1]]!=2;i++){
                if(grid[i][guard[1]]==1) break;
                grid[i][guard[1]] = -1;
            }
            // row left
            for(int i=guard[1]-1;i>=0&&grid[guard[0]][i]!=2;i--){
                if(grid[guard[0]][i]==1) break;
                grid[guard[0]][i] = -1;
            }
            // row right
            for(int i=guard[1]+1;i<n&&grid[guard[0]][i]!=2;i++){
                if(grid[guard[0]][i]==1) break;
                grid[guard[0]][i] = -1;
            }
        }
        int count = 0;
        for(int[] cur : grid){
            for(int k : cur){
                if(k==0) count++;
            }
        }
        return count;
    }
}
