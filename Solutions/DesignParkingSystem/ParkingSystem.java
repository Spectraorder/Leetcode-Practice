package Solutions.DesignParkingSystem;

/**
 * @author Daniel Atlas
 */
public class ParkingSystem {
    public int big;
    public int medium;
    public int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType==1&&big==0||carType==2&&medium==0||carType==3&&small==0) return false;
        int i = carType == 1 ? this.big-- : (carType == 2 ? this.medium-- : this.small--);
        return true;
    }
}
