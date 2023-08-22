package Solutions.ExcelSheetColumnTitle;

/**
 * 2023/8/21
 *
 * @author Daniel Atlas
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 2147483647;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        long digits = 1;
        long time = 26;
        while(time<columnNumber){
            columnNumber -= time;
            time *= 26;
            digits++;
        }
        columnNumber--;
        for(long i=digits-1;i>=0;i--){
            str.append((char)('A'+columnNumber/Math.pow(26, i)));
            columnNumber %= (int) Math.pow(26, i);
        }
        return String.valueOf(str);
    }
}
