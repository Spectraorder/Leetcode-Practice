package Solutions.EliminateMaximumNumberofMonsters;

import java.util.PriorityQueue;

/**
 * 2023/11/6
 *
 * @author Daniel Atlas
 */
public class EliminateMaximumNumberofMonsters {
    public static void main(String[] args) {
        int[] dist = {3,5,7,4,5};
        int[] speed = {2,3,6,3,2};
        System.out.println(eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> arrive = new PriorityQueue<>();
        for(int i=0;i<dist.length;i++){
            arrive.add(dist[i]%speed[i]==0 ? dist[i]/speed[i] : dist[i]/speed[i]+1);
        }
        int count = 0;
        while(!arrive.isEmpty()){
            int cur = arrive.poll();
            if(count<cur){
                count++;
            }
            else{
                return count;
            }
        }
        return count;
    }
}
