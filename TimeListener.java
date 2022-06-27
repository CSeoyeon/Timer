import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Runnable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TimeListener implements MouseListener {

   JPanel panel;
   JLabel clockLabel, saveLabel;
   JButton startBtn, stopBtn, finishBtn;
   Thread timeThread;

   public TimeListener(JPanel cpanel, JLabel clock, JButton startButton, JButton stopButton, JButton finishButton) {
      this.panel = cpanel;
      this.clockLabel = clock;
      this.startBtn = startButton;
      this.stopBtn = stopButton;
      this.finishBtn = finishButton; 
   } 
 

   public void mouseClicked(MouseEvent e){
    
   //시작 버튼 
      if((JButton)e.getSource() == startBtn) {
         clockLabel.setText("00:00:00");
         System.out.println("실행 시작");
         startBtn.setText("念 수련 시작!");
         
         
         timeThread = new Thread(new Runnable() {
      
            @Override
            public void run(){
               int time = (int)System.currentTimeMillis()/1000;

               while(timeThread == Thread.currentThread()){
                  int currentTime = (int)System.currentTimeMillis()/1000;
                  int realTime = currentTime - time;
               
                  int hour=  realTime % (1000*60) / 100 / 60 ;
					   int min = realTime % (1000*60) / 100 % 60 ;
						int sec  = realTime % 100;
               
                  
                  String timeBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
                  clockLabel.setText(timeBuffer);

                  try {
                     Thread.sleep(10);
                  } 

                  catch (InterruptedException e){ 
                     System.out.println("실행 종료");
                     break;
                  } 
               }
            }
      });


         timeThread.start();
         startBtn.setEnabled(false);
         stopBtn.setEnabled(true);
         finishBtn.setEnabled(true);

      }

   //일시 중시 버튼 
      if((JButton)e.getSource() == stopBtn){
      timeThread =null;
      System.out.println("일시 중지");

      startBtn.setText("다시 시작");
      startBtn.setEnabled(true);
      stopBtn.setEnabled(false);
      finishBtn.setEnabled(false);
      
      }

   //실행 종료 버튼 
      if((JButton)e.getSource() == finishBtn) {
      timeThread.interrupt();      
      startBtn.setEnabled(true);
      stopBtn.setEnabled(false);
     
      
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