package integerArray;

import common.Point;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Lenovo on 2017/10/13.
 */
public class KClosestPoints {

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        // max heap
        PriorityQueue<Point> pq = new PriorityQueue<>(10, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                double d1 = distance(a, origin);
                double d2 = distance(b, origin);
                if (d1 == d2)
                {
                    if(b.x == a.x && b.y == a.y){
                        return 0;
                    }
                    else if(b.x>a.x || b.y>a.y){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                if (d1 < d2)
                {
                    return 1;
                }
                return -1;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        Point[] result = new Point[k];
        while (k>0)
        {
            k--;
            result[k] = (pq.poll());
        }

        return result;

    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
