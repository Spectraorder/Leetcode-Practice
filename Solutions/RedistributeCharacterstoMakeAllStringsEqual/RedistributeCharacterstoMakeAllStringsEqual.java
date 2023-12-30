package Solutions.RedistributeCharacterstoMakeAllStringsEqual;

/**
 * 2023/12/29
 *
 * @author Daniel Atlas
 */
public class RedistributeCharacterstoMakeAllStringsEqual {
    public static void main(String[] args) {
        String[] words = {"abc","aabc","bc"};
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for(String str : words){
            for(char cur : str.toCharArray()){
                count[cur-'a']++;
            }
        }
        for(int cur : count){
            if(cur % words.length != 0){
                return false;
            }
        }
        return true;
    }
}
