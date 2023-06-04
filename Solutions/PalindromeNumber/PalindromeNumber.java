package Solutions.PalindromeNumber;

/**
 * @author Daniel Atlas
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        int y = -121;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
    }

    public static boolean isPalindrome(int x) {
        StringBuilder stb = new StringBuilder(String.valueOf(x));
        return String.valueOf(stb.reverse()).equals(String.valueOf(x));
    }
}
