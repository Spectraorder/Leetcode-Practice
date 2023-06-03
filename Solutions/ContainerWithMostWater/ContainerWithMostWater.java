package Solutions.ContainerWithMostWater;

/**
 * @author Daniel Atlas
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = 0;
        while(start<end){
            if((end-start)*Math.min(height[start], height[end])>max){
                max = (end-start)*Math.min(height[start], height[end]);
            }
            if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
            }
        }
        return max;
    }
}
