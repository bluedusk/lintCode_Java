package string;

/**
 * Created by Lenovo on 2017/6/8.
 * http://www.lintcode.com/en/problem/count-and-say/
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72945
 */
public class CountAndSay {

/*
* 比如我们再扫描1211的时候，看1后面是2，则1的count = 1，则将count + 1写入字符串中，
* 2也一样，2后面的1,1后面还是1，则count++，第二个1后面没有了，则将count+1写入字符串，输入完毕。
因此打印的就是11+12+21即111221。

数字可以分解为count+number;
*/
    public static String countAndSay(int n) {
        if (n <= 0) return null;
        // 第一个数字
        String s = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int sLen = s.length();
            for (int j = 0; j < sLen; j++) {
                if (j < sLen - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count + "" + s.charAt(j));
                    // reset
                    count = 1;
                }
            }
            s = sb.toString();
        }

        return s;
    }

    public static void main(String[] args){
        countAndSay(5);
    }
}
