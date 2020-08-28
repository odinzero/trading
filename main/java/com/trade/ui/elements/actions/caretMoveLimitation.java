package com.trade.ui.elements.actions;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class caretMoveLimitation implements CaretListener {

    JTextField tfield;
    int limit;
    
    public void init() {
        tfield.addCaretListener(this); 
    }

    public void setTfield(JTextField tfield) {
        this.tfield = tfield;
    }

    public JTextField getTfield() {
        return tfield;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

//    public static CaretListener limitName(final JTextField tfield, final int limit) {
//
//        CaretListener cl = new CaretListener() {
//
//            @Override
//            public void caretUpdate(CaretEvent e) {
//                limitation(e.getDot());
//            }
//
//            protected void limitation(final int dot) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (dot > limit) {
//                            tfield.setCaretPosition(0);
//                            String t = tfield.getText().substring(0, limit);
//                            tfield.setText("");
//                            tfield.setText(t);
//                        }
//                    }
//                });
//            }
//        };
//        return cl;
//    }
    protected void limitation(final int dot) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (dot > limit) {
                    tfield.setCaretPosition(0);
                    String t = tfield.getText().substring(0, limit);
                    tfield.setText("");
                    tfield.setText(t);
                }
            }
        });
    }

    @Override
    public void caretUpdate(CaretEvent e) {
          limitation(e.getDot());
    }
}
