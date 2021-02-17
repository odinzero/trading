package com.trade.ui.elements.actions;

import com.trade.ui.MainPanel;
import com.trade.ui.frame;
import java.util.Iterator;
import java.util.List;

public class AllPanels {

    private List<MainPanel> panels;
    private frame frame;

    public void setPanels(List<MainPanel> panels) {
        this.panels = panels;
    }

    public List<MainPanel> getPanels() {
        return panels;
    }

    public void setFrame(frame frame) {
        this.frame = frame;
    }

    public frame getFrame() {
        return frame;
    }

    public void choiceCurrentContentPane(MainPanel currentPanel) {

        for (Iterator iter = panels.iterator(); iter.hasNext();) {
            MainPanel mp = (MainPanel) iter.next();
            mp.setVisible(false);
        }
        
        currentPanel.setVisible(true); 
        frame.setContentPane(currentPanel); 
    }

}
