package com.tim.geometry.rectangle;

import java.io.PrintStream;
import java.lang.reflect.Field;

public class Rectangle {
    Point topLeft;
    Point bottomRight;
    Point bottomLeft;
    Point topRight;
    int width;
    int height;


    public Rectangle() {
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.width = bottomRight.x - topLeft.x;
        this.height = topLeft.y - bottomRight.y;

        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.topRight = new Point(bottomRight.x, topLeft.y);
        this.bottomLeft = new Point(topLeft.x, bottomRight.y);
    }

    public Rectangle(String x1, String y1, String x2, String y2) {
        this.width = Integer.parseInt(x2) - Integer.parseInt(x1);
        this.height = Integer.parseInt(y1) - Integer.parseInt(y2);

        this.topLeft = new Point(x1, y1);
        this.bottomRight = new Point(x2,y2);
        this.topRight = new Point(x2, y1);
        this.bottomLeft = new Point(x1, y2);
    }

    @Override
    public String toString() {
        return "width: " + this.width + "\n" +
                "height: " + this.height + "\n" +
                "topLeft: " + this.topLeft.toString() + "\n" +
                "bottomRight = " + this.bottomRight.toString() + "\n" +
                "topRight = " + this.topRight.toString() + "\n" +
                "bottomLeft = " + this.bottomLeft.toString() + "\n";
    }

}
