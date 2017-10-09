package integerArray;

/**
 * Created by Lenovo on 2017/9/28.
 */
public class SortIntegers {

    public void sortIntegers(int[] a) {
        // write your code here

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    void  swap(int[] x, int a, int b){
        int tmp;
        tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
