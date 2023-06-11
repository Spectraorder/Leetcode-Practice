package Solutions.SnapshotArray;

import java.util.*;

/**
 * 6/10/2023
 *
 * @author Daniel Atlas
 */
public class SnapshotArray {

    public int snapTime;
    public TreeMap<Integer, Integer>[] snap;

    public SnapshotArray(int length) {
        snapTime = 0;
        snap = new TreeMap[length];
        for(int i=0;i<length;i++){
            snap[i] = new TreeMap<>();
            snap[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snap[index].put(snapTime, val);
    }

    public int snap() {
        return snapTime++;
    }

    public int get(int index, int snap_id) {
        return snap[index].floorEntry(snap_id).getValue();
    }

}
