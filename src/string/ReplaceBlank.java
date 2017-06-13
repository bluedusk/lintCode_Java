package string;

//Space Replacement



public class ReplaceBlank {


    static String test = " hello worl d                                             ";


    public static void main(String[] args) {
        // write your code here

        System.out.println(replaceBlank2(test.toCharArray(),14));
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
    // solution2 better
    // 从后往前，减少移动次数
    public static int replaceBlank2(char[] string, int length) {
        // Write your code here
        if (string == null) return 0;
        int space = 0;
        for (int i = 0; i < length; i++) {
            if(string[i] == ' '){
                space ++;
            }
        }
        int x = length + 2 * space - 1;
        for (int i = length - 1; i >= 0 ; i--){

            if (string[i]!=' ') {
                string[x] = string[i];
                x --;
            }
            else{
                string[x--] = '0';
                string[x--] = '2';
                string[x--] = '%';
            }
        }
        System.out.println(new String(string));

        return length + 2 * space;
    }
}
