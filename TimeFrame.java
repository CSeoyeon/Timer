import javax.swing.JFrame;
import java.awt.*;

public class TimeFrame extends JFrame{

   public TimeFrame() {
      this.setTitle("HUNTERxWATCH");
      this.setSize(380,270);
      this.setBackground(Color.white);
      
      
      TimePane timeWatchPl = new TimePane();
      this.add(timeWatchPl);
   

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   
   }

}