import javax.swing.*;


import java.awt.*;

public class TimePane extends JPanel{

   public TimePane()  {
      this.setBackground(Color.white);
      
      //watch
      JLabel clock = new JLabel("00:00:00");
      clock.setFont(new Font("courier", Font.BOLD, 50));
      this.add(clock, BorderLayout.CENTER);
      
            
      //button
      JButton start = new JButton("念 수련 시작!");
      JButton stop = new JButton("휴식!");
      JButton finish = new JButton("수련 끝!");
      
      start.setBackground(Color.white);
      stop.setBackground(Color.yellow);
      finish.setBackground(Color.green);
      
      //button panel 
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
      buttonPanel.add(start);
      buttonPanel.add(stop);
      buttonPanel.add(finish);

      this.add(buttonPanel, BorderLayout.SOUTH);
      buttonPanel.setBackground(Color.white);
      
      TimeListener tl = new TimeListener(this, clock, start, stop, finish);
      
      this.addMouseListener(tl);
      clock.addMouseListener(tl);
      start.addMouseListener(tl);
      stop.addMouseListener(tl);
      finish.addMouseListener(tl);

   }
   

}