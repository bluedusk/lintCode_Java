package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by openworld on 2017/9/17.
 */
public class StringsHomomorphism {

    public static boolean isIsomorphic(String s, String t) {
        // write your code here
        if(s.length() != t.length()){
            return false;
        }
        // 注意必须两个map, 考虑foo,bar和bar,foo
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(!map1.containsKey(c1)){
                map1.put(c1,c2);
            }
            else{
                if(c2 != map1.get(c1)){
                    return false;
                }
            }
            if(!map2.containsKey(c2)){
                map2.put(c2,c1);
            }
            else{
                if(c1 != map2.get(c2)){
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args){
        String s = "a`%ii,VEZQc_BSU%ObO5<sX81B/bOw+CNUd#Uav*P!Ax!#>hh,k#b/|>4ixFQZl+l!?bJjakbQbGglEb<g>Hf81m@A9GIvbd]qh?y__t+E(Iyv7zUEfZF{81VaM-0u?]tG=_fFR/XJ=X{-,oRpxE9u*VNYlM";
        String t = "b`%ii-WE[Qc_BSV%OcO5<sX82B/cOw+CNVd#Vbv*P!Bx!#?hh-k#c/|?4ixFQ[l+l!?cJkbkcQcGhlEc<h?Hf82m@B9GIvcd]rh?y__t+E(Iyv7{VEf[F{82WbN/0u?]tG=_fFR/XJ=X{/-oRpxE9u*WNYlN";
        isIsomorphic(s,t);
    }
}
