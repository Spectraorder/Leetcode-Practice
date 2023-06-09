package Solutions.InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * 6/8/2023
 *
 * @author Daniel Atlas
 */
public class RandomizedSet {

    public HashSet<Integer> all;
    public ArrayList<Integer> array;
    public RandomizedSet() {
        all = new HashSet<>();
        array = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!all.contains(val)){
            all.add(val);
            array.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(all.contains(val)){
            all.remove(val);
            array.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        int ran = new Random().nextInt(array.size());
        return array.get(ran);
    }
}
