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
        Rectangle rec1 = rectangles[0];
        Rectangle rec2 = rectangles[1];

        if (spaceAbove(rec1,rec2)) {
            System.out.println("The rectangles do not intersect, the bottom of one rectangle is above the top of the other rectangle");
            return new Point[]{};
        } else if (spaceBetween(rec1,rec2)) {
            System.out.println("The rectangles do not intersect, the bottom of one rectangle is above the top of the other rectangle");
            return new Point[]{};
        }

        List<Point> intersections = new ArrayList<Point>();

        // check if they have the same interseting point
        // if they do, then check:
        //  if one rectangle's top is higher than the other's bottom
        //   in this case, the left side should also be to the left of the other's right side
        //  if one rectangles leftSide is to the left of the other rectangles right side
        //  both of the above cases should be intersection


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

    private Boolean spaceAbove(Rectangle rec1, Rectangle rec2) {
        return rec1.corners.get("bottomLeft").y > rec2.corners.get("topLeft").y ||
                rec2.corners.get("topLeft").y > rec1.corners.get("bottomLeft").y;
    }

    private Boolean spaceBetween(Rectangle rec1, Rectangle rec2) {
        return rec1.corners.get("bottomLeft").x > rec2.corners.get("bottomRight").x ||
                rec2.corners.get("bottomLeft").x > rec1.corners.get("bottomRight").x;
    }

}
