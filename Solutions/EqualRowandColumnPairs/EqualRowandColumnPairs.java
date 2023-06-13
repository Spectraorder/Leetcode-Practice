package Solutions.EqualRowandColumnPairs;

import java.util.HashSet;

/**
 * 6/12/2023
 *
 * @author Daniel Atlas
 */
public class EqualRowandColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        HashSet<int[]> ocr = new HashSet<>();
        for(int[] cur : grid){
            if(!ocr.contains(cur)){
                for(int col=0;col<grid[0].length;col++){
                    int row = 0;
                    boolean isPiar = true;
                    while(row<grid.length){
                        if(grid[row][col]==cur[row]){
                            row++;
                        }
                        else{
                            isPiar = false;
                            break;
                        }
                    }
                    if(isPiar){
                        int[] pair = new int[grid[0].length];
                        for(int k=0;k<grid.length;k++){
                            pair[k] = grid[k][col];
                        }
                        ocr.add(pair);
                    }
                }
            }
        }
        return ocr.size();
    }
}
