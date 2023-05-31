package Solutions.RangeSumQueryImmutable;

/**
 * @author Daniel Atlas
 */
public class NumArray {
    public int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<right+1;i++){
            sum += this.arr[i];
        }
        return sum;
    }
}
