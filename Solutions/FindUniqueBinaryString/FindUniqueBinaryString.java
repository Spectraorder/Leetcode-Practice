package Solutions.FindUniqueBinaryString;

/**
 * 2023/11/15
 *
 * @author Daniel Atlas
 */
public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        String output = "";
        for(int i=0;i<nums.length;i++){
            output += nums[i].charAt(i)=='1' ? "0" : "1";
        }
        return output;
    }
}
