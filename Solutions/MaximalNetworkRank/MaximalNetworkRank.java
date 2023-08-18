package Solutions.MaximalNetworkRank;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2023/8/17
 *
 * @author Daniel Atlas
 */
public class MaximalNetworkRank {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
//        int[][] roads = {{2,4}};
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        for(int[] cur : roads){
            HashSet<Integer> pointA = edges.getOrDefault(cur[0], new HashSet<>());
            pointA.add(cur[1]);
            edges.put(cur[0], pointA);
            HashSet<Integer> pointB = edges.getOrDefault(cur[1], new HashSet<>());
            pointB.add(cur[0]);
            edges.put(cur[1], pointB);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(edges.get(i)!=null&&edges.get(j)!=null){
                    ans = Math.max(ans, edges.get(i).size() + edges.get(j).size() - (edges.get(i).contains(j) ? 1 : 0));
                }
            }
        }
        return ans;
    }
}
