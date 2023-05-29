package Solutions.DesignParkingSystem;

/**
 * @author Daniel Atlas
 */
public class DesignParkingSystem {
    public static void main(String[] args) {
        ParkingSystem all = new ParkingSystem(3, 1, 0);
        System.out.println(all.addCar(1));
        System.out.println(all.addCar(2));
        System.out.println(all.addCar(3));
        System.out.println(all.addCar(2));
    }
}
