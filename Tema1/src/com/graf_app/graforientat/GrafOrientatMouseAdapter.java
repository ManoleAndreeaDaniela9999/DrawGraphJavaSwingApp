package com.graf_app.graforientat;

import com.graf_app.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GrafOrientatMouseAdapter extends MouseAdapter {

    private Point m_lastNodePosition;

    private boolean m_nodeWasFoundAtePoint;
    private Node m_nodeDragged;
    private boolean m_nodeWasMoved;

    private boolean m_drawArc;

    public GrafOrientatMouseAdapter() {
        m_lastNodePosition = new Point();
        m_nodeDragged = null;
        m_nodeWasFoundAtePoint = false;
        m_nodeWasMoved = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            Vector<Node> nodeList = MainMenu.m_grafOrientat.getNodeList();

            for (Node node : nodeList) {
                if (Point.distance(e.getX(),e.getY(), node.getPosition().x, node.getPosition().y) < node.getDiam()) {

                    System.out.println("Node already exists at " + e.getPoint());
                    return;
                }
            }

            Node node = new Node(e.getPoint(), 30, Node.orderNumber);
            System.out.println(" You created node " + node.getNumber() + " at position " + e.getPoint());
            MainMenu.m_grafOrientat.addNode(node);
            MainMenu.m_grafOrientat.repaint();
            return;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        Vector<Node> nodeList = MainMenu.m_grafOrientat.getNodeList();

        for (Node node : nodeList) {
            if (Point.distance(e.getX(), e.getY(), node.getPosition().x, node.getPosition().y) < node.getRadius()) {

                m_nodeDragged = node;
                m_lastNodePosition.setLocation(node.getPosition());
                m_nodeWasFoundAtePoint = true;
                break;
            }
        }

        System.out.println("pressed at " + e.getPoint());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        super.mouseReleased(e);

        Vector<Node> nodeList = MainMenu.m_grafOrientat.getNodeList();

        if (m_nodeWasMoved) {
            m_nodeWasMoved = false;
            for (Node node : nodeList) {
                if (Point.distance(e.getX(), e.getY(), node.getPosition().x, node.getPosition().y) < node.getDiam() && m_nodeDragged != node) {
                    m_nodeDragged.setPosition(m_lastNodePosition.getLocation());
                    System.out.println("You can't move one node over another! Point back at position " + m_lastNodePosition);
                    MainMenu.m_grafOrientat.repaint();
                }
            }
            System.out.println("You moved node " + m_nodeDragged.getNumber() + "from " + e.getPoint() + "at " + e.getPoint());
        }
        if (m_drawArc) {

            System.out.println("you draw");
            for (Node node : nodeList) {
                if (Point.distance(e.getX(), e.getY(), node.getPosition().x, node.getPosition().y) < node.getRadius()) {
                    //create arc
                    MainMenu.m_grafOrientat.addArc(new Arc(m_nodeDragged, node));
                    System.out.println(" arc");
                    break;
                }
            }
            m_drawArc = false;
            MainMenu.m_grafOrientat.repaint();
        }
        m_nodeWasFoundAtePoint = false;
        System.out.println("released at " + e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        if (m_nodeWasFoundAtePoint) {
            if (e.isAltDown()) {
                System.out.println("ALT btn pressed");
                m_drawArc = true;
                //draw arc from node to dragged location to e point
                GraphicsDrawMethods.DrawLine(m_lastNodePosition,e.getPoint(),MainMenu.m_grafOrientat.getGraphics());

            } else {
                m_drawArc = false;
                m_nodeWasMoved = true;
                System.out.println("mouse is dragging");
                m_nodeDragged.setPosition(e.getPoint());
            }

            MainMenu.m_grafOrientat.repaint();
        }
    }
}
