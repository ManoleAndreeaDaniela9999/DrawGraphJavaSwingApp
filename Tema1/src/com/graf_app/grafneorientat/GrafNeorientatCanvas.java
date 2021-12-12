package com.graf_app.grafneorientat;

import com.graf_app.GrafCanvas;
import com.graf_app.Node;

import java.awt.*;
import java.util.Vector;

public class GrafNeorientatCanvas extends GrafCanvas {

    private Vector<Node> nodeList;
    private GrafNeorientatMouseAdapter grafNeorientatMouseAdapter;

    public GrafNeorientatCanvas(){

        nodeList = new Vector<Node>();
        this.setBackground(new Color(200, 191, 231));
        grafNeorientatMouseAdapter = new GrafNeorientatMouseAdapter();
        this.addMouseListener(grafNeorientatMouseAdapter);
        this.addMouseMotionListener(grafNeorientatMouseAdapter);
    }
    @Override
    public void addNode(Node node) {
        nodeList.addElement(node);
    }

    @Override
    public Vector<Node> getNodeList() {
        return nodeList;
    }
}
