package com.exceptions;
class Point implements Cloneable{
    private int x, y;
    public Point(int x, int y) {
           this.x = x;
           this.y = y;
    }
    public void setX(int x) {
           this.x = x;
    }
    public void setY(int y) {
           this.y = y;
    }
    public String toString() {
           return "(" + x + ", " + y + ")";
    }
    public Point clone() throws CloneNotSupportedException{
    	Point p = (Point)super.clone();
           return p;
    }
}

public class Point_Object_Cloning{
    public static void main(String[] args) throws CloneNotSupportedException {
           try {
                Point p1 = new Point(10, 20);
                Point p2 = p1;
                Point p3 = p1.clone();
                p1.setX(100);
                p1.setY(200);
                System.out.println(p1 + " , " + p2 + ", " + p3);
           }
           catch(CloneNotSupportedException e) {
                  System.out.println("clone() not supported");
            }
     }
}
