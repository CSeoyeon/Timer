import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class TimeListener implements MouseListener {

   JPanel panel;
   JLabel clockLabel, saveLabel;
   JButton startBtn, stopBtn, finishBtn;


   public TimeListener(JPanel cpanel, JLabel clock, JButton startButton, JButton stopButton, JButton finishButton) {
      this.panel = cpanel;
      this.clockLabel = clock;
      this.startBtn = startButton;
      this.stopBtn = stopButton;
      this.finishBtn = finishButton;
   }

   public void mouseClicked(MouseEvent e){
      int time = (int)System.currentTimeMillis()/1000;
      Thread timeThread = new Thread() {
           @Override
           public void run() {
                while(true){
                     int currentTime = (int)System.currentTimeMillis()/1000;
                     int realTime = currentTime - time;
                     
                     int hour = realTime / 3600;
                     int min = realTime / 60 -(hour*60);
                     int sec = realTime % 60;


                     String timeBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
                     clockLabel.setText(timeBuffer);

                     try {
                        Thread.sleep(10);
                     } 
                     catch (InterruptedException e){ 
                        System.out.println("실행 종료");
                        clockLabel.setText("00:00:00");
                     } 
                }
           }
      };


   //시작 버튼 
    if((JButton)e.getSource() == startBtn) {
      clockLabel.setText("00:00:00");
      System.out.println("실행 시작");

      timeThread.start();
   }

   //일시 중시 버튼 
   if((JButton)e.getSource() == stopBtn){
      //stopBtn.setText("다시 시작!");
      System.out.println("일시 중지");
      double infinity = Double.POSITIVE_INFINITY;
      int inf = (int)infinity;

      //일시 중지 수정 필요 
      try {
         
            Thread.sleep(10000);
       } 
    catch (InterruptedException ex){}
    stopBtn.setText("휴식!");
   }

   //실행 종료 버튼 
   if((JButton)e.getSource() == finishBtn) {
      timeThread.interrupt();      
      
     
      
      //경과 시간 저장 
      saveLabel = clockLabel;
      clockLabel.setText(saveLabel.getText());
      System.out.println(saveLabel.getText());
   }


   
   }

   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mousePressed(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}




   
}