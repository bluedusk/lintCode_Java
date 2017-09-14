package String;

/**
 * Created by Lenovo on 2017/9/11.
 */
public class ValidNumber {

    /*
 * @param s: the String that represents a number
 * @return: whether the String is a valid number
 */
    public static boolean isNumber(String s) {
        if(s.trim().isEmpty()){
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if(s.trim().matches(regex)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String[] ss = new String[21];
        ss[0] = "0"; // True
        ss[1] = " 0.1 "; // True
        ss[2] = "abc"; // False
        ss[3] = "1 a"; // False
        ss[4] = "2e10"; // True
        ss[5] = "-e10"; // False
        ss[6] = " 2e-9 "; // True
        ss[7] = "+e1"; // False
        ss[8] = "1+e"; // False
        ss[9] = " "; // False
        ss[10] = "e9"; // False
        ss[11] = "4e+"; // False
        ss[12] = " -."; // False
        ss[13] = "+.8"; // True
        ss[14] = " 005047e+6"; // True

        ss[15] = ".e1"; // False
        ss[16] = "3.e"; // False
        ss[17] = "3.e1"; // True
        ss[18] = "+1.e+5"; // True
        ss[19] = " -54.53061"; // True
        ss[20] = ". 1"; // False

        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + "   ");
            System.out.println(isNumber(ss[i]));
        }
//        isNumber("5ddsfd");
    }
}
