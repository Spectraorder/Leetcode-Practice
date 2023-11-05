package Solutions.FindtheWinnerofanArrayGame;

/**
 * 2023/11/4
 *
 * @author Daniel Atlas
 */
public class FindtheWinnerofanArrayGame {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];

            if (curr > opponent) {
                winstreak++;
            } else {
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }
}
