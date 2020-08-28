
package com.my.launcher;


import java.awt.Color;
import javax.swing.JLabel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launcher {
    public void launch() {
       // String[] contextPaths = new String[] {"main/java/todo/app-context.xml"};
//        String[] contextPaths = new String[] {"classpath*:app-context.xml"};
//        new ClassPathXmlApplicationContext(contextPaths);
       JLabel l = new JLabel("text");
       Color colorBuy = new Color(34,177,76);  
      /// l.setHorizontalAlignment(JLabel.); 
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:context.xml");
        
       String[] c =  context.getBeanDefinitionNames();
        for (int i = 0; i < c.length; i++) {
            String string = c[i];
           // System.out.println(string);
        }
        
    }
}
