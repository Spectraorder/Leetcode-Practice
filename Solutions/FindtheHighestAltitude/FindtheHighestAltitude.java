package Solutions.FindtheHighestAltitude;

/**
 * 2023/6/18
 *
 * @author Daniel Atlas
 */
public class FindtheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int total = 0;
        int maxSum = 0;
        for(int cur : gain){
            total += cur;
            if(total>maxSum){
                maxSum = total;
            }
        }
        return maxSum;
    }
}
