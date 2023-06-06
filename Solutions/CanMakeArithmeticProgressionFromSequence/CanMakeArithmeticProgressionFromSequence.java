package Solutions.CanMakeArithmeticProgressionFromSequence;

import java.util.Arrays;

/**
 * @author Daniel Atlas
 */
public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length<=2){
            return true;
        }
        int diff = 0;
        for(int i=0;i<arr.length-1;i++){
            if(i==0){
                diff = arr[i+1] - arr[i];
            }
            else if(diff!=arr[i+1]-arr[i]){
                return false;
            }
        }
        return true;
    }
}
