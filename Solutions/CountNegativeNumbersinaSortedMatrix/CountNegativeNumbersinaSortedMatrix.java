package Solutions.CountNegativeNumbersinaSortedMatrix;

/**
 * @author Daniel Atlas
 */
public class CountNegativeNumbersinaSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int last_neg = grid[0].length-1;
        for(int[] ints : grid) {
            while(last_neg>=0&&ints[last_neg]<0){
                last_neg--;
            }
            count += grid[0].length-last_neg-1;
        }
        return count;
    }
}
