package com.trade.ui.elements;

import com.sun.java.accessibility.util.SwingEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.AttributedCharacterIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class SimpleTextPane extends JTextPane {
    
    DocumentListener docListener;

    public void setDocListener(DocumentListener docListener) {
        this.docListener = docListener;
    }

    public DocumentListener getDocListener() {
        return docListener;
    }

    public void initProfitLoss() {
        setEditorKit(new MyEditorKit());
        setEditable(false);
        setFont(new Font("Times New Roman", Font.BOLD, 18));
        setBackground(Color.lightGray);
        // 
       // getDocument().addDocumentListener(docListener); 
    }

    public void initBuy() {
        setEditorKit(new MyEditorKit());
        setEditable(false);
        setFont(new Font("Times New Roman", Font.BOLD, 20));
        setBackground(new Color(34, 177, 76));
        insertPaneText(" BUY ", buyAttributes()); 
    }
    
    public void initSell() {
        setEditorKit(new MyEditorKit());
        setEditable(false);
        setFont(new Font("Times New Roman", Font.BOLD, 20));
        setBackground(new Color(237, 28, 36));
        insertPaneText(" SELL ", sellAttributes());
    }
    
    public void insertPaneText(String txt, SimpleAttributeSet attributeSet) {
        try {
            StyledDocument doc = getStyledDocument();
            doc.setParagraphAttributes(0, doc.getLength(), attributeSet, false);
            
            doc.insertString(0, txt, attributeSet);
        } catch (BadLocationException ex) { }
    }
    
    public SimpleAttributeSet buyAttributes() {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setForeground(attributeSet, new Color(34, 177, 76));
        StyleConstants.setBackground(attributeSet, Color.orange);
        return attributeSet;
    }
    
    public SimpleAttributeSet sellAttributes() {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setForeground(attributeSet, new Color(237, 28, 36));
        StyleConstants.setBackground(attributeSet, Color.orange);
        return attributeSet;
    } 
    
    
     public SimpleAttributeSet profitAttributes() {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setForeground(attributeSet, Color.BLACK);
        
        setBackground(new Color(34, 177, 76));
        return attributeSet;
    }
     
      public SimpleAttributeSet lossAttributes() {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setForeground(attributeSet, Color.BLACK );
        
        setBackground(new Color(237, 28, 36));
        return attributeSet;
    }

    // !!! NOT USED !!!
//    public void buySet(String txt1, String txt2) {
//        SimpleAttributeSet attributeSet1 = new SimpleAttributeSet();
//        StyleConstants.setAlignment(attributeSet1, StyleConstants.ALIGN_CENTER);
//        StyleConstants.setBold(attributeSet1, true);
//        StyleConstants.setForeground(attributeSet1, new Color(34, 177, 76));
//        StyleConstants.setBackground(attributeSet1, Color.orange);
//        
//        SimpleAttributeSet attributeSet0 = new SimpleAttributeSet();
//        StyleConstants.setAlignment(attributeSet0, StyleConstants.ALIGN_CENTER);
//        StyleConstants.setBold(attributeSet0, true);
//        StyleConstants.setForeground(attributeSet0, Color.BLACK);
//        StyleConstants.setBackground(attributeSet0, Color.white);
//
//        SimpleAttributeSet attributeSet2 = new SimpleAttributeSet();
//        StyleConstants.setAlignment(attributeSet2, StyleConstants.ALIGN_CENTER);
//        StyleConstants.setBold(attributeSet2, true);
//        StyleConstants.setForeground(attributeSet2, new Color(237, 28, 36));
//        StyleConstants.setBackground(attributeSet2, Color.orange);
//
//        StyledDocument doc = getStyledDocument();
//        doc.setParagraphAttributes(0, doc.getLength(), attributeSet1, false);
//        try {
//            System.out.println("txt1: " + txt1);
//            System.out.println("txt2: " + txt2);
//            // doc.remove(0, 1);
//
//            doc.insertString(0, txt1, attributeSet1);
//
//            String allTxt = doc.getText(0, doc.getLength());
//
//            int lastB = allTxt.lastIndexOf("B");
//            int lastS = allTxt.lastIndexOf("S");
//
//            if (doc.getLength() > 0 && lastB != 0) {
//
//                System.out.println("las_len: " + lastB);
//
//                doc.remove(lastB, doc.getLength() - lastB);
//            }
//            
//            doc.insertString(0, " ", attributeSet0);
//            
//            
//            doc.insertString(0, txt2, attributeSet2);
//
//            if (doc.getLength() > 0 && lastS != 0) {
//
//                System.out.println("las_len: " + lastS);
//
//                doc.remove(lastS, doc.getLength() - lastS);
//            }
//
//            // doc.remove(txt1.length(), txt2.length());
//            // doc.insertString(doc.getLength(), txt2, attributeSet2);
//        } catch (BadLocationException ex) {
//        }
//    }

    class MyEditorKit extends StyledEditorKit {

        public ViewFactory getViewFactory() {
            return new StyledViewFactory();
        }

        class StyledViewFactory implements ViewFactory {

            public View create(Element elem) {
                String kind = elem.getName();
                if (kind != null) {
                    if (kind.equals(AbstractDocument.ContentElementName)) {

                        return new LabelView(elem);
                    } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                        return new ParagraphView(elem);
                    } else if (kind.equals(AbstractDocument.SectionElementName)) {

                        return new CenteredBoxView(elem, View.Y_AXIS);
                    } else if (kind.equals(StyleConstants.ComponentElementName)) {
                        return new ComponentView(elem);
                    } else if (kind.equals(StyleConstants.IconElementName)) {

                        return new IconView(elem);
                    }
                }

                return new LabelView(elem);
            }

        }
    }

    class CenteredBoxView extends BoxView {

        public CenteredBoxView(Element elem, int axis) {

            super(elem, axis);
        }

        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {

            super.layoutMajorAxis(targetSpan, axis, offsets, spans);
            int textBlockHeight = 0;
            int offset = 0;

            for (int i = 0; i < spans.length; i++) {

                textBlockHeight = spans[i];
            }
            offset = (targetSpan - textBlockHeight) / 2;
            for (int i = 0; i < offsets.length; i++) {
                offsets[i] += offset;
            }

        }
    }
}
