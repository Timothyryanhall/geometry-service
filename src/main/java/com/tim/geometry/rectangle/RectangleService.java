package com.tim.geometry.rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectangleService {

    /**
     * Intersection: You must be able to determine whether two rectangles have one or more
     * intersecting lines and produce a result identifying the points of intersection.
     * @param rectangles to check for intersecting points
     * @return points of intersection
     */
    public Point[] intersections(Rectangle[] rectangles) {
        List<Point> intersections = new ArrayList<Point>();

        return intersections.toArray(new Point[intersections.size()]);


    }

    /**
     * You must be able to determine whether a rectangle is wholly contained within
     * another rectangle.
     * @param rectangles to check for containment
     * @return a boolean describing whether either of the rectangles is contained in the other
     */
    public Boolean contained(Rectangle[] rectangles) {
        return false;
    }

    /**
     * Implement the ability to detect whether two rectangles are adjacent. Adjacency is
     * defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial. A
     * sub-line share is a share where one side of rectangle A is a line that exists as a set of points
     * wholly contained on some other side of rectangle B, where partial is one where some line
     * segment on a side of rectangle A exists as a set of points on some side of Rectangle B.
     * @param rectangles to check for adjacency
     * @return a boolean describing whether any type of adjacency is present
     */
    public Boolean adjacency(Rectangle[] rectangles) {
        return false;
    }

}
