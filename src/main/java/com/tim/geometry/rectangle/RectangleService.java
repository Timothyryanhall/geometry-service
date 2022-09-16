package com.tim.geometry.rectangle;


import java.util.*;

public class RectangleService {

    /**
     * Determines whether two rectangles have one or more intersecting lines.
     * @return points of intersection
     */
    public static List<Point> intersections(Rectangle rec1, Rectangle rec2) {
        List<Point> commonPoints = findCommonPoints(rec1,rec2);
        if (commonPoints.isEmpty()) {
            System.out.println("The rectangles do not intersect, there are no common points");
            return Collections.emptyList();
        }

        List<Point> commonSidePoints2 = findCommonSidePoints(rec1,rec2);
        if (commonSidePoints2.size() == 2 && commonPoints.size() > 2) {
            return commonSidePoints2;
        }

        System.out.println("There are more than two common side points, so the rectangle is adjacent, not intersecting");
        return Collections.emptyList();

    }

    private static List<Point> findCommonSidePoints(Rectangle rec1, Rectangle rec2) {
        List<Point> commonSides = new ArrayList<>();
        List<Point> rec1Sides = new ArrayList<>();
        List<Point> rec2Sides = new ArrayList<>();

        for (Point[] pArr : rec1.sides.values()) {
            rec1Sides.addAll(Arrays.asList(pArr));
        }
        for (Point[] pArr : rec2.sides.values()) {
            rec2Sides.addAll(Arrays.asList(pArr));
        }

        for (Point rec1Side : rec1Sides) {
            for (Point rec2Side : rec2Sides) {
                if (rec1Side.equals(rec2Side)) {
                    commonSides.add(rec1Side);
                }
            }
        }

        return commonSides;
    }

    /**
     * Determine whether a rectangle is wholly contained within another rectangle.
     * @return a boolean describing whether either of the rectangles is contained in the other
     */
    public static Boolean contained(Rectangle rec1, Rectangle rec2) {
        Point[] rec1units = Arrays.stream(rec1.units)
                .flatMap(Arrays::stream)
                .toArray(Point[]::new);

        Point[] rec2units = Arrays.stream(rec2.units)
                .flatMap(Arrays::stream)
                .toArray(Point[]::new);

        return Arrays.asList(rec1units).containsAll(Arrays.asList(rec2units)) ||
                Arrays.asList(rec2units).containsAll(Arrays.asList(rec1units));
    }

    /**
     * Detects whether two rectangles are adjacent.
     * @return a boolean describing whether any type of adjacency is present
     */
    public static Boolean adjacency(Rectangle rec1, Rectangle rec2) {
        List<Point> commonSidePoints = findCommonSidePoints(rec1,rec2);
        Boolean isContained = contained(rec1,rec2);
        return !isContained && commonSidePoints.size() > 2;
    }

    private static List<Point> findCommonPoints(Rectangle rec1, Rectangle rec2) {
        List<Point> commonEntries = new ArrayList<>();

        for (Integer key : rec1.unitsMap.keySet()) {
            if (rec2.unitsMap.containsKey(key)) {
                for (Integer value : rec1.unitsMap.get(key)) {
                    if (rec2.unitsMap.get(key).contains(value)){
                        commonEntries.add(new Point(key, value));
                    }
                }
            }
        }
        System.out.println("Common points: " + Arrays.toString(commonEntries.toArray()));
        return commonEntries;
    }

}
