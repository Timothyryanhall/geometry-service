package com.tim.geometry.rectangle;

public class Point {
    int x,y;

    public Point(){
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }
    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        Point p = (Point) o;

        return x == ((Point) o).x && y == ((Point) o).y;
    }
}
