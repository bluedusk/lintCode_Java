package string;

/**
 * Created by Lenovo on 2017/9/13.
 */
public class LongestCommonPrefix {

    // Solution1: 一定要注意特殊情况的测试案例
    public static String longestCommonPrefix(String[] strs) {

        // 不加这个判断会TLE
        if (strs == null || strs.length == 0){
            return "";
        }
//        // 只有一位的情况
//        if(strs.length == 1){
//            return strs[0];
//        }
        int j = 0;
        while(true){

            for (int i = 0; i < strs.length; i++) {
                // 临界条件1： 有一个s到了最后一位
                if(j == strs[i].length()){
                    return strs[i];
                }
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    String ret = strs[0].substring(0,j);
                    return ret;
                };
            }
            j++;
        }
    }
    public static void main(String[] args){
        //一定要注意特殊情况的测试案例
        String[] s = {"ABCDEFG", "ABCEFG" , "ABCEFA"};
        String[] s1 = {"a", "b"};
        String[] s2 = {"a", "a"};
        String[] s3 = {"abc"};
        longestCommonPrefix(s3);

    }
}
