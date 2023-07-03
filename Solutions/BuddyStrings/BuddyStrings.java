package Solutions.BuddyStrings;

import java.util.HashSet;

/**
 * 2023/7/3
 *
 * @author Daniel Atlas
 */
public class BuddyStrings {
    public static void main(String[] args) {
        String s = "abcd", goal = "cbad";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            HashSet<Character> dup = new HashSet<>();
            for(char cur : s.toCharArray()){
                if(!dup.contains(cur)){
                    dup.add(cur);
                }
                else{
                    return true;
                }
            }
            return false;
        }
        int[] pos = new int[2];
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(count>1){
                    return false;
                }
                pos[count] = i;
                count++;
            }
        }
        return s.charAt(pos[0])==goal.charAt(pos[1]) && s.charAt(pos[1])==goal.charAt(pos[0]);
    }
}
