package Solutions.DetermineifaCellIsReachableataGivenTime;

/**
 * 2023/11/7
 *
 * @author Daniel Atlas
 */
public class DetermineifaCellIsReachableataGivenTime {
    public static void main(String[] args) {
        int sx = 2, sy = 4, fx = 7, fy = 7, t = 6;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(Math.abs(fx-sx) + Math.abs(fy-sy)==0){
            return t > 1 || t == 0;
        }
        return t >= Math.max(Math.abs(fx-sx), Math.abs(fy-sy));
//        if(t <= Math.abs(fx-sx) + Math.abs(fy-sy)){
//            return t >= Math.max(Math.abs(fx-sx), Math.abs(fy-sy));
//        }
//        return t > Math.abs(fx-sx) + Math.abs(fy-sy)+1;
    }
}
