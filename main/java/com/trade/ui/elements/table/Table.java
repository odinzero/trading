package com.trade.ui.elements.table;

import com.trade.ui.MainPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Table  extends JTable{

    MainPanel parentPanel;

    public void setParentPanel(MainPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public MainPanel getParentPanel() {
        return parentPanel;
    }

    public void init() {

        TableModel tableModel = new DefaultTableModel(
                new String[][]{{"1", "REN/USDT", "-",  "-", "(B)","1.05", "500"},
                               {"2", "REN/USDT", "-",  "-", "(B)","1.08", "600"} },
                new String[]{"N", "Pair", "Sell Order", "Phase", "Side", "Price", "Qty"});
        
        this.setModel(tableModel); 
        
     // JScrollPane scroll = new JScrollPane(this);
     // parentPanel.add(scroll);
    
       parentPanel.add(this.getTableHeader());
       parentPanel.add(this);
    }
}
