package com.graf_app.graforientat;

import com.graf_app.GrafCanvas;
import com.graf_app.Node;

import java.awt.*;
import java.util.Vector;

public class GrafOrientatCanvas extends GrafCanvas {

    private Vector<Node> nodeList;
    private GrafOrientatMouseAdapter grafOrientatMouseAdapter;
    GrafOrientatCanvas() {
        nodeList = new Vector<Node>();
        this.setBackground(new Color(200, 191, 231));
        grafOrientatMouseAdapter = new GrafOrientatMouseAdapter();
        this.addMouseListener(grafOrientatMouseAdapter);
        this.addMouseMotionListener(grafOrientatMouseAdapter);
    }

    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
        for (Node node :
                nodeList) {
            GraphicsDrawMethods.DrawNode(node, g);
        }
    }

    public void addNode(Node node) {
        nodeList.addElement(node);
    }

    public Vector<Node> getNodeList() {
        return nodeList;
    }
}
