package Solutions.MyCalendarII;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Daniel Atlas
 */
public class MyCalendarTwo {

    public static TreeMap<Integer, Integer> calender;

    public MyCalendarTwo() {
        calender = new TreeMap<>();
    }

    public boolean book(int start, int end) {
//        HashMap<Integer, Integer> cur = new HashMap<>(calender);
//        for(int i=start;i<end;i++){
//            if(!cur.containsKey(i)){
//                cur.put(i, 1);
//            }
//            else if(cur.get(i)<2){
//                cur.replace(i, cur.get(i)+1);
//            }
//            else{
//                return false;
//            }
//        }
//        calender = cur;
//        return true;
        calender.put(start, calender.getOrDefault(start, 0) + 1);
        calender.put(end, calender.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: calender.values()) {
            active += d;
            if (active >= 3) {
                calender.put(start, calender.get(start) - 1);
                calender.put(end, calender.get(end) + 1);
                if (calender.get(start) == 0)
                    calender.remove(start);
                return false;
            }
        }
        return true;
    }
}
