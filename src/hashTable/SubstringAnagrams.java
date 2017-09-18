package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by openworld on 2017/9/17.
 */
public class SubstringAnagrams {

    // TLE
    public static List<Integer> findAnagrams(String s, String p) {
        // write your code here
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= s.length() - p.length(); i++) {

            HashMap<Character,Integer> tmpMap = new HashMap<Character, Integer>(map);
            boolean success = true;
            for (int j = 0; j < p.length(); j++) {
                char c = s.charAt(j + i);
                if(!tmpMap.containsKey(c)){
                    success = false;
                    break;
                }
                else{
                    tmpMap.put(c,tmpMap.get(c) - 1);
                    if(tmpMap.get(c) < 0){
                        success = false;
                        break;
                    }
                }
            }
            if(success){
                result.add(i);
            }
   
        }
        return result;
    }
    public static List<Integer> findAnagrams1(String s, String p) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null) return result;
        int left = 0,right =0,count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        // 初始化p的map
        for (char c : p.toCharArray()) map[c] ++;
        while (right < s.length()) {
            if (map[sc[right++]]-- >= 1) count --;
            if (count == 0) result.add(left);
            if (right - left == p.length() && map[sc[left++]]++ >=0) count++;
        }
        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null) return result;
        int left = 0,right =0,count = p.length();
        char[] sc = s.toCharArray();
        // 初始化p的map
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        while (right < s.length()) {

            if(map.containsKey(sc[right])){
                if (map.get(sc[right])>=1) {
                    count --;
                }
                map.put(sc[right],map.get(sc[right]) - 1);
            }
            right ++;

            if (count == 0){
                result.add(left);
            }
            if (right - left == p.length()){

                if(map.containsKey(sc[left])){

                    if ( map.get(sc[left]) >=0) {
                        count++;
                    }
                    map.put(sc[left],map.get(sc[left]) + 1);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams2(s, p);

    }
}
