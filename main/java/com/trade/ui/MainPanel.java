package com.trade.ui;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class MainPanel extends JPanel {

    private List panelComponents;
    private Object constaints;

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public List getPanelComponents() {
        return this.panelComponents;
    }

    public void setConstaints(Object constaints) {
        this.constaints = constaints;
    }

    public Object getConstaints() {
        return this.constaints;
    }

    public void init() {

        for (Iterator iter = panelComponents.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
              add(component, getConstaints());
        }
    }
}
