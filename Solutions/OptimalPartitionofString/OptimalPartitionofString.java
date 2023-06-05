package Solutions.OptimalPartitionofString;

import java.util.Arrays;

/**
 * @author Daniel Atlas
 */
public class OptimalPartitionofString {
    public static void main(String[] args) {
        String str1 = "abacaba";
        String str2 = "ssssss";
        System.out.println(partitionString(str1));
        System.out.println(partitionString(str2));
    }

    public static int partitionString(String s) {
//        int count = 0;
//        while(!"".equals(s)){
//            HashSet<Character> cur = new HashSet<>();
//            int pos = 0;
//            for(char k : s.toCharArray()){
//                if(cur.contains(k)){
//                    break;
//                }
//                else{
//                    cur.add(k);
//                    pos++;
//                }
//            }
//            s = s.substring(pos);
//            count++;
//        }
//        return count;
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }
}
