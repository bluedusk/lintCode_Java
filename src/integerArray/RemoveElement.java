package integerArray;

/**
 * Created by Lenovo on 2017/6/8.
 */
public class RemoveElement {

    public static int removeElement(int[] A, int elem) {
        // write your code here
        int count = 0;
        int x = 0;
        for (int i = 0; i < A.length; i++){
            if(A[i] != elem){
                A[x] = A[i];
                x ++ ;
            }
            else{
                count ++;
            }
        }

        return A.length - count;
    }

    public static void main(String[] args){
        int[] A = {0,4,4,0,4,4,4,0,2};
        removeElement(A,4);
    }
}
