package binarySearch;

/**
 * Created by Lenovo on 2017/9/1.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72969
 */

 class SVNRepo {
      public static boolean isBadVersion(int k)
      {
          return true;
      };
  }
public class FindFirstBadVersion {

    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here

//        for (int i = 1; i < n; i++) {
//            if(SVNRepo.isBadVersion(i) == true){
//                return i;
//            }
//        }
//        return -1;

        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
