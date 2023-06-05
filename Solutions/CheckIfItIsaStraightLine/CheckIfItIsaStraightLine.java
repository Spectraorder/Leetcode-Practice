package Solutions.CheckIfItIsaStraightLine;

/**
 * @author Daniel Atlas
 */
public class CheckIfItIsaStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2){
            return true;
        }
        boolean ver = coordinates[1][0]==coordinates[0][0];
        if(ver){
            for(int i=2;i<coordinates.length;i++){
                if(coordinates[0][0]!=coordinates[i][0]){
                    return false;
                }
            }
            return true;
        }
        double m = ((double)coordinates[1][1] - (double)coordinates[0][1])/((double)coordinates[1][0] - (double)coordinates[0][0]);
        double k = (double)coordinates[0][1] - m*(double)coordinates[0][0];
        for(int i=2;i<coordinates.length;i++){
            if(coordinates[i][0]*m+k !=coordinates[i][1]){
                return false;
            }
        }
        return true;
    }
}
