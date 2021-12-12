package com.graf_app.graforientat;

import com.graf_app.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GrafOrientatMouseAdapter extends MouseAdapter {

    private Point m_startPosition;
    private Point m_endPosition;

    private boolean m_isDragging;

    private boolean m_nodeWasFoundAtePoint;
    private Node m_nodeDragged;
    private boolean m_nodeWasMoved;

    public GrafOrientatMouseAdapter() {
        m_startPosition = new Point();
        m_endPosition = new Point();
        m_nodeDragged = null;
        m_isDragging = false;
        m_nodeWasFoundAtePoint = false;
        m_nodeWasMoved = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            Node node = new Node(e.getPoint(), 30, Node.orderNumber);
            System.out.println(" You created node " + Node.orderNumber + " at position " + m_startPosition);
            MainMenu.m_grafOrientat.addNode(node);
            MainMenu.m_grafOrientat.repaint();
            return;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        m_startPosition.setLocation( e.getPoint());

        Vector<Node> nodeList = MainMenu.m_grafOrientat.getNodeList();

        for (Node node : nodeList) {
            if (Point.distance(m_startPosition.x, m_startPosition.y, node.getPosition().x, node.getPosition().y) < node.getRadius()) {

                m_nodeDragged = node;
                m_nodeWasFoundAtePoint = true;
            }
        }
        m_isDragging = true;
        System.out.println("pressed at " + e.getPoint());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        super.mouseReleased(e);

        m_isDragging = false;

        m_endPosition.setLocation(e.getPoint());

        if (m_nodeWasMoved) {
            m_nodeWasMoved = false;
            System.out.println("You moved node " + m_nodeDragged.getNumber() + "from " + m_startPosition + "at " + e.getPoint());
        }
        m_nodeWasFoundAtePoint = false;
        System.out.println("released at " + e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        super.mouseDragged(e);

        if (m_nodeWasFoundAtePoint) {
            if(e.isAltDown())
            {
                System.out.println("ALT btn pressed");
                //TO DO : DRAW ARC
            }
            else {
                m_nodeWasMoved = true;
                m_nodeWasFoundAtePoint = true;
                m_nodeDragged.setPosition(e.getPoint());
                MainMenu.m_grafOrientat.repaint();
                System.out.println("mouse is dragging");
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
