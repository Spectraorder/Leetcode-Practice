package Solutions.MinimumSpeedtoArriveonTime;

import java.util.Arrays;

/**
 * 2023/7/25
 *
 * @author Daniel Atlas
 */
public class MinimumSpeedtoArriveonTime {
    public static void main(String[] args) {
        int[] dist = {1,3,2};
        double hour = 2.7;
        System.out.println(minSpeedOnTime(dist, hour));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int start = 1, end = (int) 1e+7;
        int minSpeed = -1;
        while(start<=end){
            int mid = (start+end) / 2;
            if(isValid(dist, hour, mid)){
                end = mid - 1;
                minSpeed = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return minSpeed;
    }

    public static boolean isValid(int[] dist, double hour, int speed){
        double total = 0;
        for(int i=0;i<dist.length;i++){
            if(i!=dist.length-1){
                total += Math.ceil((double) dist[i] / speed);
            }
            else{
                total += (double) dist[i] / speed;
            }
        }
        return total<=hour;
    }
}
