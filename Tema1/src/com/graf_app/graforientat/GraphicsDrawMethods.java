package com.graf_app.graforientat;

import com.graf_app.Node;

import java.awt.*;

public class GraphicsDrawMethods {

     static boolean DrawNode(Node node, Graphics g)
    {
        if(Node.orderNumber > 99)
        {
            System.out.println("Max node number reached! ");
            return false;
        }
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.BOLD, node.getRadius()));
        g.fillOval(node.getPosition().x - node.getRadius(), node.getPosition().y - node.getRadius(), node.getDiam(), node.getDiam());
        g.setColor(Color.WHITE);
        g.drawOval(node.getPosition().x - node.getRadius(), node.getPosition().y - node.getRadius(), node.getDiam(), node.getDiam());
        if(node.getNumber() < 10)
        g.drawString( "0" + node.getNumber(), node.getPosition().x - node.getRadius() / 2,
                                                        node.getPosition().y + node.getRadius() /2);
        else
            g.drawString(  "" + node.getNumber(), node.getPosition().x - node.getRadius() / 2,
                    node.getPosition().y + node.getRadius() /2);
        return true;
    }

}
