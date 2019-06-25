package tictactoe;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
@SuppressWarnings("serial")
public class Players extends JPanel {
	JLabel p1,p2,error;
	JTextField plr1,plr2;
	JButton start;
	Players()
	{
		System.out.println("Player class loading...");
		setLayout(null);
		p1 = new JLabel("Player 1");
		p2 = new JLabel("player 2");
		p1.setBounds(70,200,100,40);
		p2.setBounds(70,250,100,40);
		add(p1);add(p2);
		plr1 = new JTextField();
		plr2 = new JTextField();
		plr1.setBounds(190,200,100,40);
		plr2.setBounds(190,250,100,40);
		add(plr1);
		add(plr2);
		start = new JButton("Start");
		start.setBounds(190,300,100,40);
		add(start);
		error = new JLabel();
		error.setBounds(70,150,200,30);
		error.setForeground(Color.RED);
		add(error);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("String drawing");
		Font f = new Font("",Font.BOLD,48);
		g.setFont(f);
		g.drawString("Enter player's name ", 20, 100);
		
	}

}
