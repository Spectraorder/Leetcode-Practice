package Solutions.IntersectionofTwoArrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2024/3/9
 *
 * @author Daniel Atlas
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] intersection = new int[intersectionSet.size()];
        int i = 0;
        for (Integer num : intersectionSet) {
            intersection[i++] = num;
        }

        return intersection;
    }
}
