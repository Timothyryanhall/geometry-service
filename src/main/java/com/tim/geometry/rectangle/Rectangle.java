package com.tim.geometry.rectangle;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rectangle {
    Point[][] units;
    Map<String, Point[]> sides;
    Map<String, Point> corners;
    int width;
    int height;
    int area;

    public Rectangle() {
    }

    public Rectangle(String x1, String y1, String x2, String y2) {
        this.width = Integer.parseInt(x2) - Integer.parseInt(x1);
        this.height = Integer.parseInt(y1) - Integer.parseInt(y2);
        this.corners = assembleCorners(x1, y1, x2, y2);
        this.sides = assembleSides();
        this.area = (this.height + 1) * (this.width + 1);
        this.units = assembleUnits();
    }

    private Point[][] assembleUnits() {
        Point[][] units = new Point[this.height + 1][this.width + 1];

        for (int i = 0; i < this.height + 1; i++) {
            for (int j = 0; j < this.width + 1; j++) {
                System.out.println(this.corners.get("topLeft").x + j + "," + (this.corners.get("topLeft").y - i));
                units[i][j] = new Point((this.corners.get("topLeft").x + j), (this.corners.get("topLeft").y - i));
            }
        }

        return units;
    }


    @Override
    public String toString() {
        StringBuilder leftSide = new StringBuilder();
        StringBuilder rightSide = new StringBuilder();
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        for (int i = 0; i < this.sides.get("leftSide").length; i++) {
            leftSide.append(this.sides.get("leftSide")[i]).append(" ");
            rightSide.append(this.sides.get("rightSide")[i]).append(" ");
        }
        for (int i = 0; i < this.sides.get("top").length; i++) {
            top.append(this.sides.get("top")[i]).append(" ");
            bottom.append(this.sides.get("bottom")[i]).append(" ");
        }

        return "width: " + this.width + "\n" +
                "height: " + this.height + "\n" +
                "topLeft: " + this.corners.get("topLeft").toString() + "\n" +
                "bottomRight: " + this.corners.get("bottomRight").toString() + "\n" +
                "topRight: " + this.corners.get("topRight").toString() + "\n" +
                "bottomLeft: " + this.corners.get("bottomLeft").toString() + "\n" +
                "top: " + top + "\n" +
                "bottom: " + bottom + "\n" +
                "leftSide: " + leftSide + "\n" +
                "rightSide: " + rightSide + "\n" +
                "area: " + this.area + "\n" +
                "units: " + Arrays.deepToString(this.units) + "\n";
    }


    private Map<String, Point[]> assembleSides() {
        Map<String, Point[]> sides = new HashMap<>();
        Point[] leftSide = new Point[height + 1];
        Point[] rightSide = new Point[height + 1];
        Point[] top = new Point[width + 1];
        Point[] bottom = new Point[width + 1];

        for (int i = 0; i < this.height + 1; i++) {
            leftSide[i] = new Point(this.corners.get("bottomLeft").x, this.corners.get("bottomLeft").y + i);
            rightSide[i] = new Point(this.corners.get("bottomRight").x, this.corners.get("bottomRight").y + i);
        }
        for (int i = 0; i < this.width + 1; i++) {
            top[i] = new Point(this.corners.get("topLeft").x + i, this.corners.get("topLeft").y);
            bottom[i] = new Point(this.corners.get("bottomLeft").x + i, this.corners.get("bottomRight").y);
        }

        sides.put("leftSide", leftSide);
        sides.put("rightSide", rightSide);
        sides.put("top", top);
        sides.put("bottom", bottom);

        return sides;
    }

    private Map<String, Point> assembleCorners(String x1, String y1, String x2, String y2) {
        Map<String, Point> corners = new HashMap<>();

        corners.put("topLeft", new Point(x1, y1));
        corners.put("bottomRight", new Point(x2, y2));
        corners.put("topRight", new Point(x2, y1));
        corners.put("bottomLeft", new Point(x1, y2));

        return corners;
    }
}
