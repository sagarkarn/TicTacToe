package tictactoe;
import javax.swing.*;
import tictactoe.PlayZone;
public class TimePanel extends JPanel{
	JLabel l;
	
	TimePanel()
	{
		l = new JLabel("00s");
		add(l);
		
		
	}
	class ThreadDemo extends Thread{
		
		public void run()
	{
		
		
		for(int i = 0; i < 10; i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.setText(String.valueOf(i));
		}
	}
	}
	

}
