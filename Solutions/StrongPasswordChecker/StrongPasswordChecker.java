package Solutions.StrongPasswordChecker;

/**
 * @author Daniel Atlas
 */
public class StrongPasswordChecker {
    public static void main(String[] args) {
        String str = "bbaaaaaaaaaaaaaaacccccc";
        System.out.println(strongPasswordChecker(str));
    }

    public static int strongPasswordChecker(String password) {
        if(password.length()<2) {
            return 6-password.length();
        }
        char end = password.charAt(0);
        boolean upper = end>='A'&&end<='Z', lower = end>='a'&&end<='z', digit = end>='0'&&end<='9';
        int end_rep = 1, change = 0;
        int[] delete = new int[3];
        for(int i = 1;i<password.length();++i){
            if(password.charAt(i)==end) {
                ++end_rep;
            } else{
                change+=end_rep/3;
                if(end_rep/3>0) ++delete[end_rep%3];
                end = password.charAt(i);
                upper = upper||end>='A'&&end<='Z';
                lower = lower||end>='a'&&end<='z';
                digit = digit||end>='0'&&end<='9';
                end_rep = 1;
            }
        }
        change+=end_rep/3;
        if(end_rep/3>0) {
            ++delete[end_rep%3];
        }
        int check_req = (upper?0:1)+(lower?0:1)+(digit?0:1);
        if(password.length()>20){
            int del = password.length()-20;
            if(del<=delete[0]) {
                change-=del;
            } else if(del-delete[0]<=2*delete[1]) {
                change-=delete[0]+(del-delete[0])/2;
            } else {
                change-=delete[0]+delete[1]+(del-delete[0]-2*delete[1])/3;
            }
            return del+Math.max(check_req,change);
        }
        else {
            return Math.max(6-password.length(), Math.max(check_req, change));
        }
    }
}
