package Solutions.ThekthFactorofn;

import java.util.ArrayList;

/**
 * @author Daniel Atlas
 */
public class ThekthFactorofn {
    public static void main(String[] args) {
        int n=1, k=1;
        System.out.println(kthFactor(n, k));
    }

    public static int kthFactor(int n, int k) {
        ArrayList<Integer> factors = new ArrayList<>();
        int count = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(i==Math.sqrt(n)){
                    factors.add(count, i);
                }
                else{
                    factors.add(count, i);
                    factors.add(factors.size()-count, n/i);
                }
                count++;
            }
        }
        return k>factors.size() ? -1 : factors.get(k-1);
    }
}
