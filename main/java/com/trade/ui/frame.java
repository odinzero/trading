package com.trade.ui;

import com.trade.ui.elements.menuBar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.WindowConstants;

public class frame extends JFrame {

    private menuBar mBar;
    private List frameComponents;
    private Object constaints;

    public void setMBar(menuBar mBar) {
        this.mBar = mBar;
    }

    public void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
        //setSize(new Dimension(600, 400));  
        setJMenuBar(mBar);
        pack();

        setVisible(true);
        setState(Frame.NORMAL);
        //show();
    }

    public void init2() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 400));

        MainPanel buttonPanel = new MainPanel();

        List list2 = new ArrayList<>();
        // list2.add(itemScrollPane);
        list2.add(buttonPanel);

        MainPanel mainPanel = new MainPanel();

        mainPanel.setPanelComponents(list2);
        mainPanel.init();

        setContentPane(mainPanel);

        setVisible(true);
        setState(Frame.NORMAL);
    }

    public void setConstaints(Object constaints) {
        this.constaints = constaints;
    }

    public Object getConstaints() {
        return this.constaints;
    }

    public void setFrameComponents(List frameComponents) {
        this.frameComponents = frameComponents;
    }

    public List getFrameComponents() {
        return frameComponents;
    }

    public void addAllComponents() {

        for (Iterator iter = frameComponents.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component, getConstaints());
            
            this.repaint();
            this.revalidate();
        }
    }
}
