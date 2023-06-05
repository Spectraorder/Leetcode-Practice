package Solutions.MyCalendarII;

/**
 * @author Daniel Atlas
 */
public class MyCalendarII {
    public static void main(String[] args) {
        MyCalendarTwo obj = new MyCalendarTwo();
        int[][] ins_list = {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        for(int[] cur : ins_list){
            System.out.println(obj.book(cur[0], cur[1]));
        }
    }
}
