package Solutions.Combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2023/7/31
 *
 * @author Daniel Atlas
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        Stack<Integer> set = new Stack<>();
        for(int i=1;i<=k;i++){
            set.add(i);
        }
        output.add(new ArrayList<>(set));
        while(set.size()==k){
            int cur = set.pop();
            int count = 1;
            while(cur+count>n&&!set.isEmpty()){
                cur = set.pop();
                count++;
            }
            if(cur+count>n){
                break;
            }
            for(int i=0;i<count;i++){
                set.add(cur+i+1);
            }
            if(set.size()==k){
                output.add(new ArrayList<>(set));
            }
        }
        return output;
    }
//    public static boolean isLast(Stack<Integer> cur, int n, int k){
//        ArrayList<Integer> test = new ArrayList<>(cur);
//        for(int i=0;i<test.size();i++){
//            if(test.get(i)!=n)
//        }
//    }
}
