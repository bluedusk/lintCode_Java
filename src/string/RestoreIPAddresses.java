package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 2017/9/9.
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, "", res);
        return res;
    }

    /**
     *
     * @param s
     * @param n
     * @param out
     * @param res
     */
    public void helper(String s, int n, String out, List<String> res) {
        // n 为字符串被分割的段数
        if (n == 4) {
            if (s.isEmpty()){
                res.add(out);
            }
            return;
        }
        // 取长度为1,2,3
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            // 取此段
            int val = Integer.parseInt(s.substring(0, k));
            // 校验此段是否合法ip的一部分， >255 或者前面有0, 如05，为不合法；
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }
}
