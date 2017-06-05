package string;

/**
 * Created by Lenovo on 2017/6/1.
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        // write your code
        s = s.trim();
        if(s == ""){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        while(s.indexOf(" ")>0){
            int index = s.lastIndexOf(" ");
            sb.append(s.substring(index, s.length()));
            s = s.substring(0,index);
        }
        sb.append(" ");
        sb.append(s);
        return sb.toString().trim();
    }

    public static void main(String[] args){
        String s = "the sky is blue";
        reverseWords(s);
    }
}
