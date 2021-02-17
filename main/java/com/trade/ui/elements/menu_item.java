
package com.trade.ui.elements;

import com.trade.ui.MainPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

public class menu_item  extends JMenuItem  {
    
    menu_item() {
        super(); 
    }
    
    menu_item(Action a) {
        super(a);
    }
    
    menu_item(String text) {
        super(text); 
    }
    
    menu_item(Icon icon) {
        super(icon); 
    }
    
    menu_item(String text, Icon icon){
        super(text,icon);
    }
    
    menu_item(String text, int mnemonic) {
        super(text, mnemonic); 
    }
    
     private List menuItemElements;
     
        public void setMenuItemElements(List menuItemElements) {
        this.menuItemElements = menuItemElements;
    }

    public List getMenuItemElements() {
        return menuItemElements;
    }
    
    public void init() {
        
        for (Iterator iter = menuItemElements.iterator(); iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
    
    
}
