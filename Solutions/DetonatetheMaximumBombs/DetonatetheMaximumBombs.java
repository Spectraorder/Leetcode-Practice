package Solutions.DetonatetheMaximumBombs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel Atlas
 */
public class DetonatetheMaximumBombs {
    public static void main(String[] args) {
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(maximumDetonation(bombs));;
    }

    public static int maximumDetonation(int[][] bombs) {
        int max = -1;
        for(int i=0;i<bombs.length;i++){
            ArrayList<int[]> cur = new ArrayList<>(Arrays.asList(bombs));
            Queue<int[]> visited = new LinkedList<>();
            visited.offer(cur.remove(i));
            int k=1;
            while(!visited.isEmpty()){
                int[] den = visited.poll();
                for(int j=0;j<cur.size();j++){
                    if(inRange(den, cur.get(j))){
                        k++;
                        visited.offer(cur.remove(j));
                        j--;
                    }
                }
            }
            max = Math.max(k, max);
        }
        return max;
    }

    public static boolean inRange(int[] den, int[] b){
        return Math.pow(den[0]-b[0], 2)+Math.pow(den[1]-b[1], 2)<=Math.pow(den[2], 2);
    }
}
