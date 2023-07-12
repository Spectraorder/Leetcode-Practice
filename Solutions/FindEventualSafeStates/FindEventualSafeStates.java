package Solutions.FindEventualSafeStates;

import java.util.*;

/**
 * 2023/7/11
 *
 * @author Daniel Atlas
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        HashSet<Integer> term = new HashSet<>();
        Queue<Integer> cur = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0){
                safe.add(i);
                cur.offer(i);
            }
        }
        while(!cur.isEmpty()){
            term.add(cur.poll());
            for(int i=0;i<graph.length;i++){
                if(!term.contains(i)){
                    boolean isSafe = true;
                    for(int k : graph[i]){
                        if(!term.contains(k)){
                            isSafe = false;
                            break;
                        }
                    }
                    if(isSafe&&graph[i].length!=0&&!cur.contains(i)){
                        cur.offer(i);
                        safe.add(i);
                    }
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}
