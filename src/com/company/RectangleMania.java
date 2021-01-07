package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RectangleMania {
    public static void main(String[] args) {
        Point[] coords = new Point[]{
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0),
                new Point(2, 1),
                new Point(2, 0),
                new Point(3, 1),
                new Point(3, 0)
        };
        System.out.println(rectangleMania(coords));

    }
    public static int rectangleMania(Point[] coords) {
        // Write your code here.
        Map<Integer, Set<Integer>> coordMap = new HashMap();

        populate(coordMap, coords);

        return count(coordMap, coords);
    };

    static int count(Map<Integer, Set<Integer>> map, Point[] coords) {
        int count = 0;
        for (Point a : coords) {
            for (Point b : coords) {
                if (!isBigger(a,b)) continue;
                if (map.get(a.x).contains(b.y) && map.get(b.x).contains(a.y))
                    count++;
            }
        }

        return count;
    }

    public static boolean isBigger(Point first, Point second) {
        return ((first.x < second.x && first.y < second.y));
    }


    public static void populate(Map<Integer, Set<Integer>> map, Point[] coords) {
        for (Point point : coords) {
            map.computeIfAbsent(point.x, h -> new HashSet<Integer>()).add(point.y);
        }

    }



    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
