package com.trade.ui.elements.actions;

import com.trade.ui.elements.SimpleTextPane;
import com.trade.utils.Utils;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProfitLoss {

    SimpleTextPane buyPane, sellPane, profitLossPane;

    public ProfitLoss(SimpleTextPane buyPane, SimpleTextPane sellPane, SimpleTextPane profitLossPane) {
        this.buyPane = buyPane;
        this.sellPane = sellPane;
        this.profitLossPane = profitLossPane;
    }

    public void setBuyPane(SimpleTextPane buyPane) {
        this.buyPane = buyPane;
    }

    public SimpleTextPane getBuyPane() {
        return buyPane;
    }

    public void setSellPane(SimpleTextPane sellPane) {
        this.sellPane = sellPane;
    }

    public SimpleTextPane getSellPane() {
        return sellPane;
    }

    public void setProfitLossPane(SimpleTextPane profitLossPane) {
        this.profitLossPane = profitLossPane;
    }

    public SimpleTextPane getProfitLossPane() {
        return profitLossPane;
    }

    public void defineProfitOrLoss() {

        String buyTxt = buyPane.getText().trim();
        String sellTxt = sellPane.getText().trim();

        if ((!buyTxt.equals("") && !sellTxt.equals("")) && (!buyTxt.equals("BUY") && !sellTxt.equals("SELL"))) {

            double num = Double.parseDouble(sellTxt) - Double.parseDouble(buyTxt);

            // System.out.println("=== defineProfitOrLoss ==== num : " + buyTxt);
            profitLossPane.setText("");

            if (num > 0) {
                profitLossPane.insertPaneText(" " + Utils.round(num, 2) + " ", profitLossPane.profitAttributes());
            } else {
                profitLossPane.insertPaneText(" " + Utils.round(num, 2) + " ", profitLossPane.lossAttributes());
            }

        }

    }

}
