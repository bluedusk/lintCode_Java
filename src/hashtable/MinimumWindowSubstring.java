package hashtable;

/**
 * Created by Lenovo on 2017/9/14.
 */
public class MinimumWindowSubstring {

    int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] targethash = new int[256];

        int targetnum = initTargetHash(targethash, Target);
        int sourcenum = 0; // 控制window
        int j = 0, i = 0; // j = window开始，i = window结束
        for(i = 0; i < Source.length(); i++) {
            if(targethash[Source.charAt(i)] > 0){
                sourcenum++; // 在window中如果同一个字母出现多次也要加1
            }
            // 对source进行遍历，每一位都--， 没在target中的字母都是负值
            targethash[Source.charAt(i)]--;
            // 当window内已包含target
            while(sourcenum>=targetnum) {
                if(ans > i - j + 1) {  // 发现一个更短的
                    ans = Math.min(ans, i - j + 1);
                    minStr = Source.substring(j, i + 1);
                }
                // window开头位置前进
                targethash[Source.charAt(j)]++;
                // 如果开头前进到target中的字母，这个字母在++后>0;
                if(targethash[Source.charAt(j)] > 0){
                    sourcenum--;
                }
                j++;
            }
        }
        return minStr;
    }
}
