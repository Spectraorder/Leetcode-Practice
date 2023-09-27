package Solutions.DecodedStringatIndex;

/**
 * 2023/9/27
 *
 * @author Daniel Atlas
 */
public class DecodedStringatIndex {
    public static void main(String[] args) {
        String s = "ha22";
        int k = 5;
        System.out.println(decodeAtIndex(s, k));
    }

    public static String decodeAtIndex(String s, int k) {
        String tape = "";
        for(int i=0;i<s.length();i++){
            if(tape.length()>=k){
                return tape.substring(k-1, k);
            }
            if(s.charAt(i)>='2'&&s.charAt(i)<='9'){
                tape = tape.repeat(s.charAt(i)-'0');
            }
            else{
                tape += s.substring(i, i+1);
            }
        }
        return tape.substring(k-1, k);
    }
}
