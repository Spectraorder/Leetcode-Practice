package Solutions.BackspaceStringCompare;

/**
 * 2023/10/18
 *
 * @author Daniel Atlas
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "a#c", t = "b";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
//        int pos_s = 0, pos_t = 0;
        for(int posS = 0; posS<s.length(); posS++){
            if(s.charAt(posS)!='#'){
                ss.append(s.charAt(posS));
            }
            else{
                if(!ss.isEmpty()){
                    ss.deleteCharAt(ss.length()-1);
                }
            }
        }
        for(int posT = 0; posT<t.length(); posT++){
            if(t.charAt(posT)!='#'){
                st.append(t.charAt(posT));
            }
            else{
                if(!st.isEmpty()){
                    st.deleteCharAt(st.length()-1);
                }
            }
        }
        return  ss.toString().contentEquals(st);
    }
}
