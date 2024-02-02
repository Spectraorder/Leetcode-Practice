package Solutions.SequentialDigits;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/2/1
 *
 * @author Daniel Atlas
 */
public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(sequentialDigits(low, high));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String minV = String.valueOf(low);
        String maxV = String.valueOf(high);
        List<Integer> output = new ArrayList<>();
        for(int i=minV.length();i<=maxV.length();i++){
            for(int j=1;j+i<11;j++){
                int cur = Integer.parseInt(seqGen(j, i));
                if(cur<=high&&cur>=low){
                    output.add(cur);
                }
            }
        }
        return output;
    }

    public static String seqGen(int k, int len){
        String str = "123456789";
        return str.substring(k-1, k-1+len);
    }
}
