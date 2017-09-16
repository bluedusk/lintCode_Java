package string;

/**
 * Created by Lenovo on 2017/9/12.
 * http://www.lintcode.com/en/problem/unique-characters/
 */
public class UniqueCharacters {

    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map[c]++;
        }
        for (int i = 0; i < map.length; i++) {
            if(map[i]>1){
                return false;
            }
        }
        return true;
    }


}
