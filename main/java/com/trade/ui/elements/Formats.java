
package com.trade.ui.elements;

import java.text.DecimalFormat;

public class Formats extends java.text.DecimalFormat {
    
    public void init() {
        DecimalFormat format = new DecimalFormat("#.###");
        format.setGroupingUsed(true);
        format.setGroupingSize(3);
        format.setParseIntegerOnly(false);
    }
    
}
