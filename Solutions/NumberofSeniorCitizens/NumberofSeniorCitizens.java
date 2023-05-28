package Solutions.NumberofSeniorCitizens;

/**
 * @author Daniel Atlas
 */
public class NumberofSeniorCitizens {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int count = 0;
        for(int i=0;i<details.length;i++){
            int cur = Integer.parseInt(details[i].substring(11, 13));
            if(cur>60){
                count++;
            }
        }
        return count;
    }
}
