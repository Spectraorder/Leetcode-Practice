package Solutions.TimeNeededtoInformAllEmployees;

import java.util.*;

/**
 * @author Daniel Atlas
 */
public class TimeNeededtoInformAllEmployees {
    public static void main(String[] args) {
        int n = 15, headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    private static int dfs(int manager, int[] informTime, Map<Integer, List<Integer>> adjList) {
        int maxTime = 0;
        if (adjList.containsKey(manager)) {
            for (int subordinate : adjList.get(manager)) {
                maxTime = Math.max(maxTime, dfs(subordinate, informTime, adjList));
            }
        }
        return maxTime + informTime[manager];
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
        }

        return dfs(headID, informTime, adjList);
    }
}
