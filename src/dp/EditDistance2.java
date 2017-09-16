package dp;

/**
 * Created by openworld on 2017/9/9.
 */
public class EditDistance2 {

    /*
 * @param s: a string
 * @param t: a string
 * @return: true if they are both one edit distance apart or false
 */
    public static boolean isOneEditDistance(String s, String t) {
        // write your code here
        if(s.length() < t.length()){
            return isOneEditDistance(t,s);
        }
        if(s.length() - t.length() > 1){
            return false;
        }
        // 长度差为1
        else if(s.length() - t.length() == 1){
            for (int i = 0; i < t.length(); i++) {
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        else{ // 长度相等
            if(s.equals(t)){
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
            }
        }
        return true; // 长度相差1时，最后一位之前都相同
    }

    public static void main(String[] args){
        isOneEditDistance("adb", "aDb");
    }
}
