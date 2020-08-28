package com.trade.ui.elements;

//import com.calc.base.IActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {

    private ActionListener actionListener;
    private Image img;
    private int type = 0;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return this.type;
    }

    public void init() {
        this.addActionListener(actionListener); 
        setEnabled(true); 

        switch(getType()){
            case 0: setDefaultSize();break;
            case 1: setBigVerticalButton();break;
            case 2: setBigHorizontalButton();break;
           // case default: break; 
        }
//        try {
//            Image img = ImageIO.read(getClass().getResource("resources/img/water.bmp"));
//            this.setIcon(new ImageIcon(img));
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
    }
    
    public  void setDefaultSize() {
        //b.setSize(35, 25);
        setMinimumSize(new Dimension(45, 25));
        setPreferredSize(new Dimension(45, 25));
        setFont(new Font("TimesRoman", Font.PLAIN, 18));
        setMargin(new Insets(0, 0, 0, 0));
    }
    
    public  void setBigVerticalButton() {
        setMinimumSize(new Dimension(45, 55));
        setPreferredSize(new Dimension(45, 55));
        setFont(new Font("TimesRoman", Font.PLAIN, 18));
        setMargin(new Insets(0, 0, 0, 0));
    }

    public void setBigHorizontalButton() {
        setMinimumSize(new Dimension(90, 25));
        setPreferredSize(new Dimension(90, 25));
        setFont(new Font("TimesRoman", Font.PLAIN, 18));
        setMargin(new Insets(0, 0, 0, 0));
    }
    
    
    
}
