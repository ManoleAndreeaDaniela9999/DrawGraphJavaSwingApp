package com.graf_app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GrafWindowListener extends WindowAdapter {

    public GrafWindowListener() {

    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (MainMenu.m_grafOrientat!= null)
            System.out.println("You opened \"Graf Orientat\" window");
        if (MainMenu.m_grafNeorientat != null)
            System.out.println("You opened \"Graf Neorientat\" window");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window closed");
        MainMenu.resetSubWinRefCount();
        Node.orderNumber = 0;
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
