package com.trade.ui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.springframework.util.ResourceUtils;

public class WatermarkTextField extends NumericTextField {

   BufferedImage img;
  //  ImageIcon img;

    TexturePaint texture;

    public boolean paintWatermark;

    public String positionWaterMark;

    public WatermarkTextField() {
        super();
        init();
    }

    public void init() {
        this.setEditable(true);
        setFont(new Font("TimesRoman", Font.BOLD, 14));
        
        switch(getPositionWaterMark()){
            default:break;
            case "LEFT_CENTER":
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case "RIGHT_CENTER":
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
        }
        
//        this.setMinimumSize(new Dimension(100,50));
//        this.setPreferredSize(new Dimension(100,50));
//        this.setBackground(Color.white);
//        this.setSize(100, 50);
    }

    public void setPaintWatermark(boolean paintWatermark) {
        this.paintWatermark = paintWatermark;
    }

    public boolean isPaintWatermark() {
        return paintWatermark;
    }
    
    public WatermarkTextField(File file, String position) {
       // super();
        this.positionWaterMark = position;
        
        setPositionWaterMark(positionWaterMark); 
        
        init();
        
        try {
    
//        String fileName = "resources/img/bitcoin.png";
//        ClassLoader classLoader = getClass().getClassLoader();
// 
//        File f = new File(classLoader.getResource(fileName).getFile());
        
          img = ImageIO.read(file);
//             URL url = WatermarkTextField.class.getResource(
//                                     "/resources/stackoverflow.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Rectangle rect = null;
//        rect = new Rectangle(4, (getHeight() - img.getHeight(null)) / 2, img.getWidth(null), img.getHeight(null));
   
 //       texture = new TexturePaint(img, rect);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (isPaintWatermark()) {
            g2.setPaint(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
//            g2.setPaint(texture);
             if (getPositionWaterMark().equals("LEFT_CENTER")) {
               // g.fillRect(5, (getHeight() - img.getHeight(null)) / 2, img.getWidth(null), img.getHeight(null));
                g2.drawImage(img, 5, (getHeight() - img.getHeight(null)) / 2, img.getWidth(null), img.getHeight(null), null);
            }
            if (getPositionWaterMark().equals("RIGHT_CENTER")) {
//                g.fillRect(getWidth() - img.getWidth(null) - 5, (getHeight() - img.getHeight(null)) / 2,
//                        img.getWidth(null), img.getHeight(null));
                g2.drawImage(img, getWidth() - img.getWidth(null) - 5, (getHeight() - img.getHeight(null)) / 2,
                        img.getWidth(null), img.getHeight(null), null);
          
            }
        } else {
            g2.setPaint(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }

    public void setPositionWaterMark(String positionWaterMark) {
        this.positionWaterMark = positionWaterMark;
    }

    public String getPositionWaterMark() {
        return positionWaterMark;
    }
    
    

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WatermarkTextField textfield = new WatermarkTextField(new File("./src/main/resources/img/M.png"), "RIGHT_CENTER");
        textfield.setPaintWatermark(true);
       // textfield.setPositionWaterMark("RIGHT_CENTER"); 
        textfield.setText("www.java2s.com");
        textfield.setBackground(Color.green);
        textfield.setMinimumSize(new Dimension(240, 50)); // +
        textfield.setPreferredSize(new Dimension(240, 50)); // +
        textfield.setMaximumSize(new Dimension(240, 50)); // +
        frame.getContentPane().add(textfield);
        frame.pack();
        frame.setVisible(true);
    }

}
