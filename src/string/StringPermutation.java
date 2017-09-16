package string;

/**
 * Created by Lenovo on 2017/9/11.
 */
public class StringPermutation {

    /*
 * @param A: a string
 * @param B: a string
 * @return: a boolean
 */
    public boolean Permutation(String A, String B) {
        // write your code here
        if(A.length()!=B.length()){
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < A.length(); i++) {
            map[A.charAt(i)] +=1;
        }
        for (int i = 0; i < B.length(); i++) {
            map[B.charAt(i)] -=1;
        }
        for (int i = 0; i < map.length ; i++) {
            if(map[i]!=0){
                return false;
            }
        }
        return true;

    }
}
