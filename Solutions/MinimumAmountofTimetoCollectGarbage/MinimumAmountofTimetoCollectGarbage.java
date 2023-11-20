package Solutions.MinimumAmountofTimetoCollectGarbage;

/**
 * 2023/11/19
 *
 * @author Daniel Atlas
 */
public class MinimumAmountofTimetoCollectGarbage {
    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int total = 0;
        int m_pos = 0, p_pos = 0, g_pos = 0;
        for(int i=0;i<garbage.length;i++){
            if(i>=1){
                m_pos += travel[i-1];
                p_pos += travel[i-1];
                g_pos += travel[i-1];
                if(garbage[i].contains("M")){
                    total += m_pos;
                    m_pos = 0;
                }
                if(garbage[i].contains("P")){
                    total += p_pos;
                    p_pos = 0;
                }
                if(garbage[i].contains("G")){
                    total += g_pos;
                    g_pos = 0;
                }
            }
            total += garbage[i].length();
        }
        return total;
    }
}
