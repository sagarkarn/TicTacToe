package tictactoe;
import java.awt.Color;
import tictactoe.TimePanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
public class PlayZone extends JPanel implements ActionListener {
	JButton[] b = new JButton[9];
	int[] a = new int[9];
	JLabel plr1,plr2,turn,time;
	JButton menu,pause;
	Font f;
	int win1 = 0,win2 = 0;
	String playerturn = null;
	int player = 1;
	String player1 = "player1",player2 = "player 2";
	int l = 0;
	boolean bool = true;
	JButton giveUp;
	JLabel tm;
	TimePanel tp;
	@SuppressWarnings("static-access")
	PlayZone() {
		System.out.println("PlayZone class is loading");
		setLayout(null);
		f = new Font("",Font.PLAIN,10);
		giveUp = new JButton("Give Ip");
		giveUp.setBounds(200,400,75,40);
		giveUp.addActionListener(this);
		giveUp.setFocusable(false);
		add(giveUp);
		tp = new TimePanel();
		tp.setBounds(0,400,75,40);
		add(tp);
		for(int i = 0; i < 9; i++)
		{
			b[i] = new JButton("");
			add(b[i]);
			b[i].setBackground(Color.WHITE);
			b[i].setSize(75,75);
			b[i].addActionListener(this);
			b[i].setFont(new Font("",Font.PLAIN,35));
			b[i].setFocusable(false);
		}
		b[0].setLocation(125,125);
		b[1].setLocation(200,125);
		b[2].setLocation(275,125);
		b[3].setLocation(125,200);
		b[4].setLocation(200,200);
		b[5].setLocation(275,200);
		b[6].setLocation(125,275);
		b[7].setLocation(200,275);
		b[8].setLocation(275,275);
		for(int i = 0; i < 9; i++)
			a[i] = 3+i;
		
		menu = new JButton("menu");
		menu.setFont(f);
		menu.setBorder(null);
		//menu.setBackground(Color.);
		
		menu.setBounds(440,2,50,20);
		add(menu);
		pause = new JButton("pause");
		pause.setFont(f);
		pause.setBorder(null);
		//pause.setBackground(Color.RED);
		pause.setBounds(440, 24, 50, 20);
		add(pause);
		plr1 = new JLabel("");
		plr2 = new JLabel("");
		plr1.setBounds(2, 2, 100, 20);
		plr2.setBounds(2,22,100,20);
		plr1.setFont(f);
		plr2.setFont(f);
		add(plr1);		add(plr2);
		turn = new JLabel(player1+ " turn");
		
		turn.setBounds(205,100,100,30);
		add(turn);
		tm = new JLabel("0S");
		tm.setBounds(205,50,100,50);
		add(tm);
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == giveUp)
		{
			
		
			if(player == 1)
			{
				playerturn = player2;
				JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
				clear();
				player = 2;
				turn.setText(player2 + " turn");
			}
			else
			{
				playerturn = player1;
				JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
				clear();
				player = 1;
				turn.setText(player1 + " turn");
			}
			
			
		}
		
		
		for(int i = 0; i < 9; i++)
		{
			if(ae.getSource() == b[i])
			{
				if(player == 1)
				{
					b[i].setText("O");
					b[i].removeActionListener(this);
					a[i] = 1;
					player = 2;
					turn.setText(player2 + " turn");
					playerturn = player1;
					l++;
				}
				else if(player == 2)
				{
					b[i].setText("X");
					b[i].removeActionListener(this);
					a[i] = 2;
					player = 1;
					turn.setText(player1 +" turn");
					playerturn = player2;
					l++;
				}
			}
		}
		if(a[0] == a[1] && a[1] == a[2]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			
			clear();
		}
		else if(a[0] == a[3] && a[3] == a[6]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			
			clear();
		}
		else if(a[0] == a[4] && a[4] == a[8]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(a[1] == a[4] && a[4] == a[7]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(a[2] == a[5] && a[5] == a[8]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(a[2] == a[4] && a[4] == a[6]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(a[3] == a[4] && a[4] == a[5]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(a[6] == a[7] && a[7] == a[8]) {
			JOptionPane.showMessageDialog(this, "player "+playerturn+" win");
			clear();
		}
		else if(l == 9) {
			bool = false;
			JOptionPane.showMessageDialog(this," barabari ka mukabla");
			clear();
		}
		
		
		
	}
	void clear()
	{
		System.out.println("Clear function called from Playzone class");
		for(int i = 0; i < 9; i++) {
			b[i].removeActionListener(this);
			b[i].addActionListener(this);
			a[i] = 3+i;
			b[i].setText("");
			l=0;
		}
		if(bool) {
			if(playerturn.equals(player1)) {
				win1++;
				plr1.setText(player1+" win = "+win1);
				
			}
			if(playerturn.equals(player2)) {
				win2++;
				plr2.setText(player2+" win = "+win2);
			}
		}
	}
	

}
