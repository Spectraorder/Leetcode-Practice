package Solutions.ClimbingStairs;

/**
 * 2024/1/17
 *
 * @author Daniel Atlas
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        return helper(n, 0);
    }

    public static int helper(int n, int count){
        if(n==0){
            return count+1;
        }
        if(n<0){
            return count;
        }
        count = helper(n-1, count);
        count = helper(n-2, count);
        return count;
    }
}
