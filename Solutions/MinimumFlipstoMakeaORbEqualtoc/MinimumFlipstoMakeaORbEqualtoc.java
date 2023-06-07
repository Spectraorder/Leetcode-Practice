package Solutions.MinimumFlipstoMakeaORbEqualtoc;

/**
 * @author Daniel Atlas
 */
public class MinimumFlipstoMakeaORbEqualtoc {
    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println(minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
    }
}
