package Solutions.DetermineifStringHalvesAreAlike;

/**
 * 2024/1/12
 *
 * @author Daniel Atlas
 */
public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        char[] vow = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        int countF = 0, countL = 0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()/2){
                for(char cur : vow){
                    if(cur==s.charAt(i)){
                        countF++;
                        break;
                    }
                }
            }
            else{
                for(char cur : vow){
                    if(cur==s.charAt(i)){
                        countL++;
                        break;
                    }
                }
            }
        }
        return countF==countL;
    }
}
