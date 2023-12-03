package Solutions.MinimumTimeVisitingAllPoints;

/**
 * 2023/12/2
 *
 * @author Daniel Atlas
 */
public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        for(int i=1;i<points.length;i++){
            total += Math.max(Math.abs(points[i][1] - points[i-1][1]), Math.abs(points[i][0] - points[i-1][0]));
        }
        return total;
    }
}
