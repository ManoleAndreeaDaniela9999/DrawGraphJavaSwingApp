package com.graf_app;

import com.graf_app.graforientat.Graf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainMenu extends JFrame implements ActionListener {

    private final ImageIcon menuIcon;
    //private LayoutManager menuLayout;
    private JPanel titlePanel;
    private JPanel buttonsPanel;
    private Button orientedGraf;
    private Button simpleGraf;
    public static int subWinRefCount;

    public static Graf m_grafOrientat;
    public static Graf m_grafNeorientat;

    private MainMenu() {
        subWinRefCount = 0;
        this.setTitle("Graf menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 500);
        menuIcon = new ImageIcon("3rdParty\\Logo.png");
        this.setIconImage(menuIcon.getImage());
        this.getContentPane().setBackground(new Color(200, 191, 231));
        addAWindowListener();
        InitPanels();
        MakeTitle();
        MakeButtons();
        this.setLayout(null);
        this.setVisible(true);
        subWinRefCount = 0;
        m_grafOrientat = null;
        m_grafNeorientat = null;
    }

    private void addAWindowListener() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Menu opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Menu closed");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Menu closed");
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
        });
    }

    private void InitPanels() {
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 420, 200);
        titlePanel.setOpaque(false);
        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(60, 200, 300, 200);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        this.add(titlePanel);
        this.add(buttonsPanel);
    }


    private void MakeTitle() {
        JLabel title = new JLabel("Graf application");
        title.setSize(30, 30);
        title.setIcon(menuIcon);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        Color titleColor = new Color(255, 18, 89);
        title.setForeground(titleColor);
        title.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        Border titleBorder = BorderFactory.createLineBorder(titleColor, 3);
        title.setBorder(titleBorder);
        titlePanel.add(title);
    }

    private void MakeButtons() {
        orientedGraf = new Button("Graf Orientat");
        // orientedGraf.setBounds(150,100, 420, 50 );
        orientedGraf.setFont(new Font("Comic Sans", Font.BOLD, 25));
        orientedGraf.setSize(420, 100); // ????
        orientedGraf.setForeground(Color.CYAN);
        orientedGraf.setBackground(new Color(255, 18, 89));
        orientedGraf.setFocusable(false);
        orientedGraf.addActionListener(this);

        simpleGraf = new Button("Graf Neorientat");
        //simpleGraf.setBounds(150,300, 100 ,50);
        simpleGraf.setFocusable(false);
        simpleGraf.setFont(new Font("Comic Sans", Font.BOLD, 25));
        simpleGraf.setSize(420, 100);
        simpleGraf.setForeground(Color.CYAN);
        simpleGraf.setBackground(new Color(255, 18, 89));
        simpleGraf.addActionListener(this);

        buttonsPanel.add(orientedGraf, BorderLayout.CENTER);
        buttonsPanel.add(simpleGraf, BorderLayout.CENTER);
    }

    //method to init a simple menu
    public static MainMenu initGrafMainMenu() {
        MainMenu menu;
        try {
            menu = new MainMenu();
        } catch (Exception e) {
            System.out.println("Main menu initialization failed!");
            return null;
        }
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (subWinRefCount > 0) System.out.println("A window is already opened");
        else {
            if (e.getSource() == orientedGraf) {
                m_grafOrientat = Graf.initGraf(true);
                System.out.println("You created oriented graph. \n ");
                subWinRefCount = 1;
                m_grafNeorientat = null;
            }
            if (e.getSource() == simpleGraf) {
                m_grafNeorientat = Graf.initGraf(false);
                System.out.println("You created simple graph. \n ");
                subWinRefCount = 1;
                m_grafOrientat = null;
            }
        }
    }

    public static void deactivateMainMenu(MainMenu menu) {
        //menu.setEnabled(false);
        subWinRefCount = 1;
    }

    public static void resetSubWinRefCount(MainMenu menu) {
        //menu.setEnabled(true);
        subWinRefCount = 0;
    }

}
