package integerArray;

import java.util.*;

/**
 * Created by Lenovo on 2017/9/15.
 */


public class AirplanesIntheSky {
    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // solution 2
    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        // sort
        Collections.sort(airplanes, new Comparator<Interval>() {
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        int result = 1;
        for (int i = 0; i < airplanes.size(); i++) {
            Interval tmp = airplanes.get(i);
            int count = 1;
            for (int j = i + 1; j < airplanes.size(); j++) {
                if (airplanes.get(i).start > tmp.end) { // 没交集
                    result = Math.max(result, count);
                } else {
                    count++;
                    tmp.end = Math.min(tmp.end, airplanes.get(j).end);
                }
            }
        }
        return result;
    }

    // Solution 2:

    class Point {
        int time;
        int delta;

        Point(int time, int delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    public int countOfAirplanes1(List<Interval> airplanes) {

        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        List<Point> timePoints = new ArrayList<Point>(airplanes.size() * 2);
        for (Interval flight : airplanes) {
            timePoints.add(new Point(flight.start, 1));
            timePoints.add(new Point(flight.end, -1));
        }

        // Sort the flight time intervals
        Collections.sort(timePoints, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time == b.time) {
                    return a.delta - b.delta;
                } else {
                    return a.time - b.time;
                }
            }
        });

        int max = 0;
        int sum = 0;

        // Go through the time points
        for (Point p : timePoints) {
            sum += p.delta;
            max = Math.max(sum, max);
        }

        return max;
    }
}
