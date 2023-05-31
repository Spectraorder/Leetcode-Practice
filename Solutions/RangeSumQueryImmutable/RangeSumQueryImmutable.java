package Solutions.RangeSumQueryImmutable;

/**
 * @author Daniel Atlas
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] temp = {-2, 0, 3, -5, 2, -1};
        NumArray arr = new NumArray(temp);
        System.out.println(arr.sumRange(0, 2));
        System.out.println(arr.sumRange(2, 5));
        System.out.println(arr.sumRange(0, 5));
    }
}
