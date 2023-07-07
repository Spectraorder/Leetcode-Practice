package Solutions.MaximizetheConfusionofanExam;

/**
 * 2023/7/6
 *
 * @author Daniel Atlas
 */
public class MaximizetheConfusionofanExam {
    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers(answerKey, k));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0, end = 0;
        int tLen = 0, fLen = 0;
        int maxLen = Integer.MIN_VALUE;
        while(end<answerKey.length()){
            if(Math.min(tLen, fLen)<=k){
                maxLen = Math.max(maxLen, end-start);
                tLen += answerKey.charAt(end)=='T' ? 1 : 0;
                fLen += answerKey.charAt(end)=='F' ? 1 : 0;
                end++;
            }
            else{
                tLen -= answerKey.charAt(start)=='T' ? 1 : 0;
                fLen -= answerKey.charAt(start)=='F' ? 1 : 0;
                start++;
            }
        }
        while(Math.min(tLen, fLen)>k){
            tLen -= answerKey.charAt(start)=='T' ? 1 : 0;
            fLen -= answerKey.charAt(start)=='F' ? 1 : 0;
            start++;
        }
        maxLen = Math.max(maxLen, end-start);
        return maxLen;
    }
}
