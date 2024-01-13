package Solutions.MinimumNumberofStepstoMakeTwoStringsAnagram;

import java.util.HashMap;

/**
 * 2024/1/12
 *
 * @author Daniel Atlas
 */
public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "bab", t = "aba";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(char cur : s.toCharArray()){
            count.put(cur, count.getOrDefault(cur, 0)+1);
        }

        int miss = 0;
        for(char cur : t.toCharArray()){
            if(count.containsKey(cur)&&count.get(cur)>0){
                count.put(cur, count.get(cur)-1);
            }
            else{
                miss++;
            }
        }
        return miss;
    }
}
