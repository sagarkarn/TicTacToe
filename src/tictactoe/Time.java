package tictactoe;
import tictactoe.TimePanel;
import tictactoe.PlayZone;
public class Time implements Runnable {
	int i;
	TimePanel tp;
	PlayZone pz;
	Thread t;
	Time(){
		System.out.println("Time class loading...");
	tp = new TimePanel();
	pz = new PlayZone();
	t = new Thread();
	}
	public void run()
	{
		System.out.println("Thread started");
		for(i = 1; i <= 10; i++)
		{
			pz.tp.setVisible(false);
			//pz.tp.setVisible(true);
			tp.l.setText(String.valueOf(i)+" S");
			System.out.println(String.valueOf(i)+"S");
			try {
				Thread.sleep(1000);
				
			}
			catch(Exception e) {
				System.out.print(e);
			}
			
		}
	}

}
