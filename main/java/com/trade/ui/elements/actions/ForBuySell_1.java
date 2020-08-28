package com.trade.ui.elements.actions;

import com.my.base.TextFieldKeyActions;
import com.trade.ui.elements.NumericTextField;
import com.trade.ui.elements.SimpleTextPane;
import com.trade.ui.elements.WatermarkTextField;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ForBuySell_1 extends TextFieldKeyActions implements ActionListener {

    public int choice;
    public String type;
    public NumericTextField tf1, tf2, tf3;
    public JLabel percentLabel;
    public JLabel feeLabel;
    SimpleTextPane cleanBuyField, cleanSellField, profitLossField;
    public Number cleanBuy, cleanSell;

    public void init() {
        switch (choice) {
            default:
                break;
            case 1:
                tf1.addKeyListener(this);
                tf2.addKeyListener(this);
                break;
            case 2:
                tf3.addKeyListener(this);
                tf3.addActionListener(this);
                break;
        }
    }

    public void setProfitLossField(SimpleTextPane profitLossField) {
        this.profitLossField = profitLossField;
    }

    public SimpleTextPane getProfitLossField() {
        return profitLossField;
    }

    public void setCleanBuyField(SimpleTextPane cleanBuyField) {
        this.cleanBuyField = cleanBuyField;
    }

    public void setCleanSellField(SimpleTextPane cleanSellField) {
        this.cleanSellField = cleanSellField;
    }

    public SimpleTextPane getCleanBuyField() {
        return cleanBuyField;
    }

    public SimpleTextPane getCleanSellField() {
        return cleanSellField;
    }

    public void setCleanBuy(Number cleanBuy) {
        this.cleanBuy = cleanBuy;
    }

    public Number getCleanBuy() {
        return cleanBuy;
    }

    public void setCleanSell(Number cleanSell) {
        this.cleanSell = cleanSell;
    }

    public Number getCleanSell() {
        return cleanSell;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPercentLabel(JLabel percentLabel) {
        this.percentLabel = percentLabel;
    }

    public JLabel getPercentLabel() {
        return percentLabel;
    }

    public void setFeeLabel(JLabel feeLabel) {
        this.feeLabel = feeLabel;
    }

    public JLabel getFeeLabel() {
        return feeLabel;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    public void setTf1(NumericTextField tf1) {
        this.tf1 = tf1;
    }

    public void setTf2(NumericTextField tf2) {
        this.tf2 = tf2;
    }

    public void setTf3(NumericTextField tf3) {
        this.tf3 = tf3;
    }

    public NumericTextField getTf1() {
        return tf1;
    }

    public NumericTextField getTf2() {
        return tf2;
    }

    public NumericTextField getTf3() {
        return tf3;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (choice) {
            default:
                break;
            case 1:
                try {
                    String s1 = tf1.getText();
                    String s2 = tf1.getText();
//            if(!s1.equals("")) {
                    //  tf1.normalize(); 
//            }
//            if(!s2.equals("")) {
                    //  tf2.normalize(); 
//            }
                    Long l1 = tf1.getLongValue();
                    Long l2 = tf2.getLongValue();
                    Long long_res = l1 * l2;
                    tf3.setValue(long_res);
                    // calculate fee
                    Number f = Fee(getType(), long_res);

                    switch (getType()) {
                        default:
                            break;
                        case "BUY":
                            if (f instanceof Long) {
                                cleanBuy = long_res - ((Long) f * l2);
                            }
                            if (f instanceof Double) {
                                cleanBuy = long_res - ((Double) f * l2);
                            }

                            profitLossField(round((double) cleanBuy, 2));
                            break;
                        case "SELL":
                            if (f instanceof Long) {
                                cleanSell = long_res - ((Long) f);
                            }
                            if (f instanceof Double) {
                                cleanSell = long_res - ((Double) f);
                            }

                            profitLossField(round((double) cleanSell, 2));
                            break;
                    }

                    // System.out.println("Value is (Long)" + long_res);
                } catch (ParseException e1) {
                    try {
                        Double d1 = tf1.getDoubleValue();
                        Double d2 = tf2.getDoubleValue();
                        Double d_res = d1 * d2;
                        tf3.setValue(d_res);
                        // calculate fee
                        Number f = Fee(getType(), d_res);

                        switch (getType()) {
                            default:
                                break;
                            case "BUY":
                                cleanBuy = d_res - ((Double) f * d2);

                                profitLossField(round((double) cleanBuy, 2));
                                break;
                            case "SELL":
                                cleanSell = d_res - ((Double) f);

                                profitLossField(round((double) cleanSell, 2));
                                break;
                        }
                        //System.out.println("Value is (Double)" + d_res);
                    } catch (ParseException e2) {
                        System.out.println(e2);
                    }
                }
                break;

            case 2:
                try {
                    // tf3.normalize();

                    Double d2 = tf2.getDoubleValue();
                    Double d3 = tf3.getDoubleValue();
                    Double res = d3 / d2;

                    System.out.println("d2: " + d2);
                    System.out.println("d3: " + d3);
                    System.out.println("res: " + res);

                    DecimalFormat df;
                    String str_num = null;

                    if (!tf3.getText().equals("")) {
                        // tf1.setValue(res);
                        df = new DecimalFormat("###.########");

                        // add tail zero if needed
                        str_num = addTailZero(df.format(round(res, 8)));
                        tf1.setText(str_num);

                        System.out.println("tf1: " + str_num);
                        System.out.println("DDD: " + Double.parseDouble(str_num));

                        // calculate fee
                        Number f = Fee(getType(), tf3.getDoubleValue());

                        Double new_d1 = tf1.getDoubleValue();
                        Double d_res = new_d1 * d2;
                        switch (getType()) {
                            default:
                                break;
                            case "BUY":
                                cleanBuy = d_res - ((Double) f * d2);

                                profitLossField(round((double) cleanBuy, 2));
                                break;
                            case "SELL":
                                cleanSell = d_res - ((Double) f);

                                profitLossField(round((double) cleanSell, 2));
                                break;
                        }

                    } else {
                        tf1.setText("");
                        feeLabel.setText("$" + " " + "0.0");
                    }

                    // calculateFee(res);
                    // System.out.println("tf3:" + percent_num);
                } catch (ParseException e1) {
                }
                break;
        }

    }

    public void profitLossField(Number trade) {

        switch (getType()) {
            default:
                break;
            case "BUY":
                String b = cleanBuyField.getText();
                cleanBuyField.setText("");
                cleanBuyField.insertPaneText(" " + trade + " ", cleanBuyField.buyAttributes());
                
               // profitLossField.setText("B"); 
                break;
            case "SELL":
                String s = cleanSellField.getText();
                cleanSellField.setText("");
                cleanSellField.insertPaneText(" " + trade + " ", cleanSellField.sellAttributes());
                
               // profitLossField.setText("S");
                break;
        }
        
        new ProfitLoss(cleanBuyField, cleanSellField, profitLossField).defineProfitOrLoss();
    }

//    public void profitLossField(Number trade) {
//
//        String txt = result_tf.getText();
//
//        if (getType().equals("BUY")) {
//            if (txt.equals("")) {
//              //  result_tf.setText(txt + "B:" + trade);
//              result_tf.buySet(txt + "B:" + trade, ""); 
//                System.out.println("b1");
//            }
//            if (txt.contains("B:") && !txt.contains("S:")) {
//                txt = "";
//               // result_tf.setText(txt + "B:" + trade);
//               result_tf.buySet(txt + "B:" + trade, "");
//               System.out.println("b2");
//            }
//            if (txt.contains("S:") && !txt.contains("B:")) {
//               // result_tf.setText(txt + " B:" + trade );
//               result_tf.buySet(txt , "B:" + trade); // " B:" + trade
//               System.out.println("b3");
//            }
//            if (txt.contains("B:") && txt.contains("S:")) {
//                
//                String[] t = txt.split(" ");
//                
//                //result_tf.setText(t[0] + " B:" + trade );
//                result_tf.buySet(t[0] , "B:" + trade); //  " B:" + trade
//                
//                System.out.println("B:::");
//            }
//        }
//
//        if (getType().equals("SELL")) {
//            if (txt.equals("")) {
//               // result_tf.setText(txt + "S:" + trade);
//               result_tf.buySet("", txt + "S:" + trade); 
//                System.out.println("s1");
//            }
//            if (txt.contains("S:") && !txt.contains("B:") ) {
//                txt = "";
//               // result_tf.setText(txt + "S:" + trade);
//               result_tf.buySet("", txt + "S:" + trade); 
//                System.out.println("s2");
//            }
//            if (txt.contains("B:") && !txt.contains("S:")) {
//               // result_tf.setText("S:" + trade + " " + txt );
//               result_tf.buySet(txt, "S:" + trade);
//                System.out.println("s3");
//            }
//            if (txt.contains("B:") && txt.contains("S:")) {
//                
//                String[] t = txt.split(" ");
//                
//               System.out.println("S::: " + t[0] + "  " + t[1]);
//                        
//              //  result_tf.setText("S:" + trade + " " + t[1] );
//              result_tf.buySet( t[1].trim(), "S:" + trade);
//            }
//        }
//    }
    public Number Fee(String type, Number num) {

        Number fee = null;

        switch (type) {
            default:
                break;
            case "BUY":
                Long l1;
                Double d1;
                try {
                    l1 = tf1.getLongValue();
                    fee = calculateFee(l1);
                } catch (ParseException ex) {
                    try {
                        d1 = tf1.getDoubleValue();
                        fee = calculateFee(d1);
                    } catch (ParseException ex1) {
                    }
                }
                return fee;
            case "SELL":
                if (num instanceof Long) {
                    fee = calculateFee((Long) num);
                }
                if (num instanceof Double) {
                    fee = calculateFee((double) num);
                }

                return fee;
        }
        return fee;
    }

    public double calculateFee(double res) {

        String[] percent = percentLabel.getText().split(" ");
        String without_percent = percent[1].substring(0, percent[1].length() - 1);
        double percent_num = Double.parseDouble(without_percent);

        double fee_num = (percent_num / 100) * res;

        String[] txt = feeLabel.getText().split(" ");

        switch (txt[0]) {
            default:
                break;
            case "BTC":
                DecimalFormat df = new DecimalFormat("###.########");
                // add tail zero if needed
                String str_num = addTailZero(df.format(round(fee_num, 8)));
                feeLabel.setText("BTC" + " " + str_num);
                return round(fee_num, 8);
            case "$":
                System.out.println("$");
                feeLabel.setText("$" + " " + round(fee_num, 2));
                System.out.println("fee: " + fee_num + "  " + round(fee_num, 2));
                return round(fee_num, 2);
        }
        return fee_num;
    }

    public String addTailZero(String str) {

        String[] str_num = str.split("\\.");

        int len;
        if (str_num.length == 2) {
            len = str_num[1].length();
        } else {
            len = -1;
        }

        switch (len) {
            default:
                break;
            case -1:
                return str;
            case 1:
                return str_num[0] + "." + str_num[1] + "0000000";
            case 2:
                return str_num[0] + "." + str_num[1] + "000000";
            case 3:
                return str_num[0] + "." + str_num[1] + "00000";
            case 4:
                return str_num[0] + "." + str_num[1] + "0000";
            case 5:
                return str_num[0] + "." + str_num[1] + "000";
            case 6:
                return str_num[0] + "." + str_num[1] + "00";
            case 7:
                return str_num[0] + "." + str_num[1] + "0";
        }

        return str;
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.CEILING);
        return bd.doubleValue();
    }

//    public void totalResult() {
//        
//        String fee_txt = feeLabel.getText();
//        String buy_txt = 
//                
//        switch (type) {
//            default:
//                break;
//            case "BUY":
//                break;
//            case "SELL":
//                break;
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("tf3 action");
    }

}
