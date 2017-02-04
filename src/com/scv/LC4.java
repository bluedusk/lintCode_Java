package com.scv;

//Space Replacement



public class LC4 {


    static String test = "hello worl d                     ";


    public static void main(String[] args) {
        // write your code here

        System.out.println(replaceBlank(test.toCharArray(),12));
    }

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
     public static int replaceBlank(char[] string, int length) {
        // Write your code here



         for (int i = 0; i < length; i++){

             if (string[i]==' '){
                 string[i] = '%';
                 for(int j = length -1; j > i ; j--){
                     string[j+2] = string[j];
                 }
                 string[i+1] = '2';
                 string[i+2] = '0';
                 length +=2;
             }
         }
         System.out.println(new String(string));
        return length;
     }
}
