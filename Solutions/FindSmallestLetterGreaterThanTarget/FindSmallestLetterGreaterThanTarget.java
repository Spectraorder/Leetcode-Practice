package Solutions.FindSmallestLetterGreaterThanTarget;

/**
 * @author Daniel Atlas
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        char out = letters[0];
        for(char cur : letters){
            if(cur-target>0&&cur-target<min){
                min = cur-target;
                out = cur;
            }
        }
        return out;
    }
}
