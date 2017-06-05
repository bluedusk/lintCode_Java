package string;

import java.util.*;

/**
 * Created by Lenovo on 2017/5/24.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72936
 * http://www.lintcode.com/en/problem/anagrams/
 */
public class AnagramsArray {
    public static List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (strs == null) return result;

        // one key to multiple value multiMap
        Map<String, ArrayList<String>> multiMap = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String strSorted = String.valueOf(strChar);
            if (multiMap.containsKey(strSorted)) {
                ArrayList<String> aList = multiMap.get(strSorted);
                aList.add(str);
                multiMap.put(strSorted, aList);
            } else {
                ArrayList<String> aList = new ArrayList<String>();
                aList.add(str);
                multiMap.put(strSorted, aList);
            }
        }

        // add List group to result
        Set<String> keySet = multiMap.keySet();
        for (String key : keySet) {
            ArrayList<String> aList = multiMap.get(key);
            if(aList.size()>1){
                result.addAll(aList);
            }
        }
        return result;
    }


    public static void main(String[] args){
        String[] x = {"abc","cba","cab","dd"};
        Arrays.sort(x);
        anagrams(x);
    }
}
