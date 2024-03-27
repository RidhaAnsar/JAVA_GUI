
import java.awt.*;   
public class ChoiceExample {    
  
        ChoiceExample() {    
  
        Frame f = new Frame();    
  
        Choice c = new Choice();   
  
        c.setBounds(100, 100, 75, 75);    
  
        // adding items to the choice menu  
        c.add("Item 1");    
        c.add("Item 2");    
        c.add("Item 3");    
        c.add("Item 4");    
        c.add("Item 5");    
  
 
        f.add(c);    
  
        // setting size, layout and visibility of frame  
        f.setSize(400, 400);    
        f.setLayout(null);    
        f.setVisible(true);    
     }    
 
public static void main(String args[])    
{    
   new ChoiceExample();    
}    
}  