package com.scv;

import java.util.ArrayList;

/**
 * Created by openworld on 15/10/23.
 * http://www.lintcode.com/en/problem/longest-words/
 *
 *
 */
public class longest_words {


    static String[] testArray = {"123","1234","1234","3"};
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here



        ArrayList<String> array = new ArrayList<String>();

        if (dictionary == null){
            return array;
        }

        int max = dictionary[0].length();


        for (int i=0;i<dictionary.length;i++){



            String s = dictionary[i];

            if(s.length() == max){

                array.add(s);

            }
            if (s.length() > max){
                max = s.length();
                array.clear();
                array.add(s);

            }

        }

        return array;
    }






}
