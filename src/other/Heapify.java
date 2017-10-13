package other;

/**
 * Created by Lenovo on 2017/10/9.
 * 根据题意只要将给定数组调整为满足heap的定义的数组就可以
 */
public class Heapify {

    public static void main(String[] args){
        String[] s = {};
        int[] A = {3,5,1,4,2};
        int[][] AA = {};
        String str1 = "";

        Heapify x = new Heapify();

        x.heapify2(A);

    }
    // solution 1
    // k是作为根的位置，计算2*i+1和2*i+2的大小，将最小的换到k位置；
    // 交换后可能引起son位置数字失去平衡，因此需要继续调整，知道 k*2+1 >= A.length, 也就是不会再有child节点
    private void siftdown1(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
            {
                son = k * 2 + 2;
            }
            if (A[son] >= A[k])
            {
                break;
            }

            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    public void heapify1(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown1(A, i);
        }
    }

    // version 2 : this cost O(n)
    // 这个相对更好懂
    private void siftdown2(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            // 没有交换
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;
        }
    }

    public void heapify2(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown2(A, i);
        } // for
    }

    // version 3 : O(nlogn)
    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;

            k = father;
        }
    }

    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }



}
