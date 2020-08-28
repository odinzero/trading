
package com.trade.ui.elements;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.JMenu;

public class menu extends JMenu {
    
    
    menu() {
      super();
    }
    
    menu(Action a) {
      super(a);  
    }
    
    menu(String s) {
        super(s);
    }
    
    menu(String s, boolean b) {
        super(s,b);
    }
    
     private List menuElements;
     
      public void setMenuElements(List menuElements) {
        this.menuElements = menuElements;
    }

    public List getMenuElements() {
        return menuElements;
    }
    
    public void init() {
        
        for (Iterator iter = menuElements.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
    
}
