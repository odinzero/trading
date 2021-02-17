
package com.trade.ui.elements.actions;

import com.trade.ui.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class MenuItemAction implements ActionListener {
    
    AllPanels allPanels;
    private MainPanel currentPanel;
    private JMenuItem item;
    
     public void init() {
        item.addActionListener(this);
    }

    public void setAllPanels(AllPanels allPanels) {
        this.allPanels = allPanels;
    }

    public AllPanels getAllPanels() {
        return allPanels;
    }

    public void setItem(JMenuItem item) {
        this.item = item;
    }

    public JMenuItem getItem() {
        return item;
    }
    
     public void setCurrentPanel(MainPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    public MainPanel getCurrentPanel() {
        return currentPanel;
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       // System.out.println("== HHH == : " + getCurrentPanel()  );
        
        allPanels.choiceCurrentContentPane(getCurrentPanel());
    }
}
