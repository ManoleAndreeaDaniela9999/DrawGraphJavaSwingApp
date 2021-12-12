package com.graf_app.grafneorientat;

import com.graf_app.Arc;
import com.graf_app.GrafCanvas;
import com.graf_app.GraphicsDrawMethods;
import com.graf_app.Node;

import java.awt.*;
import java.util.Vector;

public class GrafNeorientatCanvas extends GrafCanvas {

    private Vector<Node> nodeList;
    private Vector<Arc> arcList;
    private GrafNeorientatMouseAdapter grafNeorientatMouseAdapter;

    public GrafNeorientatCanvas(){

        nodeList = new Vector<Node>();
        arcList = new Vector<Arc>();
        this.setBackground(new Color(200, 191, 231));
        grafNeorientatMouseAdapter = new GrafNeorientatMouseAdapter();
        this.addMouseListener(grafNeorientatMouseAdapter);
        this.addMouseMotionListener(grafNeorientatMouseAdapter);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Arc arc :
                arcList) {
            GraphicsDrawMethods.DrawSimpleArc(arc, g);
        }
        for (Node node :
                nodeList) {
            GraphicsDrawMethods.DrawNode(node, g);
        }
    }
    @Override
    public void addNode(Node node) {
        nodeList.addElement(node);
    }

    @Override
    public Vector<Node> getNodeList() {
        return nodeList;
    }

    @Override
    public void addArc(Arc arc) {

        for(Arc aux : arcList )
        {
            if(aux.getStartNode().getPosition() == arc.getStartNode().getPosition() &&
                    aux.getEndNode().getPosition() == arc.getEndNode().getPosition() && aux != arc )
            {
                System.out.println("Arc from" + arc.getStartNode() + "to" + arc.getEndNode() + "already exits !");
                return;
            }
        }
        arcList.addElement(arc);
    }

    @Override
    public Vector<Arc> getArcList() {
        return arcList;
    }
}
