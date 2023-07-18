package Solutions.LRUCache;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 2023/7/17
 *
 * @author Daniel Atlas
 */
public class LRUCache {
    public  Queue<TreeMap<Integer, Integer>> LRU;
    public int cap;

    public LRUCache(int capacity) {
        LRU = new LinkedList<>();
        cap = capacity;
    }

    public int get(int key) {
        for(TreeMap<Integer, Integer> cur : LRU){
            if(cur.containsKey(key)){
                LRU.remove(cur);
                LRU.offer(cur);
                return cur.get(key);
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        TreeMap<Integer, Integer> cur = new TreeMap<>();
        cur.put(key, value);
        if(LRU.size()==cap){
            LRU.poll();
        }
        LRU.offer(cur);
    }
}
