package com.scv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by openworld on 15/7/21.
 * Max Points on a Line
 * http://www.jiuzhang.com/solutions/max-points-on-a-line/
 *
 * 注意：
 * 1. 重复点处理，不可以用特殊曲率来处理，否则会重复相加
 * 2. y相等处理
 * 3. x相等处理
 * 4. -0.0 != 0.0的处理
 */


public class MaxPoints {

    static Point point1 = new Point(1,2);
    static Point point3 = new Point(0,0);
    static Point point2 = new Point(3,6);
    static Point point4 = new Point(1,3);
    static Point point5 = new Point(1,2);
    //static ArrayList<Point> points = new ArrayList<Point>();
    static Point[] points = new Point[]{point1,point2,point3,point4,point5};

    public static void main(String[] args) {
        // write your code here

        System.out.println(maxPoints(points));
    }
    /**
     * @param points an array of point
     * @return an integer
     */
    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ?
                        Integer.MAX_VALUE :
                        0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }

}



 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      public Point(int a, int b) { x = a; y = b; }
  }

