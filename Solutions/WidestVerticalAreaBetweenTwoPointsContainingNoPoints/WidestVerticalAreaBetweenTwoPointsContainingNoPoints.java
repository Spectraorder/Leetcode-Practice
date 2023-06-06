package Solutions.WidestVerticalAreaBetweenTwoPointsContainingNoPoints;

import java.util.Arrays;

/**
 * @author Daniel Atlas
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] xPos = new int[points.length];
        for(int i=0;i<points.length;i++){
            xPos[i] = points[i][0];
        }
        Arrays.sort(xPos);
        int max = -1;
        for(int i=0;i<xPos.length-1;i++){
            if(i==0){
                max = xPos[i+1] - xPos[i];
            }
            else if(max<xPos[i+1] - xPos[i]){
                max = xPos[i+1] - xPos[i];
            }
        }
        return max;
    }
}
