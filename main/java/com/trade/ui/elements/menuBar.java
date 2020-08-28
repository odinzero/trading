
package com.trade.ui.elements;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.JMenuBar;

public class menuBar extends JMenuBar {
    
    private List menuBarComponents;

    public void setMenuBarComponents(List menuBarComponents) {
        this.menuBarComponents = menuBarComponents;
    }

    public List getMenuBarComponents() {
        return menuBarComponents;
    }
    
    public void init() {
        
        for (Iterator iter = menuBarComponents.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
}
