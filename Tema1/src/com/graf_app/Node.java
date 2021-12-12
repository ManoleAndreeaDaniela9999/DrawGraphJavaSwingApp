package com.graf_app;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Node {
    private Point position;
    private int diameter;
    private int number;
    public static int orderNumber = 0;

    public Node(Point position  , int diameter, int number )  {
        this.position = position;
        this.diameter = Math.max(diameter,20);
        this.number = number;
        orderNumber++;
    }

    public Point getPosition(){
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getDiam(){
        return diameter;
    }
    public int getRadius(){
        return diameter / 2;
    };
    public int getNumber() {return number;}
}
