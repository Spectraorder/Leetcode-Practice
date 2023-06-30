package Solutions.LastDayWhereYouCanStillCross;

/**
 * 2023/6/29
 *
 * @author Daniel Atlas
 */
public class LastDayWhereYouCanStillCross {
    public static void main(String[] args) {
        int row = 3, col = 3;
        int[][] cells = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
//        int[][] cells = {{1,1},{2,1},{1,2},{2,2}};
        System.out.println(latestDayToCross(row, col, cells));
    }
    public static int latestDayToCross(int row, int col, int[][] cells) {
        int start = 1, end = row*col;
        while(start<end){
            int[][] grid = new int[row][col];
            int mid = end-(end-start)/2;
            if(allCols(grid, cells, mid)){
                start = mid;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }

    public static boolean allCols(int[][] grid, int[][] cells, int day){
        for(int i=0;i<day;i++){
            grid[cells[i][0]-1][cells[i][1]-1] = -1;
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==0&&topToBottom(grid, 0, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean topToBottom(int[][] grid, int pos_row, int pos_col){
        if(pos_col<0||pos_col>=grid[0].length||pos_row<0||pos_row>=grid.length||grid[pos_row][pos_col]!=0){
            return false;
        }
        grid[pos_row][pos_col] = 1;
        if(pos_row==grid.length-1){
            return true;
        }
        return topToBottom(grid, pos_row+1, pos_col) || topToBottom(grid, pos_row, pos_col+1)
                || topToBottom(grid, pos_row-1, pos_col) || topToBottom(grid, pos_row, pos_col-1);
    }
}
