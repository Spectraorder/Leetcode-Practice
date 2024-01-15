package Solutions.FindPlayersWithZeroorOneLosses;

import java.util.*;

/**
 * 2024/1/14
 *
 * @author Daniel Atlas
 */
public class FindPlayersWithZeroorOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{2,3},{1,3},{5,4},{6,4}};
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> output = new ArrayList<>();
        HashMap<Integer, Integer> lossCount = new HashMap<>();
        for(int[] cur : matches){
            lossCount.put(cur[0], lossCount.getOrDefault(cur[0], 0));
            lossCount.put(cur[1], lossCount.getOrDefault(cur[1], 0)+1);
        }
        PriorityQueue<Integer> winner = new PriorityQueue<>();
        PriorityQueue<Integer> lossOnce = new PriorityQueue<>();
        for(int key : lossCount.keySet()){
            if(lossCount.get(key)==0){
                winner.add(key);
            }
            else if(lossCount.get(key)==1){
                lossOnce.add(key);
            }
        }
        List<Integer> winList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        while(!winner.isEmpty()){
            winList.add(winner.poll());
        }
        while(!lossOnce.isEmpty()){
            lostList.add(lossOnce.poll());
        }
        output.add(winList);
        output.add(lostList);
        return output;
    }
}
