package string;

/**
 * Created by Lenovo on 2017/3/13.
 * http://www.lintcode.com/en/problem/strstr/
 * http://www.jiuzhang.com/solutions/strstr/
 */
public class StrStr {

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // 注意异常处理
        if (source == null || target == null) {
            return -1;
        }
        // 注意i的条件，后面不够位数，处理不好会越界
        // charAt
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                //发现不相等break返回上层循环，source指针前移
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
