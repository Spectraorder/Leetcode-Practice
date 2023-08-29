package Solutions.MinimumPenaltyforaShop;

/**
 * 2023/8/28
 *
 * @author Daniel Atlas
 */
public class MinimumPenaltyforaShop {
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }

    public static int bestClosingTime(String customers) {
        int minPenalty = 0, curPenalty = 0;
        int earliestHour = 0;
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }
        return earliestHour;
    }
}
