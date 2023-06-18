package Solutions.NumberofIncreasingPathsinaGrid;

/**
 * 2023/6/17
 *
 * @author Daniel Atlas
 */
public class NumberofIncreasingPathsinaGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,1}, {3,4}};
        System.out.println(countPaths(grid));
    }

    public static int countPaths(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length*grid[0].length;i++){
            for(int row=0;row<grid.length;row++){
                for(int col=0;col<grid[0].length;col++){
                    count += pathLength(grid, new int[]{row, col}, 1, i+1);
                }
            }
        }
        return count;
    }

    public static int pathLength(int[][] grid, int[] pos, int len, int target){
        if(len==target){
            return 1;
        }
        if(pos[0]<0||pos[0]>=grid.length||pos[1]<0||pos[1]>=grid[0].length){
            return 0;
        }
        int total = 0;
        if(pos[1]>0){
            total += grid[pos[0]][pos[1]-1]>grid[pos[0]][pos[1]] ? pathLength(grid, new int[]{pos[0], pos[1]-1}, len+1, target) : 0;
        }
        if(pos[1]<grid[0].length-1){
            total += grid[pos[0]][pos[1]+1]>grid[pos[0]][pos[1]] ? pathLength(grid, new int[]{pos[0], pos[1]+1}, len+1, target) : 0;
        }
        if(pos[0]<grid.length-1){
            total += grid[pos[0]+1][pos[1]]>grid[pos[0]][pos[1]] ? pathLength(grid, new int[]{pos[0]+1, pos[1]}, len+1, target) : 0;
        }
        if(pos[0]>0){
            total += grid[pos[0]-1][pos[1]]>grid[pos[0]][pos[1]] ? pathLength(grid, new int[]{pos[0]-1, pos[1]}, len+1, target) : 0;
        }
        return total;
    }
}
