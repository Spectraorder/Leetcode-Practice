package Solutions.FindFirstPalindromicStringintheArray;

/**
 * 2024/2/12
 *
 * @author Daniel Atlas
 */
public class FindFirstPalindromicStringintheArray {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for(String str : words){
            if(isPalindrome(str)){
                return str;
            }
        }
        return "";
    }

    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
