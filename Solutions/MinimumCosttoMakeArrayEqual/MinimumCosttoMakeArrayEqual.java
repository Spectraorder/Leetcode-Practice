package Solutions.MinimumCosttoMakeArrayEqual;

/**
 * 2023/6/20
 *
 * @author Daniel Atlas
 */
public class MinimumCosttoMakeArrayEqual {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2}, cost = {2,3,1,14};
        System.out.println(minCost(nums, cost));
    }
    public static long minCost(int[] nums, int[] cost) {
        int left = 1000001, right = 0;
        for(int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = getCost(nums, cost, nums[0]);

        while (left < right) {
            int mid = (right + left) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if(cost1 > cost2){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return answer;
    }

    public static long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for(int i=0;i<nums.length;++i){
            result += (long) Math.abs(nums[i] - base) * cost[i];
        }
        return result;
    }
}
