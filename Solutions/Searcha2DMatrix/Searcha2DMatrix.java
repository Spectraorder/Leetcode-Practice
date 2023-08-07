package Solutions.Searcha2DMatrix;

/**
 * 2023/8/6
 *
 * @author Daniel Atlas
 */
public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while(start<=end){
            int mid = (start+end) / 2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]==target){
                return true;
            }
            else if(matrix[mid/matrix[0].length][mid%matrix[0].length]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}
