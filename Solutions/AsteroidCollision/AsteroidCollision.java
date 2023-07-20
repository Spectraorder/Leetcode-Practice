package Solutions.AsteroidCollision;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2023/7/20
 *
 * @author Daniel Atlas
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-2,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> all = new ArrayList<>();
        for(int cur : asteroids){
            if(cur>0){
                all.add(cur);
            }
            else{
                int pos = all.size()-1;
                boolean isAdd = true;
                while(pos>=0&&all.get(pos)>0){
                    if(all.get(pos)+cur>0){
                        isAdd = false;
                        break;
                    }
                    else if(all.get(pos)+cur<0){
                        all.remove(pos);
                    }
                    else{
                        isAdd = false;
                        all.remove(pos);
                        break;
                    }
                    pos--;
                }
                if(isAdd){
                    all.add(cur);
                }
            }
        }
        return all.stream().mapToInt(Integer::intValue).toArray();
    }
}
