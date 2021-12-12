package com.graf_app.grafneorientat;

import com.graf_app.Arc;
import com.graf_app.MainMenu;
import com.graf_app.Node;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GrafNeorientatMouseAdapter extends MouseAdapter {
    private Point m_startPosition;
    private Point m_endPosition;
    private Point m_lastNodePosition;

    private boolean m_nodeWasFoundAtePoint;
    private Node m_nodeDragged;
    private boolean m_nodeWasMoved;

    private boolean m_drawArc;

    public GrafNeorientatMouseAdapter() {
        m_startPosition = new Point();
        m_endPosition = new Point();
        m_lastNodePosition = new Point();
        m_nodeDragged = null;
        m_nodeWasFoundAtePoint = false;
        m_nodeWasMoved = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            Vector<Node> nodeList = MainMenu.m_grafNeorientat.getNodeList();

            for (Node node : nodeList) {
                if (Point.distance(e.getX(),e.getY(), node.getPosition().x, node.getPosition().y) < node.getDiam()) {

                    System.out.println("Node already exists at " + e.getPoint());
                    return;
                }
            }

            Node node = new Node(e.getPoint(), 30, Node.orderNumber);
            System.out.println(" You created node " + node.getNumber() + " at position " + m_startPosition);
            MainMenu.m_grafNeorientat.addNode(node);
            MainMenu.m_grafNeorientat.repaint();
            return;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        m_startPosition.setLocation(e.getPoint());

        Vector<Node> nodeList = MainMenu.m_grafNeorientat.getNodeList();

        for (Node node : nodeList) {
            if (Point.distance(e.getX(), e.getY(), node.getPosition().x, node.getPosition().y) < node.getRadius()) {

                m_nodeDragged = node;
                m_lastNodePosition.setLocation((Point)node.getPosition().clone());
                m_nodeWasFoundAtePoint = true;
                break;
            }
        }

        System.out.println("pressed at " + e.getPoint());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        super.mouseReleased(e);

        Vector<Node> nodeList = MainMenu.m_grafNeorientat.getNodeList();

        if (m_nodeWasMoved) {
            m_nodeWasMoved = false;
            for (Node node : nodeList) {
                if (Point.distance(e.getX(), e.getY(), node.getPosition().x, node.getPosition().y) < node.getDiam() && m_nodeDragged != node) {
                    m_nodeDragged.setPosition(m_lastNodePosition);
                    System.out.println("You can't move one node over another! Point back at position " + m_lastNodePosition);
                    MainMenu.m_grafNeorientat.repaint();
                }
            }
            System.out.println("You moved node " + m_nodeDragged.getNumber() + "from " + m_startPosition + "at " + e.getPoint());
        }
        if (m_drawArc) {

            System.out.println("you draw");
            for (Node node : nodeList) {
                if (Point.distance(m_endPosition.x, m_endPosition.y, node.getPosition().x, node.getPosition().y) < node.getRadius()) {
                    //create arc
                    MainMenu.m_grafNeorientat.addArc(new Arc(m_nodeDragged, node));
                    System.out.println(" arc");
                    break;
                }
            }
            m_drawArc = false;
            MainMenu.m_grafNeorientat.repaint();
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

            } else {
                m_drawArc = false;
                m_nodeWasMoved = true;
                System.out.println("mouse is dragging");
                m_nodeDragged.setPosition(e.getPoint());
            }

            MainMenu.m_grafNeorientat.repaint();
        }
    }
}