package Solutions.LengthofLastWord;

/**
 * @author Daniel Atlas
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while(s.charAt(end)==' '&&end>0){
            end--;
        }
        int count = 0;
        for(int i=end;i>-1&&s.charAt(i)!=' ';i--){
            count++;
        }
        return count;
    }
}
