package Solutions.RemoveColoredPiecesifBothNeighborsaretheSameColor;

/**
 * 2023/10/1
 *
 * @author Daniel Atlas
 */
public class RemoveColoredPiecesifBothNeighborsaretheSameColor {
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }

    public static boolean winnerOfGame(String colors) {
        if(colors.length()<3){
            return false;
        }
        int stepA = 0, stepB = 0;
        for(int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i-1)==colors.charAt(i)&&colors.charAt(i+1)==colors.charAt(i)){
                if(colors.charAt(i)=='A'){
                    stepA++;
                }
                else{
                    stepB++;
                }
            }
        }
        return stepA>stepB;
    }
}
