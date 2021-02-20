package com.trade.ui.elements.table;

import com.trade.ui.MainPanel;
import com.trade.utils.FileUtils;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Table extends JTable {

    MainPanel parentPanel;

    public void setParentPanel(MainPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public MainPanel getParentPanel() {
        return parentPanel;
    }

    public void init() {

        TableModel tableModel = new DefaultTableModel(
                new String[][]{{"1", "REN/USDT", "-", "-", "(B)", "1.05", "500"},
                {"2", "REN/USDT", "-", "-", "(B)", "1.08", "600"}},
                new String[]{"N", "Pair", "Sell Order", "Phase", "Side", "Price", "Qty"});

        this.setModel(tableModel);

        // JScrollPane scroll = new JScrollPane(this);
        // parentPanel.add(scroll);
        parentPanel.add(this.getTableHeader());
        parentPanel.add(this);
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);

        Table t = new Table();
//        TableModel tableModel = new DefaultTableModel(
//                new String[][]{{"1", "REN/USDT", "-", "-", "(B)", "1.05", "500"},
//                               {"2", "REN/USDT", "-", "-", "(B)", "1.08", "600"}},
//                new String[]{"N", "Pair", "Sell Order", "Phase", "Side", "Price", "Qty"});

        String[][] tlines = FileUtils.fetchFileDataToTableData("./src/main/resources/history/log.txt", 7);

        DefaultTableModel tableModel = new DefaultTableModel(
                tlines,
                new String[]{"N", "Pair", "Sell Order", "Phase", "Side", "Price", "Qty"});

        t.setModel(tableModel);
        t.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JPanel panelTable = new JPanel();
        JPanel panelBut = new JPanel();

        JButton addButton = new JButton("Add");
        JButton saveButton = new JButton("Save");
        JButton removeButton = new JButton("Remove");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int nextRowCnt = tableModel.getRowCount() + 1;
                Object[] newRow = {nextRowCnt, "REN/USDT", "-", "-", "(B)", "-", "-"};
                // remove selected row from the model
                tableModel.addRow(newRow);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (t.getSelectedRow() != -1) {
                    // remove selected row from the model
                    tableModel.removeRow(t.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row saved successfully");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (t.getSelectedRow() != -1) {
                    // remove selected row from the model
                    tableModel.removeRow(t.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });

        panelTable.add(t.getTableHeader(), BorderLayout.NORTH);
        panelTable.add(t, BorderLayout.CENTER);
        panelBut.add(addButton);
        panelBut.add(saveButton);
        panelBut.add(removeButton);

        main.add(panelTable);
        main.add(panelBut);
        f.add(main);

        f.setVisible(true);
    }
}
