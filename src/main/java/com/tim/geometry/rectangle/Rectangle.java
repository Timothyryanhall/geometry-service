package com.tim.geometry.rectangle;


import java.util.*;

public class Rectangle {
    private Point[][] units;
    private Map<String, Point[]> sides;
    private Map<String, Point> corners;
    private int width;
    private int height;
    private int area;

    public Rectangle() {
    }

    public Rectangle(String x1, String y1, String x2, String y2) {
        this.width = Integer.parseInt(x2) - Integer.parseInt(x1);
        this.height = Integer.parseInt(y1) - Integer.parseInt(y2);
        this.corners = assembleCorners(x1, y1, x2, y2);
        this.sides = assembleSides();
        this.area = (this.height + 1) * (this.width + 1);
        this.units = assembleUnits();
        this.unitsMap = assembleUnitsMap();
    }

    private Map<Integer, List<Integer>> assembleUnitsMap() {
        Map<Integer, List<Integer>> unitsMap = new HashMap<>();

        for (Point[] unitArr : this.units) {
            for (Point p : unitArr) {
                if (unitsMap.get(p.x) != null) {
                    unitsMap.get(p.x).add(p.y);
                } else {
                    unitsMap.put(p.x, new ArrayList<>(List.of(p.y)));
                }
            }
        }
        return unitsMap;
    }

    private Point[][] assembleUnits() {
        Point[][] units = new Point[this.height + 1][this.width + 1];

        for (int i = 0; i < this.height + 1; i++) {
            for (int j = 0; j < this.width + 1; j++) {
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
                "units: " + Arrays.deepToString(this.units) + "\n" +
                "unitsMap: " + Collections.singletonList(this.unitsMap);
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

    public void setUnits(Point[][] units) {
        this.units = units;
    }

    public void setUnitsMap(Map<Integer, List<Integer>> unitsMap) {
        this.unitsMap = unitsMap;
    }

    public void setSides(Map<String, Point[]> sides) {
        this.sides = sides;
    }

    public void setCorners(Map<String, Point> corners) {
        this.corners = corners;
    }

    private Map<Integer, List<Integer>> unitsMap;

    public Point[][] getUnits() {
        return units;
    }

    public Map<Integer, List<Integer>> getUnitsMap() {
        return unitsMap;
    }

    public Map<String, Point[]> getSides() {
        return sides;
    }

    public Map<String, Point> getCorners() {
        return corners;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return area;
    }


}
