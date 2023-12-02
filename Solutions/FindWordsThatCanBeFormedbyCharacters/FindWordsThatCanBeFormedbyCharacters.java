package Solutions.FindWordsThatCanBeFormedbyCharacters;

import java.util.HashMap;

/**
 * 2023/12/1
 *
 * @author Daniel Atlas
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for(char cur : chars.toCharArray()){
            count[cur-'a']++;
        }
        int total = 0;
        for(String str : words){
            int[] curCount = new int[26];
            for(char cur : str.toCharArray()){
                curCount[cur-'a']++;
            }
            boolean canCombine = true;
            for(int i=0;i<26;i++){
                if(curCount[i]>count[i]){
                    canCombine = false;
                    break;
                }
            }
            if(canCombine){
                total += str.length();
            }
        }
        return total;
    }
}
