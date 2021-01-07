package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 Write a function that takes in a list of Cartesian coordinates (i.e., (x, y) coordinates)
  and returns the number of rectangles formed by these coordinates.


A rectangle must have its four corners amongst the coordinates
 in order to be counted, and we only care about rectangles with
 sides parallel to the x and y axes (i.e., with rectangles horizontal
  and vertical sides--no diagonal sides).


 You can also assume that no coordinate will be farther than 100 units from the origin.

given
input = [
  [0, 0], [0, 1], [1, 1], [1, 0],
  [2, 1], [2, 0], [3, 1], [3, 0],
]
example should return 6
 */
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
