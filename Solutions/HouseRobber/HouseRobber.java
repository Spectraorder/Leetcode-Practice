package Solutions.HouseRobber;

/**
 * 2024/1/21
 *
 * @author Daniel Atlas
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,1, 1, 2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for (int num : nums) {
            int newRob = norob + num;
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
}
