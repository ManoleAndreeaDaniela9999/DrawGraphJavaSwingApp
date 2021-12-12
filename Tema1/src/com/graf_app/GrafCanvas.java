package com.graf_app;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public abstract class GrafCanvas extends JPanel {

    public abstract void addNode(Node node);
    public abstract Vector<Node> getNodeList();
}
