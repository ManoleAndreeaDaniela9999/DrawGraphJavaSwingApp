package com.graf_app.graforientat;

import com.graf_app.GrafWindowListener;
import com.graf_app.GrafCanvas;
import com.graf_app.Node;
import com.graf_app.grafneorientat.GrafNeorientatCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Graf extends JFrame {

    private GrafCanvas canvas;
    boolean m_isOriented;

    Graf(boolean isOriented) {

        m_isOriented = isOriented;
        System.out.println("WindOpened");
        this.setTitle("Graf orientat");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 800);
        ImageIcon menuIcon = new ImageIcon("3rdParty\\Logo.png");
        this.setIconImage(menuIcon.getImage());
        this.getContentPane().setBackground(new Color(200, 191, 231));
        this.setVisible(true);
        if (isOriented) {
            canvas = new GrafOrientatCanvas();
        } else {
            canvas = new GrafNeorientatCanvas();
        }
        this.add(canvas, BorderLayout.CENTER);
        this.addWindowListener(new GrafWindowListener());
    }

    public static Graf initGraf(boolean isOriented) {
        Graf window;
        try {
            window = new Graf(isOriented);
        } catch (Exception e) {
            System.out.println("Graf initialization failed!");
            return null;
        }
        return window;
    }

    public void addNode(Node node) {
        canvas.addNode(node);
    }

    public Vector<Node> getNodeList() {
        return canvas.getNodeList();
    }
}
