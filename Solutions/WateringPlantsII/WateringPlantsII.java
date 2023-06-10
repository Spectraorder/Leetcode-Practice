package Solutions.WateringPlantsII;

/**
 * 6/9/2023
 *
 * @author Daniel Atlas
 */
public class WateringPlantsII {
    public static void main(String[] args) {
        int[] plants = {274,179,789,417,293,336,133,334,569,355,813,217,80,933,961,271,294,933,49,980,685,470,186,11,157,889,299,493,215,807,588,464,218,248,391,817,32,606,740,941,505,533,289,306,490};
        int capacityA = 996, capacityB = 1172;
        System.out.println(minimumRefill(plants, capacityA, capacityB));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int capA = capacityA, capB = capacityB;
        int refill = 0;
        int posA = 0, posB = plants.length-1;
        while(posA<posB){
            if(capacityA<plants[posA]){
                capacityA = capA;
                refill++;

            }
            if(capacityB<plants[posB]){
                capacityB = capB;
                refill++;
            }
            capacityA -= plants[posA];
            capacityB -= plants[posB];
            posB--;
            posA++;
        }
        if(Math.max(capacityA, capacityB)<plants[posA]&&posA==posB){
            refill++;
        }
        return refill;
    }
}
